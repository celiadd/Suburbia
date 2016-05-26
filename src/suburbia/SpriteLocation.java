package suburbia;



import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SpriteLocation implements Comparable<SpriteLocation>{
	
	private Point location = new Point();
	private Sprite sprite;
	private int PicSelecter = 0;
	private int numSubImages = 0;
	private int frameCount = 1;
	
	public SpriteLocation(int x, int y, Sprite sprite){
		location.setLocation(x,y);
		this.sprite = sprite;
	}
	
    int getNextPic(){
    	return PicSelecter;
    }
    void setNextPicture(){
    	PicSelecter = (PicSelecter + 1) % frameCount;
    }
	
	@Override
	public String toString(){
		return sprite.getName() + location;
	}
	
	public int getX(){return location.x;}
	public int getY(){return location.y;}
	public Point getLocation(){return location;}
	public Sprite getSprite(){return sprite;}
	public void setSprite(Sprite sprite){this.sprite = sprite;}

	@Override
	public int hashCode() {return location.hashCode();} 
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpriteLocation other = (SpriteLocation) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
		@Override
	public int compareTo(SpriteLocation other) {
			if((location.y+sprite.getImgHeight()) - (other.location.y+other.sprite.getImgHeight())!=0)
				return (location.y+sprite.getImgHeight())-(other.location.y+other.sprite.getImgHeight());
			else{return location.x - other.location.x;}
	}

}
