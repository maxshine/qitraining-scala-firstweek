object Chapter3 {
	def ex1(n:Int):Array[Int] = {
		import util.Random
		(new Array[Int](n)).map(_ => Random.nextInt(n))
		
	}                                         //> ex1: (n: Int)Array[Int]
	ex1(10)                                   //> res0: Array[Int] = Array(7, 3, 6, 7, 0, 0, 9, 0, 9, 9)
	
	def ex2(a: Array[Int]):Array[Int] = {
    for(i <- 1.until(a.length-1).by(2)) {
      val t = a(i)
      a(i) = a(i-1)
      a(i-1) = t
    }
    a
  }                                               //> ex2: (a: Array[Int])Array[Int]
  ex2(Array(2,3,1,4,5))                           //> res1: Array[Int] = Array(3, 2, 4, 1, 5)
  
  def ex3(a: Array[Int]):Array[Int] =
    (for(i <- 0 until a.length) yield
      if (i%2==0 && (i+1)==a.length) a(i) //last element for odd length
      else if (i%2==0) a(i+1)
      else a(i-1)
    ).toArray                                     //> ex3: (a: Array[Int])Array[Int]
  ex3(Array(2,3,1,4,5))                           //> res2: Array[Int] = Array(3, 2, 4, 1, 5)
  
  def ex5(a: Array[Double]):Double = a.sum / a.length
                                                  //> ex5: (a: Array[Double])Double
  
  ex5(Array(2.0, 3.4, 1.2))                       //> res3: Double = 2.2
  
  def ex6 = {
  	import collection.mutable.ArrayBuffer
		var a = Array(30,42,51,4,25)
  	a = a.sortWith(_>_)
  	a.foreach(println)

  	var b = ArrayBuffer(30,42,51,4,25)
  	b = b.sortWith(_>_)
  	b.foreach(println)
  }                                               //> ex6: => Unit
  ex6                                             //> 51
                                                  //| 42
                                                  //| 30
                                                  //| 25
                                                  //| 4
                                                  //| 51
                                                  //| 42
                                                  //| 30
                                                  //| 25
                                                  //| 4
  
  def ex7(a: Array[Int]) = a.distinct.foreach(println)
                                                  //> ex7: (a: Array[Int])Unit
  
  ex7(Array(1,1,1,1,2,2,2,3))                     //> 1
                                                  //| 2
                                                  //| 3
  
}