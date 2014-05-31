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
	}
	
	def Update = {
		cMat = nMat
		for(i <- 1 until cMat.length-1) {for( j <- 1 until cMat(0).length-1) {for( k <- 1 until cMat(0)(0).length-1) {
			nMat(i)(j)(k).Update
		}}}
	}
}