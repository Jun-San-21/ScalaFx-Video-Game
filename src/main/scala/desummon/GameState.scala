package desummon
import scalafx.scene.canvas.Canvas
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.media.{Media, MediaPlayer}

import scala.collection.mutable
import scala.collection.mutable.ListBuffer
import scala.util.Random

class GameState(gc: GraphicsContext, sprite: Sprite, player: Player, enemy: Enemy) {
  val width: Double = gc.canvas.getWidth
  val height: Double = gc.canvas.getHeight
  var gameOver = false
  var victory: Boolean = false
  private var maxRadius = 300
  //ad-hoc polymorphism/ function overloading
  def drawState(): Unit = {
    //draw enemy
    val centerDistance = enemy.getDistance
    val distance = enemy.getDistance(player.currentX, player.currentY)
    var currentEnemyImage = sprite.getCurrentSprite(sprite.enemyIdle)
    if (distance > 1 && distance < maxRadius) {
      currentEnemyImage = sprite.getCurrentSprite(sprite.enemyCharge)
      enemy.moveToPlayer()
      val spriteRadius = ((sprite.enemyIdle.head).getWidth) / 2
      enemy.checkCharacterBounds(width, height, spriteRadius)
    } else if (centerDistance > 10) {
      enemy.returnToCenter()
    }
    //draw player
    player.updatePosition()
    val spriteRadius = (sprite.spriteImagesIdle.head.getWidth) / 2
    player.checkCharacterBounds(width, height, spriteRadius)
    var currentSpriteImages = sprite.spriteImagesIdle

    if (!player.isCharacterIdle) {
      currentSpriteImages = player.getCurrentDirection match {
        case 0 => sprite.spriteImagesW
        case 1 => sprite.spriteImagesA
        case 2 => sprite.spriteImagesS
        case 3 => sprite.spriteImagesD
        case _ => sprite.spriteImagesW // Default to W if the direction is not recognized
      }
    }
    gc.clearRect(0, 0, gc.canvas.getWidth, gc.canvas.getHeight)
    gc.drawImage(sprite.getCurrentSprite(currentSpriteImages), player.currentX, player.currentY)
    gc.drawImage(currentEnemyImage, enemy.currentX, enemy.currentY)

  }

  def drawState(collectiblesBuffer: ListBuffer[Collectible]): Unit = {
    for (i <- collectiblesBuffer) {
      i.collectItemCheck(player, sprite)

      if (i.isPlaced){
        gc.drawImage(sprite.getCurrentSprite(sprite.collectibles),i.x, i.y)
      } else if (!i.isPlaced) {
        player.addCollectible()
        collectiblesBuffer -= i
        player.health = player.health + 5
        enemy.health = enemy.health - Random.nextInt(5)
      }

    }
    if (collectiblesBuffer.isEmpty) {
      enemy.isVulnerable = true
    }
  }
  //subtype polymorphism
  def applyDamage(character: Character, attack: Attack): Unit = {
    //pattern match
    character match {
      case _: Player =>
        if (enemy.getDistance(player.currentX, player.currentY) < 30) {
          player.takeDamage()
        }
      case _: Enemy =>
        if (enemy.isVulnerable && player.currentX >= enemy.centerX && player.currentX <= enemy.centerX + 100
          && player.currentY >= enemy.centerY && player.currentY <= enemy.centerY + 100) {
          if (attack.isAttacking) {
            gc.drawImage(sprite.getCurrentSprite(sprite.fireSpell), enemy.currentX - 40, enemy.currentY - 40)
            enemy.takeDamage()
          }
        }
      case _ =>
    }
  }
  def checkVictoryOrDefeat(): Unit = {

    if (enemy.health == 0) {
      val death = new Media(getClass().getResource("/audio/demondeath.mp3").toString)
      val demonPlayer = new MediaPlayer(death) {
        autoPlay = true
      }
      gc.drawImage(sprite.enemyDeath.head, enemy.currentX, enemy.currentY)
      gameOver = true
      victory = true
      demonPlayer.play()
    } else if (player.health == 0) {
      val death = new Media(getClass().getResource("/audio/deathsound.mp3").toString)
      val deathPlayer = new MediaPlayer(death) {
        autoPlay = true
      }
      //death image
      gameOver = true
      victory = false
      deathPlayer.play()
    }
  }
  def applyBuff(character: Character, collectibles: ListBuffer[Collectible]): Unit = {
    if (collectibles.isEmpty) {
      if(character.isInstanceOf[Enemy]) {
        enemy.movementSpeed = 2.5
        maxRadius = 500
      }
      if(character.isInstanceOf[Player]) {
        player.movementSpeed = 1.6
      }
    }
  }

}