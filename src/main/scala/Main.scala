package m323.damenproblem

import scala.annotation.tailrec
import cats.effect.IO

object Main {
  def main(args: Array[String]): Unit = {
    val boardLength = getInt("How long is your board")
    
    val solutions = DamenProblem().solve(boardLength, boardLength)
    for (solution <- solutions) {
      println(solution)
    }
    
    println(Visualizer().visualize(solutions.head))
  }

  @tailrec
  def getInt(prompt: String): Int = {
    val length = readIntFromConsole(prompt)
    if (length <= 0) {
      getInt(prompt)
    } else {
      length
    }
  }

  def readIntFromConsole(prompt: String): Int = {
    println(prompt)
    scala.io.StdIn.readInt()
  }
}