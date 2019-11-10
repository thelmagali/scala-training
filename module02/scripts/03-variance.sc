abstract class Food { val name: String }

abstract class Fruit extends Food
case class Banana(name: String) extends Fruit
case class Apple(name: String) extends Fruit

abstract class Cereal extends Food
case class Granola(name: String) extends Cereal
case class Muesli(name: String) extends Cereal

val fujiApple = Apple("Fuji")
val kellogsGranola = Granola("Kellogs")

case class FoodBowl[F <: Food](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents.name}s"
}

// 1. invariance
def serveToFoodEater(foodBowl: FoodBowl[Food]) =
  s"mmmm, I really liked that ${foodBowl.contents.name}"

//serveToFoodEater(fruitBowl)

val foodBowl1 = FoodBowl[Food](fujiApple)
val foodBowl2 = FoodBowl[Food](kellogsGranola)
val fruitBowl = FoodBowl[Fruit](fujiApple)
val cerealBowl = FoodBowl[Cereal](kellogsGranola)

serveToFoodEater(foodBowl1)
serveToFoodEater(foodBowl2)
//serveToFoodEater(fruitBowl)
//serveToFoodEater(cerealBowl)














// covariance
case class FoodBowl2[+F <: Food](contents: F) {
  override def toString: String = s"A yummy bowl of ${contents.name}s"
}
// note the +F

def serveToFoodEater2(foodBowl: FoodBowl2[Food]) =
  s"mmmm, I really liked that ${foodBowl.contents.name}"

serveToFoodEater2(FoodBowl2[Fruit](fujiApple))
serveToFoodEater2(FoodBowl2(kellogsGranola))

