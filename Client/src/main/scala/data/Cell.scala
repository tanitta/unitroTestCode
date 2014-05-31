package unitroClient.data
import unitroClient.data.plants._
import unitroClient.data.items._
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
	var plant = new BasePlant(this)
	var item = new BaseItem
	
	def Update = {
		plant.Update
	}
	
	def Draw = {
	}

	def SetNearCell(x: Int, y: Int, z: Int) = {
	}
}