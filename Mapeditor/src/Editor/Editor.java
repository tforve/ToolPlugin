package Editor;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class Editor   
{
	private GridPane root;
	
	private static int TILE_SIZE = 40;
	private static int W = 800;
	private static int H = 600;
	
	private static int X_TILES = W / TILE_SIZE;
	private static int Y_TILES = H / TILE_SIZE;
	
	private Tile[][] grid = new Tile[X_TILES][Y_TILES];
	
	private Image image= new Image("Editor/Tiles/placeholder.gif");
	private ImageView iv = new ImageView();
	
	
	public Editor()
	{
			
	}

	public Pane init()
	{
		root = new GridPane();		
		root.setPrefSize(W, H);		
		
		for(int y = 0; y < Y_TILES; y++ )
		{
			for(int x = 0; x < X_TILES; x++)
			{
				Tile tile = new Tile(x,y, image);
				grid[x][y] = tile;
				root.getChildren().add(tile);
				//iv.setImage(image);
;			}
		}
		
		return root;
	}
	
	
	private class Tile extends StackPane
	{
		private int x, y;
		
		
		public Tile(int x, int y, Image img)
		{
			this.x = x;
			this.y = y;
			
			
		//	getChildren().add(image);
			setTranslateX(x*TILE_SIZE);
			setTranslateY(y*TILE_SIZE);
			
		}
		
		
	}
	
}