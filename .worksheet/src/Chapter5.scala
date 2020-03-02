object Chapter5 {
	class Counter(private var value: Int) {
		require(value < Int.MaxValue)
	  def increment() {
	    if (value <= Int.MaxValue - 1) {
	      value += 1
	    }
	  }
	  def current = value
	};import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(324); 
  def ex1 {
  	val cntr = new Counter(Int.MaxValue-1)
  	cntr.increment
  	cntr.increment
  	println(cntr.current)
  };System.out.println("""ex1: => Unit""");$skip(6); 
  ex1
  
  class BankAccount(private var _balance:Double = 0.0) {

    def deposit(value:Int) {
      _balance += value
    }

    def withdraw(value:Int) {
      if (_balance - value > 0){
        _balance -= value
      }
    }

    def balance = _balance
  };$skip(416); 
  
  def ex2 {
  	val account = new BankAccount(100.0)
  	account.deposit(1)
  	println(account.balance)
  	account.withdraw(2)
  	println(account.balance)
  };System.out.println("""ex2: => Unit""");$skip(6); 
  ex2
  class Time(private var _hrs:Int, private var _min:Int) {
    _min = _min match {
      case i:Int if i%60==0 => {_hrs += i/60; 0}
      case i:Int if i<0 => {_hrs += (i/60 - 1); 60 + i%60}
      case i:Int if i>59 => {_hrs += i/60; i%60}
      case _ => _min
    }
    _hrs = _hrs match {
      case i:Int if i<0 => 24 + i%24
      case i:Int if i>23 => i%24
      case _ => _hrs
    }

    def hrs = _hrs
    def min = _min
    def before(other:Time) = {
      _hrs < other._hrs || (other._hrs == _hrs && _min < other._min)
    }
  };$skip(652); 
  
  def ex3 {
  	val time1 = new Time(23, 59)
  	val time2 = new Time(23, 58)
  	println(time1.before(time2))
  };System.out.println("""ex3: => Unit""");$skip(6); 
  ex3}
  
  class Ex4Time(private var _hrs:Int, private var _min:Int) {
    _min = _min match {
      case i:Int if i%60==0 => {_hrs += i/60; 0}
      case i:Int if i<0 => {_hrs += (i/60 - 1); 60 + i%60}
      case i:Int if i>59 => {_hrs += i/60; i%60}
      case _ => _min
    }
    _hrs = _hrs match {
      case i:Int if i<0 => 24 + i%24
      case i:Int if i>23 => i%24
      case _ => _hrs
    }

    private val _nmin = 60*_hrs + _min

    def hrs = _nmin/60
    def min = _nmin%60

    def before(other:Ex4Time) = _nmin < other._nmin
  }
  
  class Ex6Person(private var _age:Int) {

    if (_age <0) _age=0

    def age = _age
    def age_=(newValue: Int) {
      if (newValue > _age) _age = newValue;
    }
  }
  
  class Ex7Person(_fullName:String) {
    val (firstName, lastName) =  _fullName.split(" ") match {
      case Array(x:String, y:String, _*) => (x,y)
      case _ => (null,null)
    }
  }
}
