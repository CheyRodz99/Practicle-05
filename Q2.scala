import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object Q2 {

  var library: Set[Book] = Set(
    Book("1984", "George Orwell", "1234567890"),
    Book("To Kill a Mockingbird", "Harper Lee", "1234567891"),
    Book("The Great Gatsby", "F. Scott Fitzgerald", "1234567892")
  )

  def addBook(book: Book): Unit = {
    library += book
    println(s"Book added: ${book.title} by ${book.author}")
  }


  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Book removed: ${book.title} by ${book.author}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }


  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }


  def displayLibrary(): Unit = {
    println("Current Library Collection:")
    library.foreach(book => println(s"${book.title} by ${book.author} (ISBN: ${book.isbn})"))
  }


  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"Book found: ${book.title} by ${book.author} (ISBN: ${book.isbn})")
      case None =>
        println(s"No book found with title: $title")
    }
  }


  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.nonEmpty) {
      println(s"Books by $author:")
      booksByAuthor.foreach(book => println(s"${book.title} (ISBN: ${book.isbn})"))
    } else {
      println(s"No books found by author: $author")
    }
  }


  def main(args: Array[String]): Unit = {
    println("Initial Library Collection:")
    displayLibrary()
    println("\n----------------------\n")

    val newBook = Book("Brave New World", "Aldous Huxley", "1234567893")
    println("Adding a new book:")
    addBook(newBook)
    displayLibrary()
    println("\n----------------------\n")

    println("Removing a book by ISBN '1234567891':")
    removeBook("1234567891")
    displayLibrary()
    println("\n----------------------\n")

    val isbnToCheck = "1234567892"
    println(s"Checking if book with ISBN '$isbnToCheck' is in the library:")
    if (isBookInLibrary(isbnToCheck)) {
      println(s"Book with ISBN $isbnToCheck is in the library.")
    } else {
      println(s"Book with ISBN $isbnToCheck is not in the library.")
    }
    println("\n----------------------\n")

    println("Searching for a book by title '1984':")
    searchBookByTitle("1984")
    println("\n----------------------\n")

    println("Displaying all books by author 'George Orwell':")
    displayBooksByAuthor("George Orwell")
  }
}
