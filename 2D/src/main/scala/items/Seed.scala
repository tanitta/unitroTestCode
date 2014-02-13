package trit.unitro2d.items
import trit.unitro2d.items._
class Seed(x:Int, y:Int) extends BaseItem(x,y) {
	objectName = "Seed"
	var plantName = ""
	
	def SetPlantName(name:String){
		plantName = name
	}
}