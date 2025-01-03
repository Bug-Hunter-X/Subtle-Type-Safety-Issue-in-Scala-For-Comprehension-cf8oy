```scala
import scala.util.Try

case class User(id: Int, name: String)

object Main extends App {
  val users = List(User(1, "Alice"), User(2, "Bob"))

  val result = for {
    user <- users
    parsedId <- Try(user.id.toString.toInt).toOption 
  } yield User(parsedId, user.name)

  println(result)
}
```