package unitroClient
import unitroClient._


object Solver{
	type uniMatrix = Array[Array[Array[unitroClient.data.Cell]]]
	var cMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	var nMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	def SetMatrix(cMat: uniMatrix, nMat: uniMatrix) = {
		this.cMat = cMat
		this.nMat = nMat
	}
	
	def Setup = {
		println(nMat)
		nMat(1)(1)(1).soil = 0.2
		nMat(2)(1)(1).soil = 0.3
		nMat(3)(1)(1).soil = 0.5
		
		nMat(2)(1)(2).soil = 0.4
		nMat(3)(1)(2).soil = 0.2
		nMat(3)(2)(2).plant = new data.plants.Butterbur(nMat(3)(2)(2))
		
		nMat(2)(1)(3).soil = 0.6
		nMat(2)(2)(3).soil = 0.5
		
		nMat(1)(1)(2).soil = 0.2
		
	}
	
	def Update = {
		cMat = nMat
		for(i <- 1 until cMat.length-1) {for( j <- 1 until cMat(0).length-1) {for( k <- 1 until cMat(0)(0).length-1) {
			nMat(i)(j)(k).Update
		}}}
	}
}