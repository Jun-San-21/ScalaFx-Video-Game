package desummon

import scalafx.scene.image.Image

class Sprite { //load sprites
  val spriteSheetIdle = new Image(getClass().getResourceAsStream("/sprites/tile000_IDLE.png"))
  val spriteSheetUp1 = new Image(getClass().getResourceAsStream("/sprites/tile013_UP1.png"))
  val spriteSheetUp2 = new Image(getClass().getResourceAsStream("/sprites/tile015_UP2.png"))
  val spriteSheetDown1 = new Image(getClass().getResourceAsStream("/sprites/tile001_DOWN1.png"))
  val spriteSheetDown2 = new Image(getClass().getResourceAsStream("/sprites/tile003_DOWN2.png"))
  val spriteSheetLeft1 = new Image(getClass().getResourceAsStream("/sprites/tile005_LEFT1.png"))
  val spriteSheetLeft2 = new Image(getClass().getResourceAsStream("/sprites/tile007_LEFT2.png"))
  val spriteSheetRight1 = new Image(getClass().getResourceAsStream("/sprites/tile009_RIGHT1.png"))
  val spriteSheetRight2 = new Image(getClass().getResourceAsStream("/sprites/tile011_RIGHT2.png"))
  val enemyIdle1 = new Image(getClass().getResourceAsStream("/sprites/tile000.png"), 100, 100, false, false)
  val enemyIdle2 = new Image(getClass().getResourceAsStream("/sprites/tile001.png"), 100, 100, false, false)
  val enemyIdle3 = new Image(getClass().getResourceAsStream("/sprites/tile002.png"), 100, 100, false, false)
  val enemyIdle4 = new Image(getClass().getResourceAsStream("/sprites/tile003.png"), 100, 100, false, false)
  val enemyIdle5 = new Image(getClass().getResourceAsStream("/sprites/tile004.png"), 100, 100, false, false)
  val enemyIdle6 = new Image(getClass().getResourceAsStream("/sprites/tile005.png"), 100, 100, false, false)
  val enemyCharge1 = new Image(getClass().getResourceAsStream("/sprites/tile008.png"), 100, 100, false, false)
  val enemyCharge2 = new Image(getClass().getResourceAsStream("/sprites/tile009.png"), 100, 100, false, false)
  val enemyCharge3 = new Image(getClass().getResourceAsStream("/sprites/tile010.png"), 100, 100, false, false)
  val enemyCharge4 = new Image(getClass().getResourceAsStream("/sprites/tile011.png"), 100, 100, false, false)
  val enemyCharge5 = new Image(getClass().getResourceAsStream("/sprites/tile012.png"), 100, 100, false, false)
  val enemyCharge6 = new Image(getClass().getResourceAsStream("/sprites/tile013.png"), 100, 100, false, false)
  val enemyDeath1 = new Image(getClass().getResourceAsStream("/sprites/tile024.png"), 100, 100, false, false)
  val enemyDeath2 = new Image(getClass().getResourceAsStream("/sprites/tile025.png"), 100, 100, false, false)
  val enemyDeath3 = new Image(getClass().getResourceAsStream("/sprites/tile026.png"), 100, 100, false, false)
  val enemyDeath4 = new Image(getClass().getResourceAsStream("/sprites/tile027.png"), 100, 100, false, false)
  val enemyDeath5 = new Image(getClass().getResourceAsStream("/sprites/tile028.png"), 100, 100, false, false)
  val enemyDeath6 = new Image(getClass().getResourceAsStream("/sprites/tile029.png"), 100, 100, false, false)
  val enemyDeath7 = new Image(getClass().getResourceAsStream("/sprites/tile030.png"), 100, 100, false, false)
  val enemyDeath8 = new Image(getClass().getResourceAsStream("/sprites/tile031.png"), 100, 100, false, false)
  val candle1 = new Image(getClass().getResourceAsStream("/sprites/candleA_01.png"))
  val candle2 = new Image(getClass().getResourceAsStream("/sprites/candleA_02.png"))
  val candle3 = new Image(getClass().getResourceAsStream("/sprites/candleA_03.png"))
  val candle4 = new Image(getClass().getResourceAsStream("/sprites/candleA_04.png"))
  val fire0 = new Image(getClass().getResourceAsStream("/sprites/fire000.png"))
  val fire1 = new Image(getClass().getResourceAsStream("/sprites/fire001.png"))
  val fire2 = new Image(getClass().getResourceAsStream("/sprites/fire002.png"))
  val fire3 = new Image(getClass().getResourceAsStream("/sprites/fire003.png"))
  val fire4 = new Image(getClass().getResourceAsStream("/sprites/fire004.png"))
  val fire5 = new Image(getClass().getResourceAsStream("/sprites/fire005.png"))
  val fire6 = new Image(getClass().getResourceAsStream("/sprites/fire006.png"))
  val fire7 = new Image(getClass().getResourceAsStream("/sprites/fire007.png"), 200, 200, false, false)
  val fire8 = new Image(getClass().getResourceAsStream("/sprites/fire008.png"))
  val fire9 = new Image(getClass().getResourceAsStream("/sprites/fire009.png"), 200, 200, false, false)
  val fire10 = new Image(getClass().getResourceAsStream("/sprites/fire010.png"))
  val fire11 = new Image(getClass().getResourceAsStream("/sprites/fire011.png"), 300, 300, false, false)
  val fire12 = new Image(getClass().getResourceAsStream("/sprites/fire012.png"))
  val fire13 = new Image(getClass().getResourceAsStream("/sprites/fire013.png"), 200, 200, false, false)
  val fire14 = new Image(getClass().getResourceAsStream("/sprites/fire014.png"))
  val fire15 = new Image(getClass().getResourceAsStream("/sprites/fire015.png"), 180, 180, false, false)
  val fire16 = new Image(getClass().getResourceAsStream("/sprites/fire016.png"), 200, 200, false, false)
  val fire17 = new Image(getClass().getResourceAsStream("/sprites/fire017.png"), 300, 300, false, false)
  val fire18 = new Image(getClass().getResourceAsStream("/sprites/fire018.png"), 200, 200, false, false)
  val fire19 = new Image(getClass().getResourceAsStream("/sprites/fire019.png"), 180, 180, false, false)
  val fire20 = new Image(getClass().getResourceAsStream("/sprites/fire020.png"), 180, 180, false, false)
  val fire21 = new Image(getClass().getResourceAsStream("/sprites/fire021.png"), 300, 300, false, false)
  val fire22 = new Image(getClass().getResourceAsStream("/sprites/fire022.png"), 200, 200, false, false)
  val fire23 = new Image(getClass().getResourceAsStream("/sprites/fire023.png"), 200, 200, false, false)
  val fire24 = new Image(getClass().getResourceAsStream("/sprites/fire024.png"), 200, 200, false, false)
  val fire25 = new Image(getClass().getResourceAsStream("/sprites/fire025.png"), 200, 200, false, false)
  val fire26 = new Image(getClass().getResourceAsStream("/sprites/fire026.png"), 200, 200, false, false)
  val fire27 = new Image(getClass().getResourceAsStream("/sprites/fire027.png"), 300, 300, false, false)

