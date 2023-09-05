package desummon

import scalafx.animation.{KeyFrame, Timeline}
import scalafx.scene.media.{Media, MediaPlayer}

import scala.concurrent.duration.Duration

class Collectible(val x: Double, val y: Double) {
  private val collect = new Media(getClass().getResource("/audio/burningflame.mp3").toString)
  private val collectPlayer = new MediaPlayer(collect)
  var isPlaced = true
  //check if item is collected
  def collectItemCheck(player: Player, sprite: Sprite) = {
    if (x >= player.currentX && x <= player.currentX + 64 && y >= player.currentY && y <= player.currentY + 64) {
      isPlaced = false
      collectPlayer.play()
    }

    }

}


