import inputs.GuessInput
import model.{Board, Game, Guess, color}
import views.{BoardView, GuessView}

object Main {
  def main(args: Array[String]): Unit = {
    println(new Game().run())
  }
}
