package m323.damenproblem

import cats.effect.{ExitCode, IO, IOApp}

object Main extends IOApp {

  override def run(args: List[String]): IO[ExitCode] = {
    getInt("How long is your board").flatMap { boardLength =>
      val solutionsIO = DamenProblem().solve(IO.pure(boardLength), IO.pure(boardLength))
      for {
        solutions <- solutionsIO
        _ <- IO.delay {
          val visualizer = Visualizer()
          for (solution <- solutions) {
            println(solution)
            println(visualizer.visualize(solution))
            println("\n**********************\n")
          }
        }
      } yield ExitCode.Success
    }
  }

  private def getInt(prompt: String): IO[Int] = {
    val length: IO[Int] = IO.delay(readIntFromConsole(prompt))
    length.flatMap { value =>
      if (value <= 0) {
        getInt(prompt)
      } else {
        IO.pure(value)
      }
    }
  }

  private def readIntFromConsole(prompt: String): Int = {
    println(prompt)
    scala.io.StdIn.readInt()
  }
}
