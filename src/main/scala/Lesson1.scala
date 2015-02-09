import scala.language.postfixOps // needed for 2++ to compile without warnings
import org.joda.time._
/**
 * In scala code is indented with two spaces. Semicolons at the end of statements are optional
 */


object Lesson1 extends App {
  implicit class MyInt(i : Int) {
    /* parentheses are optional in methods without arguments
       return types are also mostly optional: scala compiler can infer them from the right-hand side of the method
     */
    def ++(): MyInt = new MyInt(i + 1)
    /* override is needed since every class inherits from Any which already has toString
       we can use val since the class is IMMUTABLE. The objects of this class never change
       If we want a MyInt with another int value, we have to create a new object 
     */
    override val toString = i.toString 
  }
  
  /* this class has one constructor with 1 Float parameter
     it also has a variable field _money_ of type Float
     this class is MUTABLE. It means it can change its state during its lifetime
   */
  class Wallet(private var _money: Float) {
    private val negMoneyException = new IllegalArgumentException("A wallet cannot have negative amount")

    if (_money < 0) throw negMoneyException

    def money = _money // getter
    def money_=(newMoney: Float): Unit =
      if (newMoney < 0) throw negMoneyException else _money = newMoney // setter
    // val, once evaluated, stores the same value
    val dateCreated = new DateTime
    // def, on the other hand, evaluates right-hand side every time it is accessed
    def now = new DateTime
    //since the class is MUTABLE, toString has to be a def, because the amount of money may change
    override def toString = s"Wallet($$$money)"
  }
  
  def demo = { // this has to be called WITHOUT empty parentheses
    println(s"2++ = ${2++}") /* scala compiler sees there is no ++ method on Int, so it looks for an implicit conversion
    * to convert Int into something that has a ++ method, and finds our implicit class.
    * implicit classes are called "pimp my library pattern". They allow us to extend functionality of the classes 
    * from which we cannot inherit directly
    * toString on MyInt is called automatically, just like in Java 
    */
    val five = MyInt(5) // implicit class can be instantiated just like a regular class, even without new keyword
    println(s"five is $five")
    
    /* def and val */
    val myWallet = new Wallet(500)
    //val wrongWallet = new Wallet(-5)
    val created1 = myWallet.dateCreated
    val now1 = myWallet.now
    myWallet.money += 300 // the wallet is the same. The money is different
    println("my wallet is now " + myWallet + " " + myWallet.now + ", it has " + myWallet.money)
    val created2 = myWallet.dateCreated
    val now2 = myWallet.now
    assert(created1 == created2 && now1 == now2) // the difference between the def and the val
    //require
  }
  //TODO: abstract class instantiation

  demo
}
