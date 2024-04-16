package m323.damenproblem

import cats.effect.IO
import cats.effect.unsafe.implicits.global
import cats.implicits.catsSyntaxApplicativeId

case class DamenProblem() {
  def solve(row: IO[Int], column: IO[Int]): IO[List[List[Int]]] = {
    row.flatMap { r =>
      if (r <= 0) {
        IO.pure(List(List()))
      } else {
        solve(row.map(_ - 1), column).flatMap { prevSolutions =>
          calculateQueens(r - 1, column, prevSolutions)
        }
      }
    }
  }

  private def calculateQueens(newRow: Int, column: IO[Int], oldSolution: List[List[Int]]): IO[List[List[Int]]] = {
    IO.delay {
      oldSolution.flatMap { solution =>
        (0 until column.unsafeRunSync()).flatMap { newColumn =>
          if (noSimilaritys(newRow, newColumn, solution)) {
            List(solution :+ newColumn)
          } else {
            List.empty
          }
        }
      }
    }
  }

  private def noSimilaritys(newRow: Int, newColumn: Int, solution: List[Int]): Boolean = {

    for (rows <- 0 until newRow) {
      if (solution(rows) == newColumn ||
        solution(rows) + rows == newColumn + newRow ||
        solution(rows) - rows == newColumn - newRow) {
        return false
      }
    }

    true
  }
}