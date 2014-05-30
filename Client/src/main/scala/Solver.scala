package unitroClient
import unitroClient._

object Solver{
	type uniMatrix = Array[Array[Array[unitroClient.data.Cell]]]
	var cMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	var nMat = new uniMatrix(Env.ZoneSizeX,Env.ZoneSizeY,Env.ZoneSizeZ)
	def SetMatrix(cMAt: uniMatrix, nMAt: uniMatrix) = {
		this.cMat = cMat
		this.nMat = nMat
	}
	
	def Setup = {
		
	}
	
	def Update = {
		
	}
}