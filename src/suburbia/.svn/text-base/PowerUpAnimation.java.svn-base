package suburbia;

public class PowerUpAnimation extends SpecialEffects{

	static String name = "images/misc/caterpillarHeadS.png";
	boolean powerUpSelected = false;
	public PowerUpAnimation() {
		/*Constructor parameters
		 * super(int Width,int Height,int Xloc,int Yloc,String name,int #images,int #subImages,int drawsizeX, int drawsizeY)
		 */
		super(72, 72, 1300, 20, name, 1, 1, 72, 72);
		// TODO Auto-generated constructor stub
	}
	
	boolean isPowerIconPress(int x,int y){	
			
			double mainRadious = 36;//half of the width of image draw size ==> 72/2 =36
			double deltaX = Math.abs(x-1336);//(1336,56) are the center coordinates of the circle
			double deltaY = Math.abs(y-56);//because the radius is 36, so 1300+36 =1336
			double radious = Math.sqrt(deltaX*deltaX+deltaY*deltaY);
			if (radious<mainRadious){
				powerUpSelected = true;
				return powerUpSelected;
			}else return powerUpSelected;
		}
}
