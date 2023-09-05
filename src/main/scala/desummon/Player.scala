package desummon

import scalafx.scene.media.Media


class Player (val initialX: Double, val initialY: Double) extends Character with Movable with CheckBounds {

  var health = 50
  var currentX: Double = initialX
  var currentY: Double = initialY
  var collectedItems = 0
  var movementSpeed = 1.5

  override def takeDamage(): Unit = {
    health = health - 1
  }
  def updatePosition(): Unit = {
    currentX = (currentX + getDx)
    currentY = (currentY + getDy)
  }
  def addCollectible(): Unit = {
    collectedItems += 1
  }
}
