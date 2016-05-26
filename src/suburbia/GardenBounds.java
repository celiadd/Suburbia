package suburbia;

public class GardenBounds {

	private int GARDEN_WIDTH;
	private int GARDEN_HEIGHT;
	private double FENCE_OFFSET = .32;
	private double BOTTOM_OFFSET=.82;
	private int TOP_BOUND;
	private int BOTTOM_BOUND;
	private int LEFT_BOUND;
	private int RIGHT_BOUND;
	public GardenBounds(int Width,int Height){
		GARDEN_WIDTH = Width;
		GARDEN_HEIGHT = Height-(int)(Height*FENCE_OFFSET);
		TOP_BOUND = Height - GARDEN_HEIGHT;
		BOTTOM_BOUND = (int)(Height*BOTTOM_OFFSET);
		LEFT_BOUND=0;
		RIGHT_BOUND=Width;
	}
	//-----------getters-------------
	int getGardenWidth(){
		return this.GARDEN_WIDTH;
	}
	int getGardenHeight(){
		return this.GARDEN_HEIGHT;
	}
	int getTopBound(){
		return this.TOP_BOUND;
	}
	int getBottomBound(){
		return this.BOTTOM_BOUND;
	}
	int getLeftBound(){
		return this.LEFT_BOUND;
	}
	int getRightBound(){
		return this.RIGHT_BOUND;
	}
}
