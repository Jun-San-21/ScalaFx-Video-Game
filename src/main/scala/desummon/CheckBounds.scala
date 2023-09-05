package desummon
//self type trait
trait CheckBounds {
  this: Character =>
  def checkCharacterBounds(width: Double, height: Double, spriteRadius: Double): Unit = {
    if (currentX > width + spriteRadius) currentX = -spriteRadius
    if (currentX < -spriteRadius) currentX = width + spriteRadius
    if (currentY > height + spriteRadius) currentY = -spriteRadius
    if (currentY < -spriteRadius) currentY = height + spriteRadius
  }


}
