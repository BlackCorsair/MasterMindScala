package model

import scala.util.Random

object color extends Enumeration {
  type color = Value
  val RED, BLUE, BROWN, ORANGE, GREEN, YELLOW = Value

  val all = List(color.RED, color.BLUE, color.BROWN, color.ORANGE, color.GREEN, color.YELLOW)

  def randomList(num: Int): List[color] = {
    def generateList(num: Int, list: List[color]): List[color] = num match {
      case 0 => Nil
      case _ => all(new Random().nextInt(all.length))::generateList(num - 1, list)
    }
    if (num >= all.length) return all
    else return generateList(num, Nil)
  }
}
