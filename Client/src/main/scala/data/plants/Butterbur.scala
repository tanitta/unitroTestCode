package unitroClient.data.plants
import unitroClient._
import processing.opengl._;
import eyln.mqoloader._;

class Butterbur(c:data.Cell) extends BasePlant(c) {
	// var body = new MQOModel(Env.ps); 
	// body.load("resources/Butterbur/Body.mqo")
	
	override def Setup = {
		
	}
	override def Update = {
		if(step>10){
			step = step+1
		}
		
	}
	override def Draw = {
		// Env.ps.
		// body.
		// body.draw
		
	}	
}