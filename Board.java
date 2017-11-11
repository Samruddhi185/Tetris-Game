import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel {
	
	private BufferedImage blocks;	
    
	private final int blockSize = 30;
	
	private final int boardWidth = 10, boardHeight = 20;
	
	private int[][] board = new int[boardHeight][boardWidth];
	private Shape[] shapes = new Shape[7];

   private Shape currentShape;

	public Board(){
		
		try {
			blocks = ImageIO.read(Board.class.getResource("/tiles.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// shapes
		
				shapes[0] = new Shape(blocks.getSubimage(0, 0, blockSize, blockSize), new int[][]{
					{1, 1, 1, 1} // IShape
				}, this, 1);
				
				shapes[1] = new Shape(blocks.getSubimage(blockSize, 0, blockSize, blockSize), new int[][]{
					{1, 1, 0},
					{0, 1, 1}   // ZShape
				}, this, 2);
				
				shapes[2] = new Shape(blocks.getSubimage(blockSize*2, 0, blockSize, blockSize), new int[][]{
					{0, 1, 1},
					{1, 1, 0}   // S-Shape
				}, this, 3);
				
				shapes[3] = new Shape(blocks.getSubimage(blockSize*3, 0, blockSize, blockSize), new int[][]{
					{1, 1, 1},
					{0, 0, 1}   // J-Shape
				}, this, 4);
				
				shapes[4] = new Shape(blocks.getSubimage(blockSize*4, 0, blockSize, blockSize), new int[][]{
					{1, 1, 1},
					{1, 0, 0}   // L-Shape
				}, this, 5);
				
				shapes[5] = new Shape(blocks.getSubimage(blockSize*5, 0, blockSize, blockSize), new int[][]{
					{1, 1, 1},
					{0, 1, 0}   // T-Shape
				}, this, 6);
				
				shapes[6] = new Shape(blocks.getSubimage(blockSize*6, 0, blockSize, blockSize), new int[][]{
					{1, 1},
					{1, 1}   // O-Shape
				}, this, 7);
				
				currentShape = shapes[0];

}
	public void paintComponent(Graphics g){
		super.paintComponent(g); 
		currentShape.render(g);
		for(int i = 0; i < boardHeight; i++){
			g.drawLine(0, i*blockSize, boardWidth*blockSize, i*blockSize);
		}
		for(int j = 0; j < boardWidth; j++){
			g.drawLine(j*blockSize, 0, j*blockSize, boardHeight*blockSize);
		}
	}
	public int getBlockSize(){
		return blockSize;
	}
}