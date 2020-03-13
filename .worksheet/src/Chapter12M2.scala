object Chapter12M2 {
  object Ex01 extends App {

	  def values(fun: (Int) => Int, low: Int, high: Int) = for(v <- low to high) yield (v, fun(v))
	
	  val result = values(x => x * x, -5, 5)
	
	  println( result )

	}

	object Ex02 extends App {
	
	  val a = Array(1, 25, 47, 2, 54, 0, 6)
	
	  assert( a.reduceLeft[Int]((a,b) => if (a>b) a else b) == 54 )
	
	}
	
	object Ex03 extends App {

	  def fact(v: Int): Int = (1 to v).reduceLeft(_ * _)
	
	  assert( fact(5) == 120 )
	
	}
	
	object Ex04 extends App {

	  def fact(v: Int): Int = (1 to v).foldLeft(1)(_ * _)
	
	  assert( fact(0) == 1 )
	
	  assert( fact(5) == 120 )
	
	}
	
	object Ex05 extends App {
	
	  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
	    inputs.map(fun).reduceLeft((a,b) => if (a>b) a else b)
	  }
	
	  assert( largest(x => 10 * x - x * x, 1 to 10) == 25 )
	
	}

	object Ex06 extends App {
	
	  def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
	    inputs.map(a => (fun(a),a)).reduceLeft( (a,b) => if (a._1>b._1) a else b )._2
	  }
	
	  assert( largest(x => 10 * x - x * x, 1 to 10) == 5)
	
	}

	object Ex07 extends App {
	
	  def adjustToPair(f: (Int, Int) => Int) = (t: (Int, Int)) => f(t._1, t._2)
	
	  val pairs = (1 to 10) zip (11 to 20)
	
	  println(pairs.map(adjustToPair(_ * _)(_)))
	
	
	}

	object Ex08 extends App {
	
	  val a = Array("Hello", "World")
	  val b = Array(5, 4)
	
	
	  assert( a.corresponds(b)(_.length==_) == false )
	
	}
}
