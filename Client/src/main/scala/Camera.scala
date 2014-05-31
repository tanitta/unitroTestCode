package unitroClient
import unitroClient._
import processing.core._


class Camera(var ps: processing.core.PApplet){
	var fov = 0.5f
	
	var rotate = -1.0
	var rotatex = -math.Pi/6
	
	var ax = 0.0f
	var ay = 0.0f
	var az = 0.0f
	
	var bx = 0.0f
	var by = 0.0f
	var bz = 0.0f

	def Setup = {
			
	}
	
	def Update = {
		rotate += (ps.pmouseX-ps.mouseX).toDouble*0.01
		rotatex += (ps.pmouseY-ps.mouseY).toDouble*0.005
 		var x:Double = 20.0*math.cos(rotate)*math.cos(rotatex)
 		var z:Double = 20.0*math.sin(rotate)*math.cos(rotatex)
 		var y:Double = 20.0*math.sin(rotatex)
		ps.camera( 
			x.toFloat , y.toFloat, z.toFloat, // 視点X, 視点Y, 視点Z
			0, 0, 0, // 中心点X, 中心点Y, 中心点Z
			0.0f, -1.0f, 0.0f // 天地X, 天地Y, 天地Z
		)
 		ps.perspective(fov, Env.ScreenSizeX.toFloat/Env.ScreenSizeY.toFloat, 0.01f, 400.00f)			
	}	
}