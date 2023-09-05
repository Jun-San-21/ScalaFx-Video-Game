package desummon

import scalafx.scene.input.KeyCode
import scalafx.scene.media.{Media, MediaPlayer}
 trait Movable {
  var movementSpeed: Double
  private var dx = 0.0
  private var dy = 0.0
  private var currentDirection: Int = 0
  private var isIdle = true
  /* val walking = new Media(getClass().getResource("/audio/running-in-grass.mp3").toString)
  val footstep = new MediaPlayer(walking) {
    autoPlay = true
  }*/
  def handleKeyPressed(keyCode: KeyCode): Unit = {
    isIdle = false
    /*footstep.stop()
    footstep.play()*/
    keyCode match {
      case KeyCode.W =>
        dy = -movementSpeed
        currentDirection = 0
      case KeyCode.A =>
        dx = -movementSpeed
        currentDirection = 1
      case KeyCode.S =>
        dy = movementSpeed
        currentDirection = 2
      case KeyCode.D =>
        dx = movementSpeed
        currentDirection = 3
      case _ =>

    }
  }
  def handleKeyReleased(keyCode: KeyCode): Unit = {
    keyCode match {
      case KeyCode.W | KeyCode.S => dy = 0
      case KeyCode.A | KeyCode.D => dx = 0
      case _ =>
    }
    if (dy == 0 && dx == 0) isIdle = true
  }

  def getDx: Double = dx
  def getDy: Double = dy
  def getCurrentDirection: Int = currentDirection
  def isCharacterIdle: Boolean = isIdle

}
