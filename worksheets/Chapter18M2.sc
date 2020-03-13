object Chapter18M2 {
	object Ex04 extends App {
	
		import scala.collection.mutable.ArrayBuffer
		import scala.collection.SortedSet
		
	  class Network {
	    class Member(val name: String) {
	      val contacts = new ArrayBuffer[Member]
	
	      def equals(that: Member):Boolean = true
	    }
	    private val members = new ArrayBuffer[Member]
	
	    def join(name: String) = {
	      val m = new Member(name)
	      members += m
	      m
	    }
	  }
	
	  val NetworkA = new Network
	  val NetworkB = new Network
	
	  val Basile = NetworkA.join("Basile")
	  val John = NetworkA.join("John")
	  val Alfred = NetworkB.join("Alfred")
	
	  assert(Basile.equals(Alfred) == false)
	  assert(Basile.equals(John) == true)
	
	}
	
	object Ex06 extends App {

	  def getClosestValue(s: SortedSet[Int], value: Int): Int Either Int = {
	
	    s.zipWithIndex.collectFirst{
	      case (`value`, i) => Left(i)
	      case (v, i) if v > value => Right(i)
	    }.getOrElse(Right(s.size - 1))
	
	  }
  }
  
  object Ex08 extends App {

	  def printValues(f: {def apply(n: Int):Int}, from: Int, to: Int) {
	    println(
	      (for (n <- (from to `to`)) yield f(n)).mkString(" ")
	    )
	  }
	
	  printValues((x: Int) => x * x, 3, 6)
	  printValues(Array(1, 1, 2, 3, 5, 8, 13, 21, 34, 55), 3, 6)
	}
}