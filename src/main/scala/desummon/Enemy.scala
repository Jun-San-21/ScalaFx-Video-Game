package desummon
import desummon.Character
import scalafx.scene.media.{Media, MediaPlayer}
class Enemy extends Character with CheckBounds {
  var dx = 0.0
  var dy = 0.0
  private var dxCenter = 0.0
  private var dyCenter = 0.0
  var distance = 0.0
  var centerDistance = 0.0
  val centerX = 240
  val centerY = 210
  var currentX = 240
  var currentY = 210
  var isVulnerable = false
  var movementSpeed: Double = 2.2
  var health = 120
  private val roar = new Media(getClass().getResource("/audio/demonroar.mp3").toString)
  private val roarPlayer = new MediaPlayer(roar)

  override def takeDamage(): Unit = {
    health = health - 1
  }
//ad hoc overloading polymorphism
  def getDistance(playerX: Double, playerY:Double): Double = {
    dx = playerX - currentX
    dy = playerY - currentY
    distance = math.sqrt(dx* dx + dy * dy)
    distance
  }
  def getDistance: Double = {
    dxCenter = centerX - currentX
    dyCenter = centerY - currentY
    centerDistance = math.sqrt(dxCenter * dxCenter + dyCenter * dyCenter)
    centerDistance
  }
  // Update the follower's position to move towards the coordinates
  def moveToPlayer(): Unit = {
    roarPlayer.play()

    val moveX = dx / distance * movementSpeed
    val moveY = dy / distance * movementSpeed
    currentX += moveX
    currentY += moveY
  }
  def returnToCenter(): Unit = {
    roarPlayer.stop()
    val returnX = dxCenter / centerDistance * (movementSpeed - 0.5)
    val returnY = dyCenter / centerDistance * (movementSpeed - 0.5)

    currentX += returnX
    currentY += returnY
  }
}
