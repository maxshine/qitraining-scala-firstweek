object Chapter13 {
	object Ex01 extends App {
		import scala.collection.mutable.Map
		import scala.collection.mutable.SortedSet
		
	  def indexes(s: String) = {
	    s.indices.foldLeft( Map[Char, SortedSet[Int]]() ) {
	      (m, i) =>
	        m += ( s(i) -> (m.getOrElse(s(i), SortedSet[Int]()) += i)	)
	    }
	  }
	
	  /*Should print
	  M:{0}
	  s:{2,3,5,6}
	  p:{8,9}
	  i:{1,4,7,10}
	   */
	  indexes("Mississippi").foreach(t => println(t._1 + ":" + t._2.mkString("{", ",", "}")) )
	
	}
	
	object Ex02 extends App {
		import scala.collection.immutable.SortedMap
		import scala.collection.immutable.SortedSet
		
	  def indexes(s: String) = {
	    s.indices.foldLeft(SortedMap[Char, Set[Int]]()) {
	      (m,i) =>
	        m + ( s(i) -> (m.getOrElse(s(i), SortedSet[Int]()) + i)	)
	    }
	  }
	
	  /*Should print
	  M:{0}
	  s:{2,3,5,6}
	  p:{8,9}
	  i:{1,4,7,10}
	   */
	  indexes("Mississippi").foreach(t => println(t._1 + ":" + t._2.mkString("{", ",", "}")) )
	
	}
}
