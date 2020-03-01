import org.scalatest.FunSuite

import model.{ConfusionMatrix, Guess}
import model.color

class ConfusionMatrixTest extends FunSuite {
  test("AllCorrect") {
    assert(
      new ConfusionMatrix(
        new Guess(List(color.BLUE, color.BROWN)),
        new Guess(List(color.BLUE, color.BROWN))
      ).getMatrix() == List("Correct", "Correct")
    )
  }

  test("CorrectColorsIncorrectPosition") {
    assert(
      new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE)),
        new Guess(List(color.BLUE, color.BROWN))
      ).getMatrix() == List("Miss placed", "Miss placed")
    )
  }

  test("TotallyWrong") {
    assert(
      new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE)),
        new Guess(List(color.ORANGE, color.ORANGE))
      ).getMatrix() == List("Fail", "Fail")
    )
  }

  test("OneCorrectOneWrongOneFail") {
    assert(
      new ConfusionMatrix(
        new Guess(List(color.BROWN, color.BLUE, color.ORANGE)),
        new Guess(List(color.ORANGE, color.BLUE, color.RED))
      ).getMatrix() == List("Correct", "Fail", "Miss placed")
    )
  }
}