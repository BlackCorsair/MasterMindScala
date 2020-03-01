import org.scalatest.FunSuite

import model.{Board, Guess}
import model.color

class BoardTest extends FunSuite{
  test("AddGuess") {
    val solution = new Guess(List(color.RED))
    val guesses = List(solution)
    val board = new Board(solution, guesses)+solution

    assert(board.guesses == solution::guesses)
  }

  test("SolvedTrue") {
    val solution = new Guess(List(color.RED, color.BROWN, color.BLUE, color.BLUE))
    val guesses = List(solution)
    val board = new Board(solution, guesses)+solution

    assert(board.solved())
  }

  test("SolvedFalse") {
    val solution = new Guess(List(color.RED, color.BROWN, color.BLUE, color.BLUE))
    val anotherGuess = new Guess(List(color.BROWN, color.BROWN, color.BLUE, color.BLUE))
    val guesses = List(anotherGuess)
    val board = new Board(solution, guesses)

    assert(!board.solved())
  }
}
