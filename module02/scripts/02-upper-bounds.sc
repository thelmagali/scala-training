
abstract class Food { val name: String }

abstract class Fruit extends Food
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

case class Bowl[F](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents}s"
}

abstract class Animal {
  val name: String
  override def toString: String = s"Animal - $name"
}
case class Dog(name: String) extends Animal
val dogBowl = Bowl(Dog("Dottie"))  // noooo - don't eat my dog

case class FoodBowl[F <: Food](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents.name}s"
}

val appleBowl = FoodBowl(Apple("Fuji"))

//val dogBowl2 = FoodBowl(dottie)
