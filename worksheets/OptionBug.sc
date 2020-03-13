object OptionBug {
//https://conscientiousprogrammer.com/blog/2013/12/23/tostring-considered-harmful-part-1/
  object Example extends App {
	  type Id = Int
	 
	  /**
	    @param name User name to look up
	    @return ID of user, or 0 if the lookup fails
	    */
	  def findId(name: String): Id =
	    if (name == "name") 42
	    else 0
	 
	  def makeUrl(id: Id): String = s"http://service.com?id=$id"
	 
	  /** Simulate making the Web request. */
	  def getUrl(url: String): Unit = println(url)
	 
	  val id = findId("name")
	  getUrl(makeUrl(id))
	  // output: http://service.com?id=42
	}
	
	object BugExample extends App {
	  type Id = Int
	 
	  /**
	    @param name User name to look up
	    @return Some(ID of user), or None if the lookup fails
	    */
	  def findId(name: String): Option[Id] =
	    if (name == "name") Some(42)
	    else None
	 
	  def makeUrl(id: Option[Id]): String = s"http://service.com?id=$id"
	 
	  /** Simulate making the Web request. */
	  def getUrl(url: String): Unit = println(url)
	 
	  val id = findId("name")
	  getUrl(makeUrl(id))
	}
}