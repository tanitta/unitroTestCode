package unitroClient.data
import unitroClient.data._
import unitroClient._
import processing.core._


object Cell{
}

class Cell{
	var soil:Double = 0
	var water:Double = 0
	var temp:Double = 0
	var air:Double = 0
	var nutP:Double = 0
	var nutN:Double = 0
	var brightness:Double = 0
	var plant = new plants.BasePlant(this)
	var item = new items.BaseItem
	
	def Update = {
		plant.Update
	}
	
	def Draw = {
		var ps = Env.ps
		ps.strokeWeight(1)
		ps.stroke(50)
		ps.box(math.pow(soil, 1/3).toFloat)
	}

	def SetNearCell(x: Int, y: Int, z: Int) = {
	}
}

