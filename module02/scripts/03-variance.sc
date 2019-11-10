abstract class Food { val name: String }

abstract class Fruit extends Food
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

val fuji = Apple("Fuji")
val alpen = Muesli("Alpen")

case class FoodBowl[F <: Food](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents.name}s"
}

// 1. invariance

def serveToFoodEater(foodBowl: FoodBowl[Food]) =
  s"mmmm, I really liked that ${foodBowl.contents.name}"

//serveToFoodEater(fruitBowl)

val foodBowl1 = FoodBowl[Food](fuji)
val foodBowl2 = FoodBowl[Food](alpen)

serveToFoodEater(foodBowl1)
serveToFoodEater(foodBowl2)

// serveToFoodEater(cerealBowl)














// covariance
case class FoodBowl2[+F <: Food](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents.name}s"
}
// note the +F

def serveToFoodEater2(foodBowl: FoodBowl2[Food]) =
  s"mmmm, I really liked that ${foodBowl.contents.name}"

serveToFoodEater2(FoodBowl2[Fruit](fuji))
serveToFoodEater2(FoodBowl2(alpen))
