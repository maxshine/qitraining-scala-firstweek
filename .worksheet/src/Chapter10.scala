object Chapter10 {
  object Ex02 extends App {

		import java.awt.Point
		
	  class OrderedPoint(x: Int, y: Int) extends Point(x, y) with scala.math.Ordered[Point] {
	    def compare(that: Point): Int = {
	      ((this.x - that.x).signum, (this.y - that.y).signum) match {
	        case (-1,_) | (0,-1) => -1
	        case (0, 0) => 0
	        case _ => 1
	      }
	    }
	  }
	}
	
	object Ex04 extends App {

	  trait Logger {
	    def log(msg: String) {}
	  }
	
	  trait PrinterLogger extends Logger {
	    override def log(msg: String) {
	      println(msg)
	    }
	  }
	
	  trait CryptoLogger extends Logger {
	    val key=3
	    override def log(msg: String) {
	      val ceasarMsg = for(c <- msg.toUpperCase) yield c match {
	        case a if 'A'<=a && a<='Z' => applyKey(a, 'A', 26)
	        case a if '0'<=a && a<='9' => applyKey(a, '0', 10)
	        case _ => c
	      }
	      super.log(ceasarMsg)
	    }
	    private def applyKey(c: Char, r: Char, l: Int): Char = {
	      ((c - r + key)%l + r).toChar
	    }
	  }
	
	  class Person(private val _name: String) extends {override val key=9} with PrinterLogger with CryptoLogger {
	    def name = {log(_name); _name}
	  }
	}
}
