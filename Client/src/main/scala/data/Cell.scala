package unitroClient.data
import unitroClient.data.plants._
import unitroClient.data.items._

import processing.core._

object Cell{
	def Setup(c: Cell) = {
		
	}
	
	def Update(c: Cell) = {
		
	}
	
	def Draw(c: Cell) = {
		
	}

	def SetNearCell(c: Cell) = {
		
	}
	
	def GetSoil(c: Cell) = {
		c.soil
	}
	
	def SetSoil(c: Cell, s:Double) = {
		c.soil = s
	}
}

class Cell{
	var soil:Double = 0
	var water:Double = 0
	var temp:Double = 0
	var air:Double = 0
	var nutP:Double = 0
	var nutN:Double = 0
	var brightness:Double = 0
	var plant = new BasePlant
	var item = new BaseItem
}