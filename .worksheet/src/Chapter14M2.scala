object Chapter14M2 {
  object Ex02 extends App {
	
	  def swap(p: (Int,Int)): (Int, Int) = p match { case (x, y) => (y, x) }
	
	  assert( swap(1, 2) == (2, 1))
	
	}

	object Ex05 extends App {
	
	  val l = List(List(3, 8), 2, List(5))
	
	  def leafSum(l: List[Any]): Int = l.map(_ match {
	    case l: List[Any] => leafSum(l)
	    case x: Int => x
	    case _ => 0
	  }).sum
	
	  assert( leafSum(l) == 18)
	
	}

	object Ex06 extends App {
	
	  sealed abstract class BinaryTree
	  case class Leaf(value: Int) extends BinaryTree
	  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree
	
	
	  val n = Node(Node(Leaf(3), Leaf(8)), Leaf(5))
	
	  def leafSum(bt: BinaryTree): Int = bt match {
	    case Node(left, right) => leafSum(left) + leafSum(right)
	    case Leaf(value) => value
	  }
	
	  assert( leafSum(n) == 16 )
	
	}

	object Ex07 extends App {
	
	  sealed abstract class BinaryTree
	  case class Leaf(value: Int) extends BinaryTree
	  case class Node(bt: BinaryTree*) extends BinaryTree
	
	
	  val n = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
	
	  def leafSum(bt: BinaryTree): Int = bt match {
	    case Node(bts @ _*) => bts.map(leafSum).sum
	    case Leaf(value) => value
	  }
	
	  assert( leafSum(n) == 18 )
	
	}
	
	object Ex08 extends App {
	
	  sealed abstract class BinaryTree
	  case class Leaf(value: Int) extends BinaryTree
	  case class Node(operator: Char, bt: BinaryTree*) extends BinaryTree
	
	  val n = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
	
	  def eval(bt: BinaryTree): Int = bt match {
	    case Node('+', bts @ _*) => bts.map(eval).sum
	    case Node('-', bts @ _*) => bts.map(eval).foldLeft(0)(_ - _)
	    case Node('*', bts @ _*) => bts.map(eval).product
	    case Leaf(value) => value
	    case _ => 0
	  }
	
	  assert( eval(n) == 21)
	
	
	}
	
	object Ex09 extends App {
	
	  val l:List[Option[Int]] = List(Some(1), Some(2), None, Some(4))
	
	  def sum(l: List[Option[Int]]): Int = (for(Some(v) <- l) yield v).sum
	
	  assert( sum(l) == 7 )
	
	}
	
	object Ex10 extends App {
	
	  import scala.math._
	
	  def f(x: Double) = if (x >= 0) Some(sqrt(x)) else None
	  def g(x: Double) = if (x != 1) Some(1 / (x-1)) else None
	
	  def compose(f1: Double => Option[Double], f2: Double => Option[Double]): Double => Option[Double] =
	    (x: Double) => (f1(x), f2(x)) match {
	      case (Some(_), r @ Some(_)) => r
	      case _ => None
	    }
	
	  val c = compose(f, g)
	
	  assert( c(1) == None )
	
	}
}
