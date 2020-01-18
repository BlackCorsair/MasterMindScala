package model

class Game(val board: Board = new Board(), turns: Int = 10) {
  val win = this.board.solved()

  def nextTurn(guess: Guess): Game = this.turns match {
    case 0 => this
    case _ => new Game(this.board + guess, this.turns - 1)
  }

  def run(game: Game):String = (this.win, this.turns) match {
    case (true,_) => "You win!"
    case (false, 0) => "You lose!!!"
    case (false, _) => run(this.nextTurn(new Guess()))
  }
}
