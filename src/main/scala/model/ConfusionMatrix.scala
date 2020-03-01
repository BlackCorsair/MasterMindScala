package model

class ConfusionMatrix (val guess: Guess, val attempt: Guess) {

  val matrix = if ((guess.colors == Nil) ||  (attempt.colors == Nil)) Nil else attempt.colors.map(color => guess.colors match {
    case colors if colors.contains(color) && (attempt.colors.indexOf(color) == colors.indexOf(color)) => "Correct"
    case colors if colors.contains(color) && (attempt.colors.indexOf(color) != colors.indexOf(color)) => "Miss placed"
    case _ => "Fail"
  }).sorted

  val solved = this.matrix match {
    case m if m.contains("Miss placed") => false
    case m if m.contains("Fail") => false
    case _ => true
  }
}
