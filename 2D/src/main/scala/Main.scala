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
		
		Zone.nextMatrix(4)(4).soil = 0.7
		Zone.nextMatrix(5)(4).soil = 0.9
		Zone.nextMatrix(4)(5).soil = 0.9
		Zone.nextMatrix(5)(5).soil = 0.7
		Zone.nextMatrix(4)(5).soil = 0.4
		Zone.nextMatrix(4)(6).soil = 0.4
		Zone.nextMatrix(3)(6).soil = 0.3

		// Zone.nextMatrix(3)(6).plant = new plants.Hordeum(3,6)
		
		// Zone.nextMatrix(3)(6).item = new items.Seed(3,6)
		// Zone.nextMatrix(3)(6).item.SetPlantName("aaaa")
		
		class MotherHoge{
			
		}
		class SubHoge() extends MotherHoge {
			
		}
		var inst = new MotherHoge
		println("isInstanceOf?" + inst.isInstanceOf[SubHoge])
		
		// var a = new plants.BasePlant(3,6)
		// println(a.objectName)
		// println("isInstanceOf?" + a.isInstanceOf[plants.Hordeum])
		
		// // a.asInstanceOf[plants.Hordeum]
		// a = new plants.Hordeum(3,6)
		// println(a.objectName)
		
		// println(a.aaaa)
		
		// a.aaaa = 2
		
		Zone.nextMatrix(5)(4).soil = 0.4
		Zone.nextMatrix(3)(3).soil = 0.5
		Zone.nextMatrix(3)(2).soil = 0.8
	}

	def update(){
		sim.update()	
		var x = (mouseX/16).toInt
		var y = ((Env.sizScreenY-mouseY+8)/16).toInt
		if(mousePressed && 1<=x && x<=Env.sizCellX-2 && 1<=y && y<=Env.sizCellY-2){
			Zone.nextMatrix(x)(y).soil +=0.02
		}	
	}
	
	override def draw() = {
		update	
		drawer.draw()
		rectMode(PConstants.RADIUS)
		noFill()
		stroke(0,0,100)
		rect((mouseX/16).toInt*16, (mouseY/16).toInt*16,8,8)
		println("X : " + (mouseX/16).toInt + "Y : " + ((Env.sizScreenY-mouseY+8)/16).toInt)
	}

	def main(args: Array[String]){
		runSketch()
	}
	
	
	
	override def sketchFullScreen():Boolean = {
		return false
		// return true
	}
}