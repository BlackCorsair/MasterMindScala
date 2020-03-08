import model.{Guess, color}
import org.scalatest.funsuite.AnyFunSuite

class GuessTest extends AnyFunSuite {

  test("TestGuessEqualsToAnotherOneColor"){
    val colors = List(color.RED)
    val guess = new Guess(colors)

    assert((guess compareTo new Guess(colors)).solved)
  }

  test("TestGuessEqualsToAnotherMultipleColors"){
    val colors = List(color.RED, color.BLUE)
    val guess = new Guess(colors)

    assert((guess compareTo new Guess(colors)).solved)
  }

  test("TestGuessNotEqualsToAnotherMultipleColors"){
    val colors = List(color.RED, color.BLUE)
    val guess = new Guess(colors)

    assert(!(guess compareTo new Guess(color.BROWN::colors)).solved)
  }
}
