trait Food {
  val name: String
  override def toString = s"Yummy $name"
}
trait Fruit extends Food
case class Apple(name: String) extends Fruit
case class Orange(name: String) extends Fruit



trait Transporter[T] {
  def send(item: T): String
}


object AppleTransporter extends Transporter[Apple] {
  def send(item: Apple) = s"Sending and eating ${item.name}"
}
object FruitTransporter extends Transporter[Fruit] {
  def send(item: Fruit) = s"Sending a healthy ${item.name}"
}
object AnyTransporter extends Transporter[Any] {
  def send(item: Any) = s"Sending ${item.toString}"
}

def transportAnApple(transport: Transporter[Apple]): String = {
  transport.send(Apple("Fuji"))
}
transportAnApple(AppleTransporter)


//transportAnApple(FruitTransporter)   // it would be nice if it worked
