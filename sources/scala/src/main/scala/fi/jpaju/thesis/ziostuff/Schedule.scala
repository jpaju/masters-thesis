package fi.jpaju.thesis.ziostuff

import zio.*

object Foo:
  val left  = Schedule.recurs(3)
  val right = Schedule.recurs(3)

  Schedule.spaced(7.millis)      // Constant delay between every computation
  Schedule.fixed(7.millis)       // Computations start at constant intervals
  Schedule.fibonacci(2.millis)   // 2ms | 4ms | 6ms | 10ms | 16ms
  Schedule.exponential(2.millis) // 2ms | 4ms | 8ms | 16ms | 32ms

  Schedule.forever   // Schedule always wants to continue
  Schedule.stop      // Schedule that never wants to continue
  Schedule.recurs(5) // Schedule that wants to continue 5 times

  left ++ right // First left schedule to complection, then right
  left && right // Recurs when both schedules want to continue
  left || right // Recurs when either schedule wants to continue
