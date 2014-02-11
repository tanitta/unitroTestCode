package trit.unitro2d
import trit.unitro2d._

object Zone{
	var currentMatrix = Array.ofDim[Cell](Env.sizCellX,Env.sizCellY)
	var nextMatrix = Array.ofDim[Cell](Env.sizCellX,Env.sizCellY)
	for( i <- 0 until Env.sizCellX) {
		for( j <- 0 until Env.sizCellY) {
			currentMatrix(i)(j) = new Cell()
			nextMatrix(i)(j) = new Cell()
		}	
	}
	
}