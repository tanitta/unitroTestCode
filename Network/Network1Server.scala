import java.io._
import java.net._
object Network1Server{
	val port = 50000
	val timeout = 100000
	def main(args: Array[String]): Unit = {
		var svsocket = new ServerSocket(port)
		svsocket.setSoTimeout(timeout)
		
		var socket:Socket = svsocket.accept()
		var out = new DataOutputStream(socket.getOutputStream)
		out.writeBytes("Hello!\n")
		socket.close
	}
	
}