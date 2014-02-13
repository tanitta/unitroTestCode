package trit.unitro2d.plants
import trit.unitro2d._
import processing.core._

class BasePlant(var x:Int, var y:Int){
	var objectName = "BasePlant"
	var nutP:Double = 0.0
	var nutN:Double = 0.0
	var water:Double = 0.0
	var nutPMax = 0  
	var isDied:Boolean = false
	
	def setup(){}
	def update(){}
	def draw(ps: PApplet){}
}