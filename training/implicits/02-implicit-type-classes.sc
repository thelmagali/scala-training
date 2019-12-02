/**
  What is a Type Class?

  A type-class is another name for a trait or abstract class
  with a single generic type parameter and abstract method(s) defined for that type,
*/

trait CompareT[T] {
  def isSmaller(i1: T, i2: T): Boolean
  def isLarger(i1: T, i2: T): Boolean
}

/**
  Implicit type classes

  An implicit type class is an implicit parameter whose type is a Type Class
  */

// Implicit type classes
def genericGetMax[T](list: List[T])(implicit cmp: CompareT[T]): T = {
  require(list.nonEmpty)
  list.reduceLeft{ (i1: T, i2: T) =>
    if(cmp.isLarger(i1, i2)){
      i1
    } else i2
  }
}




// let's use it

//implicit object CompareInt extends CompareT[Int] {
//  override def isSmaller(i1: Int, i2: Int) = i1 < i2
//  override def isLarger(i1: Int, i2: Int) = i1 > i2
//}
//
//implicit object CompareChar extends CompareT[Char] {
//  override def isSmaller(i1: Char, i2: Char) = i1 < i2
//  override def isLarger(i1: Char, i2: Char) = i1 > i2
//}

val nums = List(1,4,3,2,6,5)
val chars = List('b', 'a', '2')


genericGetMax(nums)
genericGetMax(chars)


// Now show the syntactic sugar for implicit type classes and what is implicitly
