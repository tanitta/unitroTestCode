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
	
	def Draw(x: Int, y: Int, z: Int) = {
		var ps = Env.ps
		ps.strokeWeight(1)
		ps.stroke(50)
		
		var lockedAxis = 0
		if(x==4){lockedAxis += 1}
		if(y==4){lockedAxis += 1}
		if(z==4){lockedAxis += 1}
		
		if(lockedAxis == 0){
			var l = math.pow(soil, 1.0/3.0).toFloat
			ps.box(l)
			
			//translate
		}
		
		if(lockedAxis == 1){
			if(x==4){
			}
			
			if(y==4){
			}
			
			if(z==4){
			}
		}
		
		if(lockedAxis == 2){
			if(x==4){
				if(y==4){
				}
				
				if(z==4){
				}
			}
			
			if(y==4){
				if(z==4){
				}
				
				if(x==4){
				}
			}
			
			if(z==4){
				if(x==4){
				}
				
				if(y==4){
				}
			}
		}
		
		
	}

	def SetNearCell(x: Int, y: Int, z: Int) = {
	}
}

