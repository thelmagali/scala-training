case class RetryParams(times: Int)

import scala.util.control.NonFatal

// Retry mechanism
def retryAux[A](fn: => A, currentTry: Int = 0)(retryParams: RetryParams): A = {
  println(s"Retry number $currentTry")
  try fn
  catch {
    case NonFatal(_) if currentTry < retryParams.times =>
      Thread.sleep(1)
      retryAux(fn, currentTry + 1)(retryParams)
  }
}

def retry[A](fn: => A)(retryParams: RetryParams): A =
  retryAux(fn, 0)(retryParams)




//usage of retry
def checkTimestamp(): Unit = {
  val timestamp = System.currentTimeMillis()
  assert(timestamp % 10 == 0, "Condition not met")
}

retry(checkTimestamp())(RetryParams(20))

//Go up and make RetryParams implicit


/** Notes on Implicits parameters
  *
  * 1. You can always override implicits with an explicit parameter
  *
  * 2. Implicit parameter lists can have more than one parameter
  *
  * 3. implicit is only placed at the head of the parameter list, not on each parameter:
  *
  * 4. Only the final parameter list can be implicit
  *
  * 5. If any implicits are explicitly provided, all of them must be provided
  *
  */

/**
 Implicit resolution

  1. Implicits defined in current scope (current example)
  2. Explicit imports (global execution context)
  3. wildcard imports
  4. Companion objects of a type (json conversion)
 */

