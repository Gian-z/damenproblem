package m323.damenproblem

import scala.annotation.tailrec

case class Visualizer() {

  def visualize(board: List[Int]): String = {
    val length = board.length
    if (length <= 0)
      return ""

    val separator = getSeparator(length)
    board.map(i => getLine(length, i)).map(s => s.reverse).foldLeft(separator)(_ + "\n" + _ + "\n" + separator)
  }
  
  @tailrec
  private def getLine(length: Int, index: Int, previous: String = "|"): String = {
    if (length <= 0)
      return previous

    val snippet = if (length == index + 1) " ♕ |" else "   |"
    getLine(length - 1, index, previous + snippet)
  }

  @tailrec
  private def getSeparator(length: Int, previous: String = "+"): String = {
    if (length <= 0)
      return previous

    getSeparator(length - 1, previous + "---+")
  }
}
