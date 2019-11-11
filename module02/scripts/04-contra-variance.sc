trait Food {
  val name: String
  override def toString = s"Yummy $name"
}
trait Fruit extends Food
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit



trait Transport[T] {
  def send(item: T): String
}


object AppleTransport extends Transport[Apple] {
  def send(item: Apple) = s"Sending and eating ${item.name}"
}
object FruitTransport extends Transport[Fruit] {
  def send(item: Fruit) = s"Sending a healthy ${item.name}"
}
object AnyTransport extends Transport[Any] {
  def send(item: Any) = s"Sending ${item.toString}"
}

def transportAnApple(transport: Transport[Apple]): String = {
  transport.send(Apple("Fuji"))
}
transportAnApple(AppleTransport)


//transportAnApple(FruitTransport)   // it would be nice if it worked

trait Transport2[-T] {
  def send(item: T): String
}
// Note the [-T]
object AppleTransport2 extends Transport2[Apple] {
  def send(item: Apple) = s"Sending and eating ${item.name}"
}
object FruitTransport2 extends Transport2[Fruit] {
  def send(item: Fruit) = s"Sending a healthy ${item.name}"
}
object AnyTransport2 extends Transport2[Any] {
  def send(item: Any) = s"Sending ${item.toString}"
}

def transportAnApple(transport: Transport2[Apple]): String = {
  transport.send(Apple("Fuji"))
}

transportAnApple(AppleTransport2)
transportAnApple(FruitTransport2)
transportAnApple(AnyTransport2)
