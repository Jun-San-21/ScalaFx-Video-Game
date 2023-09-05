package desummon

abstract class Character {
  var currentX: Double
  var currentY: Double
  var health: Int

  def takeDamage(): Unit

}
