package model

import inputs.GuessInput
import views.BoardView

class Game(val board: Board = new Board(), turns: Int = 2) {
  val win = this.board.solved()

  def nextTurn(guess: Guess): Game = this.turns match {
    case 0 => this
    case _ => new Game(this.board + guess, this.turns - 1)
  }

  def run(game: Game = this):String = {
    println("\n\n\n###\t TURN " + this.turns + "\t###")
    new BoardView().view(this.board)

    (this.win, this.turns) match {
      case (true,_) => "You win!"
      case (false, 0) => "You lose!!!"
      case (false, _) => this.nextTurn(new GuessInput().get(4)).run()
    }
  }
}
