import scala.io.StdIn.readLine
object Q1 {
    def getProductList(): List[String] = {
      var productList: List[String] = List()
      var input: String = ""

      while (input != "done") {
        input = readLine("Enter product name (type 'done' to finish): ")
        if (input != "done") {
          productList = productList :+ input
        }
      }

      productList
    }

    def printProductList(productList: List[String]): Unit = {
      productList.zipWithIndex.foreach { case (product, index) =>
        println(s"${index + 1}. $product")
      }
    }

    def getTotalProducts(productList: List[String]): Int = {
      productList.length
    }

    def main(args: Array[String]): Unit = {
      val productList = getProductList()
      println("Product List:")
      printProductList(productList)
      println(s"Total number of products: ${getTotalProducts(productList)}")
    }
  }
