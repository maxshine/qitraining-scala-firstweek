object Chapter11M2 {
  class Ex4Money(d: Int, c: Int) {

    def +(that: Ex4Money) = Ex4Money(toFloat + that.toFloat)
    def -(that: Ex4Money) = Ex4Money(toFloat - that.toFloat)
    def ==(that: Ex4Money) = toFloat==that.toFloat
    def <(that: Ex4Money) = toFloat<that.toFloat

    def toFloat = (d+"."+c).toFloat

  }

  object Ex4Money{
    def apply(d: Int, c: Int): Ex4Money = new Ex4Money(d, c)
    def apply(d: Float): Ex4Money = {
      val s = d.toString.split('.')
      new Ex4Money(s(0).toInt, s(1).toInt)
    }
  }
  
	import scala.collection.mutable.ArrayBuffer
  class Ex5Table {
    private val items = ArrayBuffer[ArrayBuffer[String]](ArrayBuffer())

    def |(s: String): Ex5Table = {
      items(items.length-1).append(s)
      this
    }
    def ||(s: String): Ex5Table = {
      items += ArrayBuffer(s)
      this
    }
    override def toString = items.map(_.mkString("<td>", "</td><td>", "</td>")).mkString("<table><tr>", "</tr><tr>", "</tr></table>")
  }

  object Ex5Table {
    def apply() = new Ex5Table
  }
  
  class Ex6ASCIIArt(private val _items: Array[String]) {

    def this(s: String) {
      this(s.split("\r\n"))
    }

    def +(that: Ex6ASCIIArt) = {
      new Ex6ASCIIArt(
        (for(k <- _items.indices) yield that.items.isDefinedAt(k) match {
          case true => _items(k) + that.items(k)
          case _ => _items(k)
        }).toArray
      )
    }

    def /(that: Ex6ASCIIArt) = {
      new Ex6ASCIIArt(
        _items ++ that.items
      )
    }

    def items = _items

    override def toString = _items.mkString("\n")
  }

  class Ex7BitSequence(s: String) {
    var l = java.lang.Long.parseLong(s, 2)

    def apply(i: Int) = l & (1<<i)
    def update(i: Int, v: Boolean) {
      l = v match {
        case true => l | (1<<i)
        case false => l ^ (1<<i)
      }
    }
    override def toString = l.toString
  }
  
  class Ex8Matrix(val m: Array[Array[Double]]) {

    val rows = 	m.length
    val cols = m(0).length

    def apply(r: Int, c: Int) = m(r)(c)
    def update(r: Int, c: Int, v: Double) { m(r)(c) = v}

    private def compute(that: Ex8Matrix, f:(Double,Double) => Double): Array[Array[Double]] = {
      if (that.dim != dim) throw new Exception("Can only add matrix with same size")
      (for (i <- m.indices) yield m(i).zip(that.m(i)).map(v => f(v._1, v._2))).toArray
    }

    def +(that: Ex8Matrix) = new Ex8Matrix(compute(that, (a,b) => a+b))

    def *(that: Ex8Matrix) = new Ex8Matrix(compute(that, (a,b) => a*b))

    def *(s: Double) = {
      new Ex8Matrix(
        ( for (i <- m.indices)
        yield m(i).map(_*s) ).toArray
      )
    }

    def dim = (rows, cols)

    override def toString = m.map(_.mkString(" ")).mkString("\n")
  }
}