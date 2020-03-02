object Chapter4 {
  def ex1 {
  	val original: Map[String, Double] = Map("Nexus 5" -> 300, "Nexus 7" -> 200, "Chromecast" -> 35)
  	val discount: Map[String, Double] = original.map(kv=>(kv._1, kv._2*0.9))
  	val discount2: Map[String, Double] = original.map{case (k, v)=>(k, v*0.9)}
  	original.map(println)
  	discount.map(println)
  	discount2.map(println)
  }                                               //> ex1: => Unit
  ex1                                             //> (Nexus 5,300.0)
                                                  //| (Nexus 7,200.0)
                                                  //| (Chromecast,35.0)
                                                  //| (Nexus 5,270.0)
                                                  //| (Nexus 7,180.0)
                                                  //| (Chromecast,31.5)
                                                  //| (Nexus 5,270.0)
                                                  //| (Nexus 7,180.0)
                                                  //| (Chromecast,31.5)
  
  def ex7 {
  	import scala.collection.JavaConverters._
  	val props: scala.collection.Map[String, String] = System.getProperties.asScala

  	val maxLength = props.keys.maxBy(_.length).length

  	for((k,v) <- props) println(k + " " * (maxLength - k.length) + "|" + v)
  }                                               //> ex7: => Unit
  ex7                                             //> gopherProxySet               |false
                                                  //| awt.toolkit                  |sun.lwawt.macosx.LWCToolkit
                                                  //| java.specification.version   |11
                                                  //| sun.cpu.isalist              |
                                                  //| sun.jnu.encoding             |UTF-8
                                                  //| java.class.path              |/Applications/Eclipse.app/Contents/Eclipse/con
                                                  //| figuration/org.eclipse.osgi/1632/0/.cp/target/lib/worksheet-runtime-library.
                                                  //| jar:/Library/Java/JavaVirtualMachines/jdk-11.0.1.jdk/Contents/Home/lib/jrt-f
                                                  //| s.jar:/Applications/Eclipse.app/Contents/Eclipse/plugins/org.scala-lang.scal
                                                  //| a-library_2.12.3.v20170725-052526-VFINAL-6ac6da8.jar:/Applications/Eclipse.a
                                                  //| pp/Contents/Eclipse/plugins/org.scala-lang.scala-reflect_2.12.3.v20170725-05
                                                  //| 2526-VFINAL-6ac6da8.jar:/Users/ygao/Develop/ScalaWorkspaces/qitraining/First
                                                  //| WeekModule/bin:/Users/ygao/Develop/ScalaWorkspaces/qitraining/FirstWeekModul
                                                  //| e/bin:/Users/ygao/Develop/ScalaWorkspaces/qitraining/FirstWeekModule/.worksh
                                                  //| eet/bin
                                                  //| java.vm.vendor               |Oracle Corp
                                                  //| Output exceeds cutoff limit.
  
  def ex8(a:Array[Int]):Array[Int] = Array(a.min, a.max)
                                                  //> ex8: (a: Array[Int])Array[Int]
  ex8(Array(0,1,2,3,4,5,6,7,8,9)).map(print)      //> 09res0: Array[Unit] = Array((), ())
  
  def ex9(values: Array[Int], v: Int) = (values.count(_<v), values.count(_==v), values.count(_>v))
                                                  //> ex9: (values: Array[Int], v: Int)(Int, Int, Int)
  
  println(ex9(Array(0,1,2,3,4,5,6,7,8,9), 5))     //> (5,1,4)
}