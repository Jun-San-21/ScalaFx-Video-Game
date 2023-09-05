package desummon

import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle

class Score(gc: GraphicsContext) {
  /*val healthBar = new Rectangle {
    width = gc.canvas.getWidth
    height = 20
    fill = Color.Red
    translateY = gc.canvas.getHeight - 20
  }*/

  def showCharacterScore(player: Player, enemy: Enemy): Unit = {
    val healthPercentage = player.health.toInt / 100
    val width = gc.canvas.getWidth * healthPercentage
    gc.fill = Color.DarkRed
    gc.setFont(javafx.scene.text.Font.font("Georgia", 15.0))
    gc.clearRect(0,0,gc.canvas.getWidth, gc.canvas.getHeight)
    gc.fillRect(30, 575, player.health, 10)
    gc.fillRect(150, 105, enemy.health*2.5, 10) //30
    gc.fillText("DEMON",280, 100) //20
    gc.fillText("VITALITY",30, 565 )
    gc.fillText(player.collectedItems.toString, 575, 585)

  }
  def showVictory(): Unit = {
    gc.fill = Color.White
    gc.setFont(javafx.scene.text.Font.font("Georgia", 50.0))
    gc.clearRect(0,0,gc.canvas.getWidth, gc.canvas.getHeight)
    gc.fillText("You Won", 200, 250)
  }
  def showDefeat(): Unit = {
    gc.fill = Color.DarkRed
    gc.setFont(javafx.scene.text.Font.font("Georgia", 50.0))
    gc.clearRect(0,0,gc.canvas.getWidth, gc.canvas.getHeight)
    gc.fillText("You died", 200, 250)
  }




}
