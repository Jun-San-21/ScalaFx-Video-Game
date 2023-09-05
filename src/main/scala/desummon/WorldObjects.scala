package desummon

import scalafx.scene
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image

import scala.util.Random

class WorldObjects(gc: GraphicsContext) {
  val r = new Random()
  val wall1 = new Image(getClass.getResourceAsStream("/objects/wall1.png"))
  val dome1 = new Image(getClass.getResourceAsStream("/objects/dome1.png"))
  val horizontal = new Image(getClass.getResourceAsStream("/objects/horizontal.png"))
  val wall2 = new Image(getClass.getResourceAsStream("/objects/wall2.png"))
  val centerpiece = new Image(getClass.getResourceAsStream("/objects/centerpiece.png"))
  val pillar = new Image(getClass.getResourceAsStream("/objects/pillar.png"))
  val spell = new Image(getClass.getResourceAsStream("/objects/spell.png"))
  val stone = new Image(getClass.getResourceAsStream("/objects/stone.png"))
  //randomizef
  /*def drawObjects(): Unit = {
    for (i <- 1 to numObj) {
      val x: Double = r.nextInt(gc.canvas.getWidth.toInt - 64)
      val y: Double = r.nextInt(gc.canvas.getHeight.toInt - 64)
      gc.drawImage(tileImage, x, y)
    }
  }*/
  def drawObjects(): Unit = {
    /*gc.drawImage(wall1, 0,400)
    gc.drawImage(wall1, 600 - wall1.width.value,400)
    gc.drawImage(dome1,wall1.width.value ,400 - dome1.height.value + wall1.width.value/2 -21)
    gc.drawImage(horizontal, 0, 300)
    gc.drawImage(horizontal, 0 + horizontal.width.value, 300)
    gc.drawImage(horizontal, 0 + horizontal.width.value*2, 300)
    //gc.drawImage(horizontal, 0 + horizontal.width.value*3, 300)
    gc.drawImage(horizontal, 0, 550)
    gc.drawImage(horizontal, 0 + horizontal.width.value, 550)
    gc.drawImage(horizontal, 0 + horizontal.width.value*2, 550)

    gc.drawImage(wall2, wall2.width.value*2, 0)

    gc.drawImage(horizontal, 600 - horizontal.width.value, 550)
    gc.drawImage(horizontal, 600 - horizontal.width.value*2, 550)
    gc.drawImage(horizontal, 600 - horizontal.width.value*3, 550)*/
    gc.drawImage(centerpiece, 300 - centerpiece.width.value/2 ,300 - centerpiece.height.value/2)
    gc.drawImage(pillar, 75, 50)
    gc.drawImage(pillar, 50, 450)
    gc.drawImage(pillar, 490, 460)
    gc.drawImage(pillar, 485, 40)

    gc.drawImage(pillar, 288, 6)
    gc.drawImage(pillar, 268, 513)
    gc.drawImage(pillar, 6, 266)
    gc.drawImage(pillar, 563, 252)

    gc.drawImage(spell, 250,250) //top left
    gc.drawImage(spell, 335,335) // bottom right
    gc.drawImage(spell, 335,250) //top right
    gc.drawImage(spell, 250, 335) //bottom left
    //gc.drawImage(spell, 292, 375)
    //gc.drawImage(spell, 292, 210)
    gc.drawImage(spell, 210, 292)
    gc.drawImage(spell, 375, 292)
    gc.drawImage(stone, 140, 525)
    gc.drawImage(stone, 57, 409)
    gc.drawImage(stone, 527, 58)
    //gc.drawImage(stone, 408, 64)
    //gc.drawImage(stone, 458, 73)
  }
}