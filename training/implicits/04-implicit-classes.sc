
implicit class BetterString(val s: String) {
  def hello: String = s"Hello, ${s.capitalize}"
}

"joe".hello


/**
  Scala 2.10 introduced a new feature called implicit classes.
  An implicit class is a class marked with the implicit keyword.
  This keyword makes the class’s primary constructor available
  for implicit conversions when the class is in scope.
 */