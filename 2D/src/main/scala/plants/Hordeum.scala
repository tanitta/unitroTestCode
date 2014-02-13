package trit.unitro2d.plants
import processing.core._

class Hordeum(x:Int, y:Int) extends BasePlant(x,y) {
	objectName = "Hordeum"
	nutPMax = 1000
	var aaaa = 0
	override def setup(){}
	override def update(){}
	override def draw(ps: PApplet){
		ps.stroke(30,100,70)
		ps.line(0,0,0,-10)
	}
}

