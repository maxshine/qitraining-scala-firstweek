object Chapter2 {
  def ex1(value: Int): Int = {
	  if (value > 0)
	  	1
	  else if (value < 0)
	  	-1
	  else
	  	0
	}                                         //> ex1: (value: Int)Int
	val ans11 = ex1(100)                      //> ans11  : Int = 1
	val ans12 = ex1(-100)                     //> ans12  : Int = -1
	val ans13 = ex1(0)                        //> ans13  : Int = 0
	
	def ex2 = {
		assert( {} == () )
		assert( {}.isInstanceOf[Unit] )
	}                                         //> ex2: => Unit
	ex2
	
	def ex3 = {
		var y:Int = 0
		var x:Unit = y = 1
	}                                         //> ex3: => Unit
	ex3
	
	def ex4 = {
		10.to(0,-1).foreach(println)
	}                                         //> ex4: => Unit
	ex4                                       //> 10
                                                  //| 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
	
	def ex5(n:Int):Unit = {
		if (n>=0) {
			println(n)
			ex5(n-1)
		}
	}                                         //> ex5: (n: Int)Unit
	ex5(10)                                   //> 10
                                                  //| 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0
  def ex6 {
  	var result = 1L;
  	for (c <- "Hello") result *= c.toLong
  	println(result)
  }                                               //> ex6: => Unit
  ex6                                             //> 9415087488
  
  def ex7 {
  	var result = "Hello".map(_.toLong).product
  	println(result)
  }                                               //> ex7: => Unit
  ex7                                             //> 9415087488
  
  def ex8(s: String): Long = s.map(_.toLong).product
                                                  //> ex8: (s: String)Long
  ex8("Hello")                                    //> res0: Long = 9415087488
  
  def ex9(s: String): Long = {
    if (s.tail != "") s.head.toLong * ex9(s.tail) else s.head.toLong
  }                                               //> ex9: (s: String)Long
  ex9("Hello")                                    //> res1: Long = 9415087488
  
  def ex10(x: Double, n: Int): Double = {
    if (n >1  && n % 2 == 0) ex10( x, n / 2 ) * ex10( x, n / 2 )
    else if (n > 1 && n % 2 != 0) x * ex10( x, n - 1 )
    else if (n < 0) 1 / ex10( x, -n )
    else if (n == 1) x
    else 1
  }                                               //> ex10: (x: Double, n: Int)Double
  ex10(10,3)                                      //> res2: Double = 1000.0
}