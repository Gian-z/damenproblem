package m323.damenproblem

import cats.effect.{ExitCode, IO, IOApp}
import cats.implicits.catsSyntaxApplicativeId

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    getInt("How long is your board").flatMap { boardLength =>
      val solutionsIO = DamenProblem().solve(IO.pure(boardLength), IO.pure(boardLength))
      for {
        solutions <- solutionsIO
        _ <- IO.delay {
          for (solution <- solutions) {
            println(solution)
          }
        }
        firstSolution <- IO.delay(solutions.head)
        visualization <- IO.delay(Visualizer().visualize(firstSolution))
        _ <- IO.delay(println(visualization))
      } yield ExitCode.Success
    }
  }

  def getInt(prompt: String): IO[Int] = {
    val length: IO[Int] = IO.delay(readIntFromConsole(prompt))
    length.flatMap { value =>
      if (value <= 0) {
        getInt(prompt)
      } else {
        IO.pure(value)
      }
    }
  }

  def readIntFromConsole(prompt: String): Int = {
    println(prompt)
    scala.io.StdIn.readInt()
  }
}
