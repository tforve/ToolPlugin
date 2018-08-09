package Editor;

import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

public class View 
{	
	private GridPane root;
	private GridPane grid;
	private VBox rightBox, tileBox;

	// Menuebar
	private MenuBar menuBar;
	private Menu file;
	private MenuItem save, exit;
	//SideMenue
	private Label menuTitle;
	
	//Grid
	private Image gridTile0;
	//Grid Scaling
	private int gridX = 30; // width of grid 
	private int gridY = 20; // height of grid
	//Grid Cells
	public int gridCells[][] = new int[gridX][gridY];
	
	public View() {
	}

	public Pane initView() {
		/* Initialize */
		// Panes
		root = new GridPane();
		root.setHgap(15.0);
		grid = new GridPane();
		rightBox = new VBox(25.0);
		tileBox = new VBox(5.0);
		
		/* MenueBar top */
		menuBar = new MenuBar();
		file = new Menu("File");		
		save = new MenuItem("Save");
		save.setOnAction(e->saveMap()); // add Method
		
		exit = new MenuItem("Exit");
		exit.setOnAction(e->System.exit(0));
		
		file.getItems().addAll(save, exit);
		menuBar.getMenus().add(file);
		
		/* Menu on the right*/		
		menuTitle = new Label("Tilemenue to draw with         ");
		rightBox.getChildren().add(menuTitle);
		rightBox.getChildren().add(tileBox);
		
		// Tile Buttons to draw later
		for (int i = 0; i < 16; i++) 
		{
			Image tile = new Image("Editor/Tiles/Walkway/"+i+".gif");
			ImageView  ivMenue = new ImageView();
			ivMenue.setImage(tile);
			tileBox.getChildren().add(ivMenue);
		}
		
		fillGrid();
	
		/* Sort everything */
		root.add(menuBar, 0, 0);
		root.add(grid, 0, 1);
		root.add(rightBox, 1, 1);

		return root;
	}

	private Object saveMap() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void fillGrid()
	{
		/* Grid to the Left */
		// Images
		gridTile0 = new Image("Editor/Tiles/placeholder.gif");
		int cellNumber = 0;
	
		for (int y = 0; y < gridY; y++) //row
		{
		
			for (int x =0; x < gridX; x++) //column
			{
//				Label tmp = new Label(""+cellNumber);
				ImageView iv = new ImageView();
				iv.setImage(gridTile0);
				grid.add(iv,x,y);
				
				gridCells[x][y] = cellNumber++;
			}
		}		

	}

}
