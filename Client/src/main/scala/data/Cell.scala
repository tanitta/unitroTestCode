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
		ps.stroke(10,100,25)
		ps.fill(10, 100, 50)
		
		var lockedAxis = 0
		if(x==2){lockedAxis += 1}
		if(y==2){lockedAxis += 1}
		if(z==2){lockedAxis += 1}
		
		lockedAxis match {
			case 0 =>
				var l:Float = math.pow(soil, 1.0/3.0).toFloat
				var d:Float = 0.5f-l*0.5f
				//translate
				ps.pushMatrix()
					ps.translate(x*d, y*d, z*d)
					ps.box(l)
				ps.popMatrix()
				
			case 1 =>
				if(x==2){
					var l = math.pow(soil, 1.0/2.0).toFloat
					var d:Float = 0.5f-l*0.5f
					ps.pushMatrix()
						ps.translate(0, y*d, z*d)
						ps.box(1,l,l)
					ps.popMatrix()
				}
				
				if(y==2){
					var l = math.pow(soil, 1.0/2.0).toFloat
					var d:Float = 0.5f-l*0.5f
					ps.pushMatrix()
						ps.translate(x*d, 0, z*d)
						ps.box(l,1,l)
					ps.popMatrix()
				}
				
				if(z==2){
					var l = math.pow(soil, 1.0/2.0).toFloat
					var d:Float = 0.5f-l*0.5f
					ps.pushMatrix()
						ps.translate(x*d, y*d, 0)
						ps.box(l,l,1)
					ps.popMatrix()
				}
				
			case 2 =>
				if(x==2){
					if(y==2){
						var l = soil.toFloat
						var d:Float = 0.5f-l*0.5f
						ps.pushMatrix()
							ps.translate(0, 0, z*d)
							ps.box(1,1,l)
						ps.popMatrix()
					}
					
					if(z==2){
						var l = soil.toFloat
						var d:Float = 0.5f-l*0.5f
						ps.pushMatrix()
							ps.translate(0, y*d, 0)
							ps.box(1,l,1)
						ps.popMatrix()
					}
				}
				
				if(y==2){
					if(z==2){
						var l = soil.toFloat
						var d:Float = 0.5f-l*0.5f
						ps.pushMatrix()
							ps.translate(x*d, 0, 0)
							ps.box(l,1,1)
						ps.popMatrix()
					}
				}
		}
		plant.Draw
	}

	def SetNearCell(x: Int, y: Int, z: Int) = {
	}
}

