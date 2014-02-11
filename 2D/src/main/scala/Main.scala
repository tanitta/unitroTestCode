package trit.unitro2d
import trit.unitro2d._
import processing.core._

object Main extends processing.core.PApplet {
	
	var drawer = new Drawer(this)
	var sim = new Sim()
	
	override def setup(){
		frameRate(60)
		drawer.setup()
		sim.setup()
		for( i <- 1 until Env.sizCellX-1) {
			Zone.nextMatrix(i)(1).soil = 1.0
		}
		
		Zone.nextMatrix(4)(2).soil = 0.5
		Zone.nextMatrix(5)(2).soil = 0.5
		Zone.nextMatrix(4)(3).soil = 0.5
		
		Zone.nextMatrix(4)(4).soil = 0.2
		Zone.nextMatrix(4)(4).plant = new plants.Hordeum()
		
		
		
		Zone.nextMatrix(3)(3).soil = 0.5
		
		Zone.nextMatrix(3)(2).soil = 0.5
		
		
		
	}

	def update(){
		sim.update()		
	}
	
	override def draw(){
		update
		
		drawer.draw()
	}

	def main(args: Array[String]){
		runSketch()  
	}
	
	override def sketchFullScreen():Boolean = {
		return false
		// return true
	}
}