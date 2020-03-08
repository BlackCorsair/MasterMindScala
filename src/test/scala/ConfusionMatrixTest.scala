import model.{ConfusionMatrix, Guess}
import model.color
import org.scalatest.funsuite.AnyFunSuite

class ConfusionMatrixTest extends AnyFunSuite {
  test("AllCorrect") {
    val matrix = new ConfusionMatrix(
      new Guess(List(color.BLUE, color.BROWN)),
      new Guess(List(color.BLUE, color.BROWN))
    )
    assert(matrix.matrix == List("Correct", "Correct"))
    assert(matrix.solved == true)
  }

  test("CorrectColorsIncorrectPosition") {
    val matrix = new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE)),
        new Guess(List(color.BLUE, color.BROWN))
      )
    assert(matrix.matrix == List("Miss placed", "Miss placed"))
    assert(matrix.solved == false)
  }

  test("TotallyWrong") {
    val matrix = new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE)),
        new Guess(List(color.ORANGE, color.ORANGE))
      )
    assert(matrix.matrix == List("Fail", "Fail"))
    assert(matrix.solved == false)
  }

  test("OneCorrectOneWrongOneFail") {
    val matrix = new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE, color.ORANGE)),
        new Guess(List(color.ORANGE, color.BLUE, color.RED))
      )

    assert(matrix.matrix == List("Correct", "Fail", "Miss placed"))
    assert(matrix.solved == false)
  }
}