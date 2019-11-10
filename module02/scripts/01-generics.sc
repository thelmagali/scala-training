//1. Simple types
abstract class Food { val name: String }

abstract class Fruit extends Food
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

case class Bowl(food: Food) {
  override def toString = s"A bowl of yummy ${food.name}s"
  def contents = food
}
val fruitBowl = Bowl(Apple("Fuji"))
val cerealBowl = Bowl(Muesli("Alpen"))

fruitBowl.contents
cerealBowl.contents













// Generic types
case class Bowl2[F](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents}s"
}

val appleBowl = Bowl2(Apple("Fuji"))
val muesliBowl = Bowl2(Bowl2(Muesli("Alpen")))
appleBowl.contents
muesliBowl.contents

// but this won't work
//case class Bowl3[F](contents: F) {
//  override def toString: String = s"A yummy bowl of ${contents.name}s"
//}
