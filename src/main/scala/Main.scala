package m323.damenproblem

object Main {
  def main(args: Array[String]): Unit = {
    val int = readInt()
    calculateQueens(int)
  }

  def readInt(): Int = {
    println("How long is your board?")
    val length = scala.io.StdIn.readInt()
    if (length <= 0) {
      readInt()
    } else {
      println("Your board is " + length + " long")

      length
    }
  }

  def calculateQueens(length: Int): Int = {



  }
}