package model

class Game(val board: Board = new Board(), turns: Int = 10) {
  val _turns = turns

  val win = this.board.solved()

  def nextTurn(guess: Guess): Game = this._turns match {
    case 0 => this
    case _ => new Game(this.board + guess, this.turns - 1)
  }

  def run(game: Game):Unit = {
    if (this.win == true) {
      print("You win!")
    }

    if (this.win == false && this._turns == 0) {
      print("You lose!!!")
    }

    if (this.win == false && this._turns != 0) {
      run(this.nextTurn(new Guess()))
    }

  }
}
