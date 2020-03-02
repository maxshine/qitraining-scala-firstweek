object Chapter4 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(362); 
  def ex1 {
  	val original: Map[String, Double] = Map("Nexus 5" -> 300, "Nexus 7" -> 200, "Chromecast" -> 35)
  	val discount: Map[String, Double] = original.map(kv=>(kv._1, kv._2*0.9))
  	val discount2: Map[String, Double] = original.map{case (k, v)=>(k, v*0.9)}
  	original.map(println)
  	discount.map(println)
  	discount2.map(println)
  };System.out.println("""ex1: => Unit""");$skip(6); 
  ex1;$skip(275); 
  
  def ex7 {
  	import scala.collection.JavaConverters._
  	val props: scala.collection.Map[String, String] = System.getProperties.asScala

  	val maxLength = props.keys.maxBy(_.length).length

  	for((k,v) <- props) println(k + " " * (maxLength - k.length) + "|" + v)
  };System.out.println("""ex7: => Unit""");$skip(6); 
  ex7;$skip(60); 
  
  def ex8(a:Array[Int]):Array[Int] = Array(a.min, a.max);System.out.println("""ex8: (a: Array[Int])Array[Int]""");$skip(45); val res$0 = 
  ex8(Array(0,1,2,3,4,5,6,7,8,9)).map(print);System.out.println("""res0: Array[Unit] = """ + $show(res$0));$skip(102); 
  
  def ex9(values: Array[Int], v: Int) = (values.count(_<v), values.count(_==v), values.count(_>v));System.out.println("""ex9: (values: Array[Int], v: Int)(Int, Int, Int)""");$skip(49); 
  
  println(ex9(Array(0,1,2,3,4,5,6,7,8,9), 5))}
}
