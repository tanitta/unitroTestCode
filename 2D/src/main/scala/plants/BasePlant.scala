package trit.unitro2d.plants
import trit.unitro2d._
class BasePlant(){
	var planttype = "BasePlant"
	var nutP:Double = 0.0
	var nutN:Double = 0.0
	var water:Double = 0.0
	var nutPMax = 0  
	var isDied:Boolean = false
	
	def setup(){}
	def update(){}
	def draw(){}
}