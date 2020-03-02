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
  };import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(288); val res$0 = 
  Ex1.inchesToCentimeters(2.0)
  
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
  };System.out.println("""res0: Double = """ + $show(res$0));$skip(644); val res$1 = 
  Ex4Point(3.0, 4.0);System.out.println("""res1: Chapter6.Ex4Point = """ + $show(res$1))}
  
  object Ex05 extends App {
  	if (args.length > 0) println(args.reverse.mkString(" "))
	}
}
