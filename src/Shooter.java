import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class Shooter extends JPanel{
	
	private int x;
	private int y;
	private int targetX,targetY;
	Rectangle2D.Double rectangle;
	double angle;

	public Shooter(int x,int y){
		this.x = x;this.y = 0;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getTargetX() {
		return targetX;
	}

	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}

	public int getTargetY() {
		return targetY;
	}

	public void setTargetY(int targetY) {
		this.targetY = targetY;
	}

	public Rectangle2D.Double getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle2D.Double rectangle) {
		this.rectangle = rectangle;
	}

	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(20,20);
	}
	Ellipse2D.Double shooterImg;
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setColor(Color.BLUE);
		
		shooterImg = new Ellipse2D.Double(0,0, 20, 20);
		
		g2d.fill(shooterImg);
		setBackground(null);
		setOpaque(false);
		g2d.dispose();
		
	};
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintComponent(g);
//		setForeground(Color.BLUE);
//		g.setColor(Color.BLUE);
//		g.fillRect(0,0, 20, 20);
//		g.dispose();
//	}

	
	
	
	

}
