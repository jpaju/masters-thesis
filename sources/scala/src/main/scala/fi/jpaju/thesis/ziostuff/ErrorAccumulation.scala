package fi.jpaju.thesis.ziostuff

import zio.*

trait ErrorA
trait ErrorB
trait ErrorC

val num1: ZIO[Any, ErrorA, Int]          = ???
val num2: ZIO[Any, ErrorA, Int]          = ???
val num3: ZIO[Any, ErrorB, Int]          = ???
val doSomething: ZIO[Any, Nothing, Unit] = ???

// 'ErrorA' is included only once in the error type
// 'Nothing' is not included at all in the error type
val composed: ZIO[Any, ErrorA | ErrorB, Int] =
  for
    n1 <- num1        // ErrorA
    n2 <- num2        // ErrorA
    _  <- doSomething // Nothing
    n3 <- num3        // ErrorB
  yield n1 + n2 + n3
