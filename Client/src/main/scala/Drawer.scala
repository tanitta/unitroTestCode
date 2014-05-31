package unitroClient
import processing.core._
import unitroClient._


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
		camera = new unitroClient.Camera(ps)
		ps.size(Env.ScreenSizeX,Env.ScreenSizeY,PConstants.OPENGL)
		ps.colorMode(PConstants.HSB, 100)
		ps.background(0,0,100)
		ps.smooth()
	}
	
	def Update = {
		camera.Update	
	}
	
	def Draw = {
		ps.background(0,0,100);
		DrawGrid
		DrawMatrix
	}
	
	def DrawMatrix = {
		for(i <- 1 until nMat.length-1) {for( j <- 1 until nMat(0).length-1) {for( k <- 1 until nMat(0)(0).length-1) {
			
		}}}
	}
	
	def DrawGrid = {
		ps.strokeWeight(1)
		
		ps.stroke(50)
		// ps.box(1);
		var size = 10
		ps.stroke(0,0,100,30)
		for(i <- -size to size){
			ps.line(i.toFloat/size.toFloat,0,-size.toFloat/size.toFloat,i.toFloat/size.toFloat, 0,size.toFloat/size.toFloat)
			ps.line(-size.toFloat/size.toFloat,0,i.toFloat/size.toFloat, size.toFloat/size.toFloat,0,i.toFloat/size.toFloat)
		}
		ps.strokeWeight(4)	  
		ps.stroke(0, 100, 100)
		ps.line(0,0,0,1,0,0)
		
		ps.stroke(100/3, 100, 100)
		ps.line(0,0,0,0,1,0)
		
		ps.stroke(100/3*2, 100, 100)
		ps.line(0,0,0,0,0,1)
	}
}