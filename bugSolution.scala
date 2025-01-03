```scala
import scala.util.{Try, Success, Failure}

case class User(id: Int, name: String)

object Main extends App {
  val users = List(User(1, "Alice"), User(2, "Bob"))

  val result = users.map { user => 
    Try(user.id.toString.toInt) match {
      case Success(parsedId) => User(parsedId, user.name)
      case Failure(exception) => {
        println(s"Error parsing ID for user ${user.name}: ${exception.getMessage}")
        user //Keep the original user or handle the error as needed.
      }
    }
  }

  println(result)
}
```