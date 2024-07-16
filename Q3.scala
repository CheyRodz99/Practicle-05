import scala.io.StdIn.readInt

object Q3 {
    def printFibonacciNumbers(n: Int): Unit = {
      def fibonacci(num: Int): Int = {
        if (num <= 1) num
        else fibonacci(num - 1) + fibonacci(num - 2)
      }

      for (i <- 0 until n) {
        println(fibonacci(i))
      }
    }

    def main(args: Array[String]): Unit = {
      print("Enter the number of Fibonacci numbers to print: ")
      val n = readInt()
      println(s"First $n Fibonacci numbers:")
      printFibonacciNumbers(n)
    }
  }

