package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JPanel;

import presenter.Grid;

public class Grid_Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -752805863228701235L;
	private Grid[][] grid;
	private boolean enableMouse = false;

	public Grid_Panel(int gridX, int gridY) {
		
		grid = new Grid[gridX][gridY];
		
		setLayout(new GridLayout(gridX,gridY));
		
		for(int X = 0; X < grid.length; X++)
			for(int Y = 0; Y < grid[0].length; Y++){
				grid[X][Y] = new Grid(X,Y);
			}
		
		setBackground (new Color(0,15,15));
		setPreferredSize(new Dimension(90 * gridY, 130 * gridX));
		update();
	}

	public Grid_Panel(int gridX, int gridY, boolean enabeled){
	
		enableMouse = enabeled;
		grid = new Grid[gridX][gridY];
		
		setLayout(new GridLayout(gridX,gridY));
		
		for(int X = 0; X < grid.length; X++)
			for(int Y = 0; Y < grid[0].length; Y++){
				grid[X][Y] = new Grid(X,Y);
			}
		
		setBackground (new Color(0,15,15));
		setPreferredSize(new Dimension(90 * gridY, 130 * gridX));
		update();
	}
	
	public void update(){
		removeAll();
		
		for(int X = 0; X < grid.length; X++)
			for(int Y = 0; Y < grid[0].length; Y++){
				add(new CLabel(grid[X][Y].getIcon(),X,Y,this,enableMouse));
			}
		
	}

	public Grid[][] getGrid() {
		return grid;
	}

	public void setGrid(Grid[][] grid) {
		this.grid = grid;
	}
	
}
