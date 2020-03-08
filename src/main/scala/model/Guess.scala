package model

import model.color.color

class Guess(val colors: List[color] = Nil, max: Int = 4) {

  val MAX = max

  def Guess(max: Int): Guess = new Guess(Nil, max)

  def Guess(colors: List[color]): Guess = new Guess(colors, colors.length)

  def Guess(): Guess = new Guess(Nil, 4)

  def +(color: color): Guess = this.colors.size match {
    case this.MAX => this
    case _ => new Guess(color::this.colors)
  }

  def compareTo(other: Guess): ConfusionMatrix =  new ConfusionMatrix(this, other)

  def colorToString(c: color): String = c match {
    case color.RED => "RED"
    case color.BLUE => "BLUE"
    case color.BROWN => "BROWN"
    case color.ORANGE => "ORANGE"
    case color.GREEN => "GREEN"
    case color.YELLOW => "YELLOW"
  }
  def colorsToString(colors: List[color]): String = colors match{
    case Nil => ""
    case head::Nil => colorToString(head)
    case head::tail => colorToString(head) + " " + colorsToString(tail)
  }

  override def toString(): String = "[ " + colorsToString(this.colors) + " ]"
}
