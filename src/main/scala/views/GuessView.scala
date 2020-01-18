package views
import model.Guess

class GuessView {
  def view(guess: Guess): Unit = {
    printf(guess.toString() + "\n")
  }
}
