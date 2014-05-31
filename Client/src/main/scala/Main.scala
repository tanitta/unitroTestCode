package unitroClient
import unitroClient._
import processing.core._

object Main extends processing.core.PApplet {
	Env.ps = this
	var currentLocalMatrix = Array.ofDim[unitroClient.data.Cell](Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	var nextLocalMatrix = Array.ofDim[unitroClient.data.Cell](Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	for(i <- 0 until Env.ZoneSizeX) {for( j <- 0 until Env.ZoneSizeY) {for( k <- 0 until Env.ZoneSizeZ) {
			currentLocalMatrix(i)(j)(k) = new unitroClient.data.Cell
			nextLocalMatrix(i)(j)(k) = new unitroClient.data.Cell
			
	}}}
	
	override def setup(){
		frameRate(30)
		
		Solver.SetMatrix(currentLocalMatrix, nextLocalMatrix)
		Drawer.SetMatrix(currentLocalMatrix, nextLocalMatrix)
		Solver.Setup
		Drawer.Setup
	}

	def update(){
		Solver.Update
		Drawer.Update
	}
	
	override def draw() = {
		update	
		Drawer.Draw
	}

	def main(args: Array[String]){runSketch()}
	
	override def sketchFullScreen():Boolean = {
		return false
	}
}