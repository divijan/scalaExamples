import scala.collection.JavaConversions._
import scala.language.postfixOps._
/**
 * Created by yar on 04.09.14.
 */


object Solution {
  implicit class MyInt(i : Int) {
    def ++(): MyInt = new MyInt(i + 1)
    override def toString = i.toString
  }
  println(s"2++ = ${2++}")
}
