package model

class Board(solution: Guess = new Guess(), guesses: List[Guess] = Nil) {
  def Board(solution: Guess) = new Board(solution, Nil)

  def Board() = new Board(new Guess(Set(color.RED, color.GREEN, color.BLUE, color.BROWN)))

  def +(guess: Guess): Board = new Board(this.solution, guess::this.guesses)

  def solved(): Boolean = {
    def checkGuess(guesses: List[Guess]): Boolean = guesses match {
      case head::_ => head == this.solution
      case head::tail => head == this.solution && checkGuess(tail)
    }
    checkGuess(this.guesses)
  }
}
