package unitroClient
import processing.core._
import unitroClient._
// import peasy._

object Drawer{
	var ps = Env.ps
	var camera = new unitroClient.Camera(ps)
	
	type uniMatrix = Array[Array[Array[unitroClient.data.Cell]]]
	var cMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	var nMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	
	def SetMatrix(cMat: uniMatrix, nMat: uniMatrix) = {
		this.cMat = cMat
		this.nMat = nMat
	}
	
	def Setup = {
		ps.size(Env.ScreenSizeX,Env.ScreenSizeY,PConstants.OPENGL)
		
		ps.colorMode(PConstants.HSB, 100)
		ps.background(0,0,100)
		ps.smooth()
	}
	
	def Update = {
		camera.Update	
	}
	
	def Draw = {
		// ps.scale(1000, 1000, 1000)
		ps.background(0,0,100);
		DrawGrid
		DrawMatrix
	}
	
	def DrawMatrix = {
		for(i <- 1 until nMat.length-1) {for( j <- 1 until nMat(0).length-1) {for( k <- 1 until nMat(0)(0).length-1) {
			if(nMat(i)(j)(k).soil>0){
				var nearCellX:Int = 0
				var nearCellY:Int = 0
				var nearCellZ:Int = 0
				
				if(nMat(i-1)(j)(k).soil>0 && nMat(i+1)(j)(k).soil>0){
					nearCellX = 2
				}else{
					if(nMat(i-1)(j)(k).soil>0){nearCellX-=1}
					if(nMat(i+1)(j)(k).soil>0){nearCellX+=1}
				}
				
				if(nMat(i)(j-1)(k).soil>0 && nMat(i)(j+1)(k).soil>0){
					nearCellY = 2
				}else{
					if(nMat(i)(j-1)(k).soil>0){nearCellY-=1}
					if(nMat(i)(j+1)(k).soil>0){nearCellY+=1}
				}
				
				if(nMat(i)(j)(k-1).soil>0 && nMat(i)(j)(k+1).soil>0){
					nearCellZ = 2
				}else{
					if(nMat(i)(j)(k-1).soil>0){nearCellZ-=1}
					if(nMat(i)(j)(k+1).soil>0){nearCellZ+=1}
				}
				
				ps.pushMatrix()
					ps.translate(i.toFloat, j.toFloat, k.toFloat)
					nMat(i)(j)(k).Draw(nearCellX,nearCellY,nearCellZ)
				ps.popMatrix()
			}
			
		}}}
	}
	
	def DrawGrid = {
		ps.strokeWeight(1)
		
		ps.stroke(50)
		var scale = 10
		var ticks = 10
		ps.stroke(0,0,0,30)
		for(i <- -ticks to ticks){
			ps.line(
				i.toFloat/ticks.toFloat*scale.toFloat,0,-scale.toFloat,
				i.toFloat/ticks.toFloat*scale.toFloat, 0,scale.toFloat
			)
			ps.line(
				-scale.toFloat,0,i.toFloat/ticks.toFloat*scale.toFloat,
				scale.toFloat,0,i.toFloat/ticks.toFloat*scale.toFloat
			)
		}
		ps.strokeWeight(4)	  
		ps.stroke(0, 100, 100)
		ps.line(0,0,0,scale,0,0)
		
		ps.stroke(100/3, 100, 100)
		ps.line(0,0,0,0,scale,0)
		
		ps.stroke(100/3*2, 100, 100)
		ps.line(0,0,0,0,0,scale)
	}
}