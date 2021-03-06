package com.ad

object Chapter2 {

  // Exercise 2.1
  // nth Fibonacci number
  def fib(n: Int) : Int = {
    require(n >= 1 , "n should be greater than 0")
    @annotation.tailrec
    def go(n:Int, a:Int, b:Int) : Int = n match {
      case 0 => a
      case _ => go( n - 1, b, a + b)
    }
    go(n - 1, 0, 1)
  }

  // Exercise 2.2
  // Unlike haskell, the pattern matching did not work correctly for scala arrays
  @annotation.tailrec
  def isSorted[A](as: Array[A], ordered: (A, A) => Boolean): Boolean = as.length match {
    case 0 => true
    case 1 => true
    case _ => if (ordered(as(0), as(1))) isSorted( as.tail, ordered)
              else false
  }

  // Exercise 2.3
  def curry[A, B, C](f: (A, B) => C) : A => (B => C) = a => b => f(a, b)

  // Exercise 2.4
  def uncurry[A, B, C](f: A => B => C ) : (A, B) => C = (a, b) => f(a)(b)

  // Exercise 2.5
  def compose[A, B, C](f: B => C , g: A => B) : A => C = a => f(g(a))
}
