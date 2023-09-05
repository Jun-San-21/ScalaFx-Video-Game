package desummon.view
import desummon.MainApp
import scalafxml.core.macros.sfxml

@sfxml
class HelpController {
  def returnMenu(): Unit = {
    MainApp.showMenu()
  }

}
