package m323.damenproblem

case class DamenProblem() {
  def solve(row: Int, column: Int): List[List[Int]] = {
    if (row <= 0) List(List())
    else calculateQueens(row - 1, column, solve(row - 1, column))
  }

  private def calculateQueens(newRow: Int, column: Int, oldSolution: List[List[Int]]): List[List[Int]] = {
    var newSolution: List[List[Int]] = List()
    for (solution <- oldSolution) {
      for (newColumn <- 0 until column) {
        if (noSimilaritys(newRow, newColumn, solution)) {
          newSolution = newSolution :+ (solution :+ newColumn)
        }
      }
    }
    newSolution
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
