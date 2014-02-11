package trit.unitro2d
import trit.unitro2d._
class Sim(){
	def setup(){
		
	}
	
	def updateNut(x: Int, y:Int) = {
		if(Zone.currentMatrix(x)(y).soil > 0){
			var disP:Double = 0.0
			var disN:Double = 0.0
			var X:Int = 0
			var Y:Int = 0
			
			var cSpred = 0.01
			
			X = x-1
			Y = y
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutP > 0 && Zone.currentMatrix(x)(y).nutP > 0){
				disP += cSpred*(Zone.currentMatrix(X)(Y).nutP/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutP/Zone.currentMatrix(x)(y).soil)
			}
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutN > 0 && Zone.currentMatrix(x)(y).nutN > 0){
				disN += cSpred*(Zone.currentMatrix(X)(Y).nutN/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutN/Zone.currentMatrix(x)(y).soil)
			}
			
			
			X = x+1
			Y = y
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutP > 0 && Zone.currentMatrix(x)(y).nutP > 0){
				disP += cSpred*(Zone.currentMatrix(X)(Y).nutP/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutP/Zone.currentMatrix(x)(y).soil)
			}
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutN > 0 && Zone.currentMatrix(x)(y).nutN > 0){
				disN += cSpred*(Zone.currentMatrix(X)(Y).nutN/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutN/Zone.currentMatrix(x)(y).soil)
			}
			
			
			X = x
			Y = y-1
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutP > 0 && Zone.currentMatrix(x)(y).nutP > 0){
				disP += cSpred*(Zone.currentMatrix(X)(Y).nutP/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutP/Zone.currentMatrix(x)(y).soil)
			}
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutN > 0 && Zone.currentMatrix(x)(y).nutN > 0){
				disN += cSpred*(Zone.currentMatrix(X)(Y).nutN/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutN/Zone.currentMatrix(x)(y).soil)
			}
				
			
			X = x
			Y = y+1
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutP > 0 && Zone.currentMatrix(x)(y).nutP > 0){
				disP += cSpred*(Zone.currentMatrix(X)(Y).nutP/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutP/Zone.currentMatrix(x)(y).soil)
			}	
			if(Zone.currentMatrix(X)(Y).soil > 0 && Zone.currentMatrix(X)(Y).nutN > 0 && Zone.currentMatrix(x)(y).nutN > 0){
				disN += cSpred*(Zone.currentMatrix(X)(Y).nutN/Zone.currentMatrix(X)(Y).soil	- Zone.currentMatrix(x)(y).nutN/Zone.currentMatrix(x)(y).soil)
			}
			
			
			Zone.nextMatrix(x)(y).nutP += disP
			Zone.nextMatrix(x)(y).nutN += disN
		}
	}
	
	
	def update(){
		//値の更新
		Zone.nextMatrix.copyToArray(Zone.currentMatrix);
		for( i <- 0 until Env.sizCellX) {
			for( j <- 0 until Env.sizCellY) {
				updateNut(i,j)
			}
		}
		
	}
}