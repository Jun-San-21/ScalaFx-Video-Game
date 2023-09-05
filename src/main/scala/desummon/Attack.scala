package desummon

import scalafx.scene.input.KeyCode
import scalafx.scene.media.{Media, MediaPlayer}

class Attack {
  var isAttacking = false
  private var isPlaying = false
  private val flameSpell = new Media(getClass.getResource("/audio/firespell.mp3").toString)
  private val flameSpellPlayer = new MediaPlayer(flameSpell)


  def handleKeyPressed(keyCode: KeyCode): Unit = {
    keyCode match {
      case KeyCode.Q =>
        isAttacking = true
        if (!isPlaying) {
          flameSpellPlayer.play()
          isPlaying = true
        }
      case _ => isAttacking = false
    }
  }

  def handleKeyReleased(keyCode: KeyCode): Unit = {
    keyCode match {
      case KeyCode.Q => {
        isAttacking = false
        flameSpellPlayer.stop()
        isPlaying = false
      }
      case _ =>
    }
  }
}
