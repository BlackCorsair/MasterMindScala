package model

import model.color.color

class Guess(val colors: Set[color] = Set(), max: Int = 4) {

  val MAX = max

  def Guess(colors: Set[color]): Guess = new Guess(colors, 4)

  def addColor(color: color): Guess = this.colors.size match {
    case this.MAX => this
    case _ => new Guess(this.colors + color)
  }

  def ==(other: Guess): Boolean = other match {
    case other: Guess => (this.colors & other.colors).size == 4
    case _ => false
  }
}
