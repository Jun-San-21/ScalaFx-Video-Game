package desummon
import desummon.TileManager
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.image.Image
import scala.util.Random

class Background(gc: GraphicsContext, tiles: TileManager) {

  private val tileWidth = 32
  private val tileHeight = 32
  def getRandomTile(): Image = {
    val randomIndex = Random.nextInt(tiles.grassCollection.length)
    tiles.grassCollection(randomIndex)

  }

  def drawBackground() {
    for (x <- 0.0 until gc.canvas.getWidth by tileWidth) {
      for (y <- 0.0 until gc.canvas.getHeight by tileHeight) {
        gc.drawImage(getRandomTile(), x, y)
      }
    }
  }
}