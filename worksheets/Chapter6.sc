object Chapter6 {
   object Ex1 {
    def inchesToCentimeters(inches: Double) = {
      inches*2.54
    }
    def gallonsToLiters(gallons: Double) = {
      gallons*3.78541178
    }
    def milesToKilometers(miles: Double) = {
      miles*1.609344
    }
  }
  Ex1.inchesToCentimeters(2.0)                    //> res0: Double = 5.08
  
  abstract class UnitConversion {
    def convert(value: Double): Double
  }

  object Ex2InchesToCentimeters extends UnitConversion {
    def convert(value: Double) = {
      value*2.54
    }
  }
  object Ex2GallonsToLiters extends UnitConversion {
    def convert(value: Double) = {
      value*3.78541178
    }
  }
  object Ex2MilesToKilometers extends UnitConversion {
    def convert(value: Double) = {
      value*1.609344
    }
  }
  
  object Ex3Origin extends java.awt.Point {}
   
  class Ex4Point(val x:Double, val y: Double)
  
  object Ex4Point {
    def apply(x:Double, y: Double) = new Ex4Point(x, y)
  }
  Ex4Point(3.0, 4.0)                              //> res1: Chapter6.Ex4Point = Chapter6$Ex4Point$2@226a82c4
  
  object Ex05 extends App {
  	if (args.length > 0) println(args.reverse.mkString(" "))
	}
}