object Chapter2 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(119); 
  def ex1(value: Int): Int = {
	  if (value > 0)
	  	1
	  else if (value < 0)
	  	-1
	  else
	  	0
	};System.out.println("""ex1: (value: Int)Int""");$skip(22); 
	val ans11 = ex1(100);System.out.println("""ans11  : Int = """ + $show(ans11 ));$skip(23); 
	val ans12 = ex1(-100);System.out.println("""ans12  : Int = """ + $show(ans12 ));$skip(20); 
	val ans13 = ex1(0);System.out.println("""ans13  : Int = """ + $show(ans13 ));$skip(73); 
	
	def ex2 = {
		assert( {} == () )
		assert( {}.isInstanceOf[Unit] )
	};System.out.println("""ex2: => Unit""");$skip(5); 
	ex2;$skip(55); 
	
	def ex3 = {
		var y:Int = 0
		var x:Unit = y = 1
	};System.out.println("""ex3: => Unit""");$skip(5); 
	ex3;$skip(49); 
	
	def ex4 = {
		10.to(0,-1).foreach(println)
	};System.out.println("""ex4: => Unit""");$skip(5); 
	ex4;$skip(74); 
	
	def ex5(n:Int):Unit = {
		if (n>=0) {
			println(n)
			ex5(n-1)
		}
	};System.out.println("""ex5: (n: Int)Unit""");$skip(9); 
	ex5(10);$skip(96); 
  def ex6 {
  	var result = 1L;
  	for (c <- "Hello") result *= c.toLong
  	println(result)
  };System.out.println("""ex6: => Unit""");$skip(6); 
  ex6;$skip(84); 
  
  def ex7 {
  	var result = "Hello".map(_.toLong).product
  	println(result)
  };System.out.println("""ex7: => Unit""");$skip(6); 
  ex7;$skip(56); 
  
  def ex8(s: String): Long = s.map(_.toLong).product;System.out.println("""ex8: (s: String)Long""");$skip(15); val res$0 = 
  ex8("Hello");System.out.println("""res0: Long = """ + $show(res$0));$skip(107); 
  
  def ex9(s: String): Long = {
    if (s.tail != "") s.head.toLong * ex9(s.tail) else s.head.toLong
  };System.out.println("""ex9: (s: String)Long""");$skip(15); val res$1 = 
  ex9("Hello");System.out.println("""res1: Long = """ + $show(res$1));$skip(241); 
  
  def ex10(x: Double, n: Int): Double = {
    if (n >1  && n % 2 == 0) ex10( x, n / 2 ) * ex10( x, n / 2 )
    else if (n > 1 && n % 2 != 0) x * ex10( x, n - 1 )
    else if (n < 0) 1 / ex10( x, -n )
    else if (n == 1) x
    else 1
  };System.out.println("""ex10: (x: Double, n: Int)Double""");$skip(13); val res$2 = 
  ex10(10,3);System.out.println("""res2: Double = """ + $show(res$2))}
}
