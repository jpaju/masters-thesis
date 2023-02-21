package fi.jpaju.thesis
package monad

extension [A](as: List[A])
  def mapM[F[_]: Monad, B](f: A => F[B]): F[List[B]] =
    as match
      case Nil => Monad[F].pure(List.empty)
      case head :: tail =>
        for
          b  <- f(head)
          bs <- tail.mapM(f)
        yield b :: bs

val nums: List[Int] = List(1, 2, 3, 4, 5)
val effectful: Either[String, List[Int]] =
  nums.mapM { n =>
    if n > 5 then Left("Too large") else Right(n * 2)
  }

@main
def polymorphicMonadCombinator =
  println(s"Effectful: $effectful")
