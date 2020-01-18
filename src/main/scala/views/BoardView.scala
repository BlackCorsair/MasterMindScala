package views

import model.{Board, Guess}

class BoardView {
  def view(board: Board, solution: Boolean = false): Unit = printf(board.toString(solution) + "\n")
}
