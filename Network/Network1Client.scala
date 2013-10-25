import java.net._
object Network1Client{
	val host = "javasv"
	val port = 50000
	def main(args: Array[String]): Unit = {
	  var socket = newSocket()
	  sokcet.connect(new InterSocketAddress(host,port))
	  
	  sokcet.close()
	}
	
}