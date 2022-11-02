package fi.jpaju.thesis

// Defined in the standard library
def summon[A](using a: A): A = a

// Defines an implicit value of type Int
given Int = 3

val three = summon[Int] // Finds the value 3 defined above

def implicitSum(a: Int)(using b: Int): Int = a + b
val five                                   = implicitSum(2) /*(compiler automatically inserts 3)*/
