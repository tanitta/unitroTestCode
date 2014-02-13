package trit.unitro2d
import processing.core._
import trit.unitro2d._

class Cell(){
	var soil:Double = 0.0;
	var water:Double = 0.0;
	var temp:Double = 0.0;
	var air:Double = 0.0;
	var nutP:Double = 0.0;
	var nutN:Double = 0.0;
	var brightness:Double = 0.0;
	var plant = new plants.BasePlant(0,0);
	var item =new items.BaseItem(0,0);
}