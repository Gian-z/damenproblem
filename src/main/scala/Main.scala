package m323.damenproblem

object Main {
  def main(args: Array[String]): Unit = {
    val int = readInt()
  }

  def readInt(): Int = {
    println("How long is your board?")
    val length = scala.io.StdIn.readInt()
    println("Your board is " + length + " long")

    length
  }
}