  //player sprite collection
  val spriteImagesW = Seq(spriteSheetUp1, spriteSheetUp2)
  val spriteImagesA = Seq(spriteSheetLeft1, spriteSheetLeft2)
  val spriteImagesS = Seq(spriteSheetDown1, spriteSheetDown2)
  val spriteImagesD = Seq(spriteSheetRight1, spriteSheetRight2)
  val spriteImagesIdle = Seq(spriteSheetIdle)
  //enemy sprite collection
  val enemyIdle = Seq(
    enemyIdle1, enemyIdle2, enemyIdle3, enemyIdle4, enemyIdle5, enemyIdle6
  )
  val enemyCharge = Seq(
    enemyCharge1,enemyCharge2,enemyCharge3,enemyCharge4,enemyCharge5,enemyCharge6
  )
  val enemyDeath = Seq(enemyDeath8)
  //sprite sequence for collectibles
  val collectibles = Seq(candle1, candle2, candle3, candle4)
  //fire sequence
  val fireSpell = Seq(
     fire15, fire19, fire20,
  )
  //return current image of sprite sequence
  def getCurrentSprite(spriteCollection: Seq[Image]): Image = {
    val index = (System.currentTimeMillis() / 200 % (spriteCollection).length).toInt
    var currentImage = spriteCollection(index)
    currentImage
  }

}