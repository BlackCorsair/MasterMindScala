package model

class Board(solution: Guess = new Guess(color.randomList(4)), val guesses: List[Guess] = Nil) {
  def Board(solution: Guess) = new Board(solution, Nil)

  def Board() = new Board(new Guess(max=4))

  def +(guess: Guess): Board = new Board(this.solution, guess::this.guesses)

  def solved(): Boolean = {
    def checkGuess(guesses: List[Guess]): Boolean = guesses match {
      case Nil => false
      case head::Nil => head == this.solution
      case head::tail => head == this.solution && checkGuess(tail)
    }
    checkGuess(this.guesses)
  }

  def toString(solution: Boolean = false): String = {
    def guessesToString(guesses: List[Guess]): String = guesses match {
      case Nil => ""
      case head::Nil => return head.toString() + "\n"
      case head::tail => head.toString() + "\n" + guessesToString(tail)
    }
    return "Guesses: \n" + guessesToString(this.guesses) + (if (solution) "Solution:\n" + this.solution.toString() else "")
  }

  override def toString: String = this.toString(false)

}

