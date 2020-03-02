object Chapter7 {
  object Ex06 extends App {
  
  	import java.util.{HashMap => JavaHashMap}
  	import scala.collection.mutable._

	  val hm = new JavaHashMap[String, String]()
	  hm.put("1", "John")
	  hm.put("2", "Paul")
	
	  val shm = HashMap[String, String]()
	
	  val it = hm.entrySet().iterator()
	  while (it.hasNext()) {
	    val pairs = it.next()
	    shm += (pairs.getKey() -> pairs.getValue())
	  }
	
	  shm.foreach(println)

	}
	
	object Ex07 extends App {

	  object javaToHashMap{
	    import java.util.{HashMap => JavaHashMap}
	
	    def apply[A, B](hm: JavaHashMap[A, B]) = {
	
	      import scala.collection.mutable.HashMap
	      val shm = new HashMap[A, B]()
	
	      val it = hm.entrySet().iterator()
	      while (it.hasNext()) {
	        val pairs = it.next()
	        shm += (pairs.getKey() -> pairs.getValue())
	      }
	      shm
	    }
	  }
	
	  val hm = new java.util.HashMap[String, String]()
	  hm.put("1", "John")
	  hm.put("2", "Paul")
	
	  javaToHashMap(hm).foreach(println)
	
	
	}
}
