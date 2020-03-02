object Chapter18 {
  object Ex01 {
	  class Pair[T, S](val first: T, val second: S) {
	    def swap:Pair[S, T] = new Pair(second, first)
	  }
	}
	
	object Ex02 {
	  class Pair[T](val first: T, val second: T) {
	    def swap:Pair[T] = new Pair(second, first)
	  }
	}

	object Ex03 {
	
	  class Pair[T, S](val first: T, val second: S) {}
	
	  def swap[T, S](p: Pair[T, S]): Pair[S, T] = {
	    new Pair(p.second, p.first)
	  }
	
	}

}
