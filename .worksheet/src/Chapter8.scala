object Chapter8 {
  object Ex01 extends App {

	  class BankAccount(initialBalance: Double) {
	    protected var balance = initialBalance
	    def deposit(amount: Double) = { balance += amount; balance }
	    def withdraw(amount: Double) = { balance -= amount; balance }
	    def getBalance = balance
	  }
	
	  class CheckingAccount(initialBalance: Double) extends BankAccount(initialBalance) {
	    def charge {balance -= 1}
	    override def deposit(amount: Double) = { charge; super.deposit(amount) }
	    override def withdraw(amount: Double) = { charge; super.withdraw(amount) }
	  }
	
	  val MyAccount = new CheckingAccount(100)
	
	  MyAccount.deposit(10)
	}
	
	object Ex02 extends App {
	
	  class SavingsAccount(initialBalance: Double) extends Ex01.BankAccount(initialBalance) {
	
	    var countDeposit = 0
	
	    def earnMonthlyInterest(rate: Double = 0.01) {
	      balance += balance * rate
	      countDeposit = 0
	    }
	
	    def charge {
	      countDeposit += 1
	      if (countDeposit > 3) balance -= 1
	    }
	    override def deposit(amount: Double) = { charge; super.deposit(amount) }
	    override def withdraw(amount: Double) = { charge; super.withdraw(amount) }
	
	  }
	
	  val MyAccount = new SavingsAccount(100)
	
	  MyAccount.deposit(10)
	  MyAccount.withdraw(20)
	  MyAccount.deposit(10)
	
	  assert( MyAccount.getBalance == 100.0)
	
	  MyAccount.deposit(10)
	
	  assert( MyAccount.getBalance == 109.0)
	
	  MyAccount.earnMonthlyInterest()
	
	  assert( MyAccount.getBalance == 110.09 )
	
	  MyAccount.deposit(10)
	
	  assert( MyAccount.getBalance == 120.09 )
	
	}
}
