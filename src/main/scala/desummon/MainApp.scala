package desummon
import desummon.view.MenuController
import scalafx.scene.media.{Media, MediaPlayer}
//import invaders.{Attack, Background, Collectible, Enemy, GameState, Movable, Player, Score, Sprite, TileManager, WorldObjects}
import scalafx.Includes.jfxSceneProperty2sfx
import scalafx.animation.AnimationTimer
import scalafx.application.{JFXApp, Platform}
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.input._
import scalafx.scene.{Group, Scene}

import scalafx.scene.shape.Circle
import scalafx.event.ActionEvent
import scalafx.Includes._
import scalafx.beans.binding.NumberBinding
import scalafx.geometry.Pos
import scalafx.scene.canvas.{Canvas, GraphicsContext}
import scalafx.scene.control.{Button, ButtonBar, Label}
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.layout.{HBox, StackPane, VBox}
import scalafx.scene.text.Text
import scalafxml.core.{FXMLLoader, NoDependencyResolver}
import javafx.{scene => jfxs}
//import scalafx.scene

import scala.collection.mutable.ListBuffer
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.Random

object MainApp extends JFXApp {

  val music = new Media(getClass().getResource("/audio/Floating_in_the_Abyss.mp3").toString)
  val musicPlayer = new MediaPlayer(music) {
    autoPlay = true
  }
  val bossMusic = new Media(getClass().getResource("/audio/bossmusic.mp3").toString)
  val bossMusicPlayer = new MediaPlayer(bossMusic) {
    cycleCount = 10
    volume = 0.2
  }

  stage = new PrimaryStage {
    title = "Desummon"
    icons += new Image(getClass.getResourceAsStream("/images/candle.png"))
    resizable = false

  }

  val scene = new Scene {
    stylesheets = List(getClass.getResource("/view/StyleSheet.css").toString)
  }
  stage.scene = scene
  //run the game and initialize objects
  def createGame(): Unit = {
    //bossMusicPlayer.play()
    val windowWidth = 600
    val windowHeight = 600
    musicPlayer.stop()
    val mainCanvas = new Canvas(windowWidth, windowHeight)
    val gc = mainCanvas.graphicsContext2D
    //background canvas
    val backgroundCanvas = new Canvas(windowWidth,windowHeight)
    val gc2 = backgroundCanvas.graphicsContext2D
    val tileManager = new TileManager
    val bg = new Background(gc2, tileManager )
    bg.drawBackground()
    //world objects canvas
    val objectCanvas = new Canvas(windowWidth, windowHeight)
    val gc3 = objectCanvas.graphicsContext2D
    val worldObj = new WorldObjects(gc3)
    worldObj.drawObjects()
    //score canvas
    val scoreCanvas = new Canvas(windowWidth, windowHeight)
    val gc4 = scoreCanvas.graphicsContext2D
    val score = new Score(gc4)

    val restartButton = new Button("Play again") {
      style = "-fx-background-color: Black; -fx-text-fill: DarkGrey; -fx-font-size: 14px;"
      prefWidth = 100

    }
    val quitButton = new Button("Menu") {
      style = "-fx-background-color: Black; -fx-text-fill: DarkGrey; -fx-font-size: 14px;"
      prefWidth = 100
    }

    restartButton.onAction = () => createGame()
    quitButton.onAction = () => showMenu()
    val buttonLayout = new HBox(20) {
      children = Seq(restartButton, quitButton)
      alignment = Pos.Center
    }
    val sprite = new Sprite

    val player = new Player(500,500)
    val enemy = new Enemy
    val attack = new Attack
    val gameState = new GameState(gc, sprite, player, enemy)
    val candle1 = new Collectible(167, 123)
    val candle2 = new Collectible(420, 121)
    val candle3 = new Collectible(184, 485)
    val candle4 = new Collectible(401, 491)
    val candle5 = new Collectible(74, 308)
    val candle6 = new Collectible(516, 294)
    val candle7 = new Collectible(162, 232)
    val candle8 = new Collectible(416, 378)
    val candle9 = new Collectible(413, 216)
    val candle10 = new Collectible(175, 397)
    val candle11 = new Collectible(296, 153)
    val candle12 = new Collectible(299, 459)
    val candles: List[Collectible] = List(candle1, candle2, candle3, candle4, candle5, candle6, candle7, candle8
      , candle9, candle10, candle11, candle12
    )
    val collectiblesBuffer = ListBuffer.empty[Collectible]
    candles.foreach(collectiblesBuffer += _)
    scene.onKeyPressed = (event: KeyEvent) => {
      player.handleKeyPressed(event.code)
      attack.handleKeyPressed(event.code)
    }
    scene.onKeyReleased = (event: KeyEvent) => {
      player.handleKeyReleased(event.code)
      attack.handleKeyReleased(event.code)
    }

    val root = new StackPane
    root.children.addAll(backgroundCanvas,objectCanvas,mainCanvas,scoreCanvas)

    this.scene.content = root
    val thread = new Thread(() => {
      while (!gameState.gameOver) {
        Platform.runLater {

            gameState.drawState()
            gameState.drawState(collectiblesBuffer)
            score.showCharacterScore(player, enemy)
            gameState.applyDamage(player, attack)
            gameState.applyDamage(enemy, attack)
            gameState.applyBuff(player, collectiblesBuffer)
            gameState.applyBuff(enemy, collectiblesBuffer)
            gameState.checkVictoryOrDefeat()
            if (gameState.gameOver) {
              //bossMusicPlayer.stop()
              root.children.add(buttonLayout)
            }
        }
        Thread.sleep(20)
      }
      if (gameState.victory) {
        score.showVictory()
      } else if (!gameState.victory) {
        score.showDefeat()
      }

    })
    thread.start()
  }
  def showMenu(): Unit = {
    musicPlayer.play()
    val resource = getClass.getResource("/view/Menu.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.scene.content = roots
  }
  def showHelp(): Unit = {
    val resource = getClass.getResource("/view/Help.fxml")
    val loader = new FXMLLoader(resource, NoDependencyResolver)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.scene.content = roots
  }
  showMenu()
  //main

}