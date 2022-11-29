package fi.jpaju.thesis
package scalalang

import java.io.*

object Basics:
  trait Foo // Define an interface (line comment starts with //)
  class Bar extends Foo // Define a class inheriting from Foo

  // Define variables/constants
  var mutableFoo: Foo = Bar() // Explicit type is Foo
  val immutableBar    = Bar() // Inferred type is Bar
  lazy val lazyPlus   = 1 + 1 // Computed lazily and cached

  // Type parameter here is Int
  val genericType: List[Int] = List(1, 2, 3)

  // The type parameters are declared between '[' and ']'
  def genericMethod[A](a: A): A = a

  // Generic type can be constrained to a subtype with '<:'
  def lowerTypeBound[A <: Foo](a: A): String = ???

  // Generic type can be constrained to a supertype with '>:'
  def upperTypeBound[A >: Bar](a: A): String = ???

  // ??? can replace any expression, because Nothing is bottom type
  def `???` : Nothing = throw new NotImplementedError

  // The parameter is evaluated every time it is used (2 times here)
  def byNameParameter(n: => Int) = n + n