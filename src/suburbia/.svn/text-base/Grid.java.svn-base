package suburbia;

public class Grid {
	
	private final int GRID_WIDTH = 5;  //magic numbers 
	private final int GRID_HEIGHT = 4;	//for dimensions
	private int cell_Width;
	private int cell_Height;
	private int stretchFactor;			//this is the slope of the squares
	private int off_screen_offset;		//this offset helps stretch the grid to the width of the screen
	private int DIVIDER = 5;			//use to set the size of the squares
	private int x_pos;
	private int y_pos;
	private int index_Y,index_X;
	private Cell [][] GridBoard = new Cell[GRID_WIDTH][GRID_HEIGHT];

	//the constructor takes in the  dimensions of the screen being used. 
	public Grid(int max_width, int max_height){
		
	cell_Height = max_height/DIVIDER;
	cell_Width = cell_Height+cell_Height+cell_Height/2;			//Make cells squares
	stretchFactor = 0;
	off_screen_offset = stretchFactor*(GRID_HEIGHT+2);
	//THIS CENTERS THE GRID
	x_pos = -(cell_Width);//(max_width - cell_Width*GRID_WIDTH)/2;
	y_pos = (max_height - cell_Height*GRID_HEIGHT)/2;
		
	for (int i = 0 ;i < GRID_HEIGHT; i++){
		for(int j = 0; j < GRID_WIDTH; j++){
			
			x_pos = x_pos + cell_Width;
			
			//System.out.println("x ="+x_pos+"   y= "+ y_pos);
			GridBoard [j][i] = new Cell(x_pos, y_pos);
			
		}
		//reset x and increase y
		//x_pos = (max_width - cell_Width*GRID_WIDTH)/2+stretchFactor*(i+1);
		x_pos = -(cell_Width);
		y_pos = y_pos + cell_Height;
	}
	
	}
//location methods to place objects in the right square
	
	Cell CalculateCellLocation(int X, int Y){
		int Yindex;
		int Xindex;
		
		Yindex = Y_location_algorithm(Y);
		Xindex = X_location_algorithm(X,Yindex,Y);
		
		return GridBoard[Xindex][Yindex];
	}
	
	int Y_location_algorithm(int random_Y){
		int index = 0;
		while((random_Y - GridBoard [0][index].getYcoor())> cell_Height){
			index++;
		}
		return index;
	}
	/**
	 * This method is the algorithm to find the correct X index value for the cell in which a 
	 * player has placed something.
	 * it is based on the equation y=m*x+b, but because of the offset of every cell it turns
	 * into y = m*(Xf-Xi)+b and then rearranged to Xf = (y-b)/m +Xi
	 * Xf is the X coordinate of the right sloped line of every cell as a function of y
	 * Xi is the initial X coordinate (top left corner of cell)   
	 * 
	 * @param random_X = some random value of X 
	 * @param index_Y = index obtained from the method Y_location_algorithm
	 * @param random_Y =msome random value of Y
	 * @return the index of the cell selected on a mouse click
	 */
	int X_location_algorithm(int random_X,int index_Y,int random_Y){
		//boolean this_is_it = false;
		int index = 0;
		double slope = cell_Height/stretchFactor;
		int b;
		int Xi;
		
		for(int i = 0;i < GRID_WIDTH;i++){
			if (i==GRID_WIDTH-1){
				if((random_X - GridBoard[i][index_Y].getXcoor()) < (cell_Width + stretchFactor)){
					return index;
				}
			}
			else if((random_X - GridBoard[i][index_Y].getXcoor()) < (cell_Width + stretchFactor)){
				b = GridBoard[i+1][index_Y].getYcoor();
				Xi = GridBoard[i+1][index_Y].getXcoor();
				if (random_X < (double)((random_Y - b)/slope)+Xi){
					return index;
				}
			}
		}
		return index;
	}
	
//BELOW THIS LINE ARE A BUNCH OF USEFUL GETTERS	
//********************************************************	
	Cell getGridIndex(int xIndex,int yIndex){
		return GridBoard[xIndex][yIndex];
	}
	

	int getGridX_Origin(){
		return GridBoard[0][0].getXcoor();
	}
	
	int getGridY_Origin(){
		return GridBoard[0][0].getYcoor();
	}
	int getGridX_limit(){
		return GridBoard[GRID_WIDTH-1][GRID_HEIGHT-1].getXcoor();
	}
	int getGridY_limit(){
		return GridBoard[GRID_WIDTH-1][GRID_HEIGHT-1].getYcoor();
	}
	int getGrid_Ysize(){
		return GRID_HEIGHT;
	}
	int getGrid_Xsize(){
		return GRID_WIDTH;
	}
	
	int getStretchFactor(){
		return stretchFactor;
	}
	
	int getSingleCellSize(){
		return cell_Height;
	}
}
