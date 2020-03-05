package inputs

import model.color.color
import model.{Guess, color}
import scala.io.StdIn.readLine

class GuessInput {
  def get(ncolors: Int): Guess = {
    def getColors(colors: List[color], ncolors: Int): List[color] = {
      println("Current colors: " + colors.toString())
      if (colors.length < ncolors) {
        println("Enter a color: ")
        val c = readLine()
        color.validate(c) match {
          case true => getColors(colors:+color.fromString(c), ncolors)
          case false => {
            println("Please choose one of the following colors:")
            println(color.all)
            getColors(colors, ncolors)
          }
        }
      } else {
        println("retrieved colors")
        colors
      }
    }

    println("Enter " + ncolors + " colors among the following:")
    println(color.all)
    new Guess(getColors(Nil, ncolors))
  }

}
