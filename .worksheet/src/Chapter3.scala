object Chapter3 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(125); 
	def ex1(n:Int):Array[Int] = {
		import util.Random
		(new Array[Int](n)).map(_ => Random.nextInt(n))
		
	};System.out.println("""ex1: (n: Int)Array[Int]""");$skip(9); val res$0 = 
	ex1(10);System.out.println("""res0: Array[Int] = """ + $show(res$0));$skip(155); 
	
	def ex2(a: Array[Int]):Array[Int] = {
    for(i <- 1.until(a.length-1).by(2)) {
      val t = a(i)
      a(i) = a(i-1)
      a(i-1) = t
    }
    a
  };System.out.println("""ex2: (a: Array[Int])Array[Int]""");$skip(24); val res$1 = 
  ex2(Array(2,3,1,4,5));System.out.println("""res1: Array[Int] = """ + $show(res$1));$skip(213); 
  
  def ex3(a: Array[Int]):Array[Int] =
    (for(i <- 0 until a.length) yield
      if (i%2==0 && (i+1)==a.length) a(i) //last element for odd length
      else if (i%2==0) a(i+1)
      else a(i-1)
    ).toArray;System.out.println("""ex3: (a: Array[Int])Array[Int]""");$skip(24); val res$2 = 
  ex3(Array(2,3,1,4,5));System.out.println("""res2: Array[Int] = """ + $show(res$2));$skip(57); 
  
  def ex5(a: Array[Double]):Double = a.sum / a.length;System.out.println("""ex5: (a: Array[Double])Double""");$skip(31); val res$3 = 
  
  ex5(Array(2.0, 3.4, 1.2));System.out.println("""res3: Double = """ + $show(res$3));$skip(222); 
  
  def ex6 = {
  	import collection.mutable.ArrayBuffer
		var a = Array(30,42,51,4,25)
  	a = a.sortWith(_>_)
  	a.foreach(println)

  	var b = ArrayBuffer(30,42,51,4,25)
  	b = b.sortWith(_>_)
  	b.foreach(println)
  };System.out.println("""ex6: => Unit""");$skip(6); 
  ex6;$skip(58); 
  
  def ex7(a: Array[Int]) = a.distinct.foreach(println);System.out.println("""ex7: (a: Array[Int])Unit""");$skip(33); 
  
  ex7(Array(1,1,1,1,2,2,2,3))}
  
}
