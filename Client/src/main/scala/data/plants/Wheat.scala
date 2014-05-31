package unitroClient.data.plants
import unitroClient._

class Wheat(c:data.Cell) extends BasePlant(c) {
	override def Setup = {
		
	}
	override def Update = {
		if(step>10){
			step = step+1
		}
		
	}
	override def Draw = {
		// Env.ps.
	}	
}
