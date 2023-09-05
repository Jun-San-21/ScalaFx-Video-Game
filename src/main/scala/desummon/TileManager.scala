package desummon

import scalafx.scene.image.Image

class TileManager {
  val grass0 = new Image(getClass.getResourceAsStream("/tiles/grass00.png"))
  val grass1 = new Image(getClass.getResourceAsStream("/tiles/grass01.png"))
  val grass2 = new Image(getClass.getResourceAsStream("/tiles/grass02.png"))
  val grass3 = new Image(getClass.getResourceAsStream("/tiles/grass03.png"))
  val grass4 = new Image(getClass.getResourceAsStream("/tiles/grass04.png"))
  val grass5 = new Image(getClass.getResourceAsStream("/tiles/grass05.png"))
  val grass6 = new Image(getClass.getResourceAsStream("/tiles/grass06.png"))
  val grass7 = new Image(getClass.getResourceAsStream("/tiles/grass07.png"))
  val grass8 = new Image(getClass.getResourceAsStream("/tiles/grass08.png"))
  val grass9 = new Image(getClass.getResourceAsStream("/tiles/grass09.png"))
  val grass10 = new Image(getClass.getResourceAsStream("/tiles/grass10.png"))

  val grassCollection: List[Image] = List(grass0, grass1, grass2, grass3, grass4, grass5, grass6, grass7, grass8,
    grass9, grass10
  )


}
