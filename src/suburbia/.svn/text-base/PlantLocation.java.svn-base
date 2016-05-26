package suburbia;



import java.awt.Point;

public class PlantLocation implements Comparable<PlantLocation>{
	
	private Point location = new Point();
	private Plant plant;
	private int PicSelecter = 0;
	private int numSubImages = 0;
	private int frameCount = 1;
	private int ticksSincePlanted = 0;
	private boolean spawn = true;
	private int spawnDirection = 0;
	
	public PlantLocation(){}
	
	public PlantLocation(int x, int y, Plant plant){
		location.setLocation(x,y);
		this.plant = plant;
	}
	
    int getNextPic(){
    	return PicSelecter;
    }
    void setNextPicture(){
    	PicSelecter = (PicSelecter + 1) % frameCount;
    }
	
   
    public void incrementTicksSincePlanted(){ticksSincePlanted++;}
    public int getTicksSincePlanted(){return ticksSincePlanted;}
    public void resetTicksSincePlanted(){ticksSincePlanted=0;}
    public void setSpawn(){
    	if(spawn){
    		spawn = false;
    	}else{
    		spawn = true;
    	}
    }
    public boolean getSpawn(){return spawn;}
    public int getSpawnDirection(){return spawnDirection;}
    public void incrementSpawnDirection(){spawnDirection = spawnDirection++%4;}
	
	@Override
	public String toString(){
		return "Plant " + plant.getName() + " at " + location + " ticksSincePlanted " + ticksSincePlanted + "spawn " + spawn;
	}
	
	public int getX(){return location.x;}
	public int getY(){return location.y;}
	public Point getLocation(){return location;}
	public Plant getPlant(){return plant;}
	public void setPlant(Plant plant){this.plant = plant;}

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
		PlantLocation other = (PlantLocation) obj;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}
	
		@Override
	public int compareTo(PlantLocation other) {
			if((location.y+plant.getImgHeight()) - (other.location.y+other.plant.getImgHeight())!=0)
				return (location.y+plant.getImgHeight())-(other.location.y+other.plant.getImgHeight());
			else{return location.x - other.location.x;}
	}

}
