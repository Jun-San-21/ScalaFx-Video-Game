package desummon.view
import desummon.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class MenuController {
  def start(): Unit = {
    MainApp.createGame()
  }

  def exit(): Unit = {
    MainApp.stage.close()

  }

  def help(): Unit = {
    MainApp.showHelp()

  }

}
