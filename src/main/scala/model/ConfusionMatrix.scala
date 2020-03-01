package model

class ConfusionMatrix (val guess: Guess, val attempt: Guess) {

  val matrix = attempt.colors.map(color => guess.colors match {
    case colors if colors.contains(color) && (attempt.colors.indexOf(color) == colors.indexOf(color)) => "Correct"
    case colors if colors.contains(color) && (attempt.colors.indexOf(color) != colors.indexOf(color)) => "Miss placed"
    case _ => "Fail"
  }).sorted

  def getMatrix(): List[String] = this.matrix
}
