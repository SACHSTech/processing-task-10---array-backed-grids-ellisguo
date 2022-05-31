import processing.core.PApplet;

public class Sketch extends PApplet {
  
  int CELL_WIDTH=20;
  int CELL_HEIGHT=20;
  int MARGIN=5;
  
  int ROW_COUNT=10;
  int COLUMN_COUNT=10;
  
  int SCREEN_WIDTH=CELL_WIDTH * COLUMN_COUNT + (COLUMN_COUNT+1) * MARGIN;
  int SCREEN_HEIGHT=CELL_HEIGHT * ROW_COUNT + (ROW_COUNT+1) * MARGIN;
  
  int[][] intGrid = new int[ROW_COUNT][COLUMN_COUNT];

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
    // put your size call here
    size(SCREEN_WIDTH, SCREEN_HEIGHT);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(0,0,0);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
    // x, y, w, h
    
    for (int row = 0; row < ROW_COUNT; row++)
    {
      for (int column = 0; column < COLUMN_COUNT; column++ ) 
      {
        fill(255,255,255);
        if (intGrid[row][column] == 1)
        {
          fill(0,255,0);
        }
        rect(MARGIN*(column+1) + CELL_WIDTH*column, MARGIN*(row+1) + CELL_HEIGHT*row, CELL_WIDTH, CELL_HEIGHT);
      }
    }

    
  }

  public void mousePressed(){
    int x = mouseX;
    int y = mouseY;
    int grid_row = y / (CELL_HEIGHT + MARGIN);
    int grid_column = x / (CELL_WIDTH + MARGIN);
    //System.out.println("mouse coordinates:\t(" + x + "," + y + ");\t grid coordinates:\t(row:" + grid_row + ", column: " + grid_column + ")");

  

  // toggle on cell which was clicked

  int click_value = 1;

  if (intGrid[grid_row][grid_column] == 1)

  {

   click_value = 0;

  }

 

  intGrid[grid_row][grid_column] = click_value;

 

  // turn on bordering cells but make sure if you are at the edge, you don't crash

  if (grid_row > 0)

  {

    intGrid[grid_row-1][grid_column] = click_value;

  }

 

  if (grid_column > 0)

  {

    intGrid[grid_row][grid_column-1] = click_value;

  }

 

  if (grid_row+1 < ROW_COUNT)

  {

    intGrid[grid_row+1][grid_column] = click_value;

  }

 

  if (grid_column+1 < COLUMN_COUNT)

  {

    intGrid[grid_row][grid_column+1] = click_value;

  }

 

  int total_selected = 0;

  for (int row = 0; row < ROW_COUNT; row++)

  {

    for (int column = 0; column < COLUMN_COUNT; column++ )

    {

      total_selected += intGrid[row][column];     

    }

  }

  System.out.println("Total of " + total_selected + " cells are selected.");

 

  for (int row = 0; row < ROW_COUNT; row++)

  {

    int total_on_row_selected = 0;

    for (int column = 0; column < COLUMN_COUNT; column++ )

    {

      total_on_row_selected += intGrid[row][column];     

    }

    System.out.println("Row " + row + " has " + total_on_row_selected + " cells selected.");
    
  }

  

}

 



    
  
}