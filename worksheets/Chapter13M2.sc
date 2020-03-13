object Chapter13M2 {
	object Ex04 extends App {
	
	  def indexes(a: Array[String], m: Map[String,Int]) = a.flatMap(m.get(_))
	
	  val a = Array("Tom", "Fred", "Harry")
	  val m = Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)
	
	  assert(indexes(a, m).deep == Array(3,5).deep)
	
	}

	object Ex05 extends App {
	
	  val a = Array("Hello", ", ", "world !")
	
	  println( a.reduceLeft(_ + _) )
	
	}
	
	object Ex06 extends App {

	  val lst = List(1,2,3,4,5,6,7,8,9)
	
	  /*
	  (lst :\ List[Int]())(_ :: _) => foldRight, create a new list with all integeres
	  (List[Int]() /: lst)(_ :+ _) => foldLeft, create a new list with all integeres
	  */
	
	  assert( (List[Int]() /: lst)((i, l) => l +: i) == lst.foldLeft( List[Int]() )( (i, l) => l +: i ) )
	
	}
	
	object Ex07 extends App {
	
	  val prices = List(5.0, 20.0, 9.95)
	  val quantities = List(10, 2, 1)
	
	  (prices zip quantities).map(p => p._1 * p._2)
	
	  (prices zip quantities).map( ((_: Double) * (_ :Int)).tupled ).foreach(println)
	
	}
	
	object Ex08 extends App {
	
	  def array2Dim(a: Array[Int], dim: Int): Array[Array[Int]] = a.grouped(dim).toArray
	
	  val a = Array(1,2,3,4,5,6)
	
	  assert( array2Dim(a, 3).deep == Array(Array(1, 2, 3), Array(4, 5, 6)).deep)
	
	}
	
	object AtomicMap {
	  import scala.io.Source
	  import scala.collection.JavaConversions.mapAsScalaConcurrentMap
	  import java.util.concurrent.atomic.AtomicInteger
	
	  var done = 0
	
	  val frequencies: scala.collection.concurrent.Map[Char, AtomicInteger] = new java.util.concurrent.ConcurrentHashMap[Char, AtomicInteger]
	
	  val files = Array("a.csv", "b.csv")
	
	  files.foreach {	f =>
	    new Thread {
	      override def run() {
	        Source.fromURL(getClass.getResource("/" + f), "UTF-8").getLines.foreach( l =>
	          l.foreach( c => {
	            val zero = new AtomicInteger(0)
	            val value = frequencies.putIfAbsent(c, zero).getOrElse(zero)
	            value.incrementAndGet
	          }
	          )
	        )
	        done += 1
	        if (done == files.length) println( frequencies('e') )
	      }
	    }.start()
	  }
	}
	
	object Ex09 extends App {
	
	  import scala.io.Source
	
	  //val files = Array("a.csv", "b.csv") 25195 17836 43031
	  val files = Array("a.csv", "b.csv")
	
	  val frequencies = new scala.collection.mutable.HashMap[Char, Int] with scala.collection.mutable.SynchronizedMap[Char, Int]
	
	  var done = 0
	
	  files.foreach { f =>
	    new Thread {
	      override def run() {
	        Source.fromURL(getClass.getResource("/" + f), "UTF-8").getLines.foreach(l =>
	          l.foreach(c => frequencies(c) = frequencies.getOrElse(c, 0) + 1) // => Transaction
	        )
	        done += 1
	        if (done == files.length) println( frequencies('e') )
	      }
	    }.start()
	  }
	
	  //Both files contains 43031 'e' and this script return 42228 because of transaction issue
	
	  //AtomicMap return the good value
	  AtomicMap
	}
	
	object Ex10 extends App {
	
	  //It's terrible because parallel collection mutate a common collection frequencies => unpredictable
	
	
	  import scala.io.Source
	  import scala.collection.immutable.HashMap
	
	
	  val str = Source.fromURL(getClass.getResource("/a.csv"), "UTF-8").getLines.mkString
	
	  val result = str.par.aggregate(HashMap[Char, Int]())(
	    (m, c) =>  m + (c -> (m.getOrElse(c, 0) + 1)),
	    (m1, m2) => m1 ++ m2.map{ case (k,v) => k -> (v + m1.getOrElse(k, 0)) }
	  )
	
	  assert( result('e') == 25195 )
	
	
	
	}
}