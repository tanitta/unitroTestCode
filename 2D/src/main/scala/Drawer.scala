package trit.unitro2d
import trit.unitro2d._
import processing.core._
class Drawer(var ps: PApplet){
	def setup(){
		ps.size(Env.sizScreenX, Env.sizScreenY,PConstants.P2D)
		ps.smooth()
		ps.colorMode(PConstants.HSB, 100);
	}
	
	def DrawPlant(x: Int, y:Int) = {
		Zone.nextMatrix(x)(y).plant.draw(ps);
	}
	
	def DrawCell(x: Int, y:Int) = {
		//Zone.nextMatrix(x)(y)
		if(Zone.nextMatrix(x)(y).soil > 0.0){
			var countX = 0
			var countY = 0
			
			var sizeX = 1.0
			var sizeY = 1.0
			
			var posX = 0.0
			var posY = 0.0
			
			
			if(Zone.nextMatrix(x)(y).soil < 1.0){
				
				
				if(Zone.nextMatrix(x-1)(y).soil > 0.0){
					countX+=1
					posX -=1
				};
				if(Zone.nextMatrix(x+1)(y).soil > 0.0){
					countX+=1
					posX +=1
				};
				
				if(Zone.nextMatrix(x)(y-1).soil > 0.0){
					countY+=1
					posY-=1
				};
				if(Zone.nextMatrix(x)(y+1).soil > 0.0){
					countY+=1
					posY+=1
				};
				
				//ひとつ
				if((countX==1 && countY!=2)||(countX!=2 && countY==1)){
					sizeX = math.pow(Zone.nextMatrix(x)(y).soil,0.5)
					sizeY = math.pow(Zone.nextMatrix(x)(y).soil,0.5)
					
					// ps.rect((8.0f-sizeX.toFloat*8.0f)*posX.toFloat,-(8.0f-sizeY.toFloat*8.0f)*posY.toFloat,sizeX.toFloat*8.0f,sizeY.toFloat*8.0f,2f)
				}
				
				//長2つ
				if((countX==2 && countY<=1)||(countX<=1 && countY==2)){
					if(countX>countY){
						sizeX = 1.0
						sizeY = Zone.nextMatrix(x)(y).soil
						
					}else{
						sizeX = Zone.nextMatrix(x)(y).soil
						sizeY = 1.0
					}
					
					//ps.rect((8.0f-sizeX.toFloat*8.0f)*posX.toFloat,-(8.0f-sizeY.toFloat*8.0f)*posY.toFloat,sizeX.toFloat*8.0f,sizeY.toFloat*8.0f,2f)
					
					//ps.rect(0.0f,0.0f,sizeX.toFloat*8.0f,sizeY.toFloat*8.0f,2f)
					
				}
				
				if(countX==2 && countY==2){
					// ps.rect(0,0,8,8,2f)
					
				}
				
				
				
			}else{
				
				//ps.rect(0.0f,0.0f,8.0f,8.0f,2f)
			}
			
			ps.pushMatrix();
			ps.translate((8.0f-sizeX.toFloat*8.0f)*posX.toFloat,-(8.0f-sizeY.toFloat*8.0f)*posY.toFloat - sizeY.toFloat*8.0f);
			
				DrawPlant(x,y)
			ps.popMatrix();
			
			ps.stroke(10,100,50)
			ps.fill(10,100,70)
			ps.rect((8.0f-sizeX.toFloat*8.0f)*posX.toFloat,-(8.0f-sizeY.toFloat*8.0f)*posY.toFloat,sizeX.toFloat*8.0f,sizeY.toFloat*8.0f,2f)
			
			
			
		}
		
		
	}
	
	def draw(){
		ps.background(60,20,100)
		ps.rectMode(PConstants.RADIUS)
		for( i <- 0 until Env.sizCellX) {
			for( j <- 0 until Env.sizCellY) {
				ps.pushMatrix();
				ps.translate(i*16, Env.sizScreenY-j*16);
				DrawCell(i,j)	
						
				ps.popMatrix();
			}	
		}
	}
}