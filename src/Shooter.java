import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;


public class Shooter extends JPanel{
	
	private int x;
	private int y;
	private int targetX,targetY;
	Rectangle2D.Double rectangle;
	double angle;
	public Shooter() {
		// TODO Auto-generated constructor stub
		x=50+0;
		y=200-50;
		targetX=Clock.shooter[0][0];
		targetY = Clock.shooter[1][0];
		angle = Math.tanh((this.y-this.targetY)/(this.x-targetX));
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

	public void moveToTarget(){
		Graphics2D g = (Graphics2D)getGraphics();
		g.dispose();
		
		double tempDis = distance()-(5*distance()/100);
		this.x= 50+(int)(tempDis * Math.cos(angle));
		this.y = 200- (int)(tempDis * Math.sin(angle));
		setBounds(x, y, 20, 20);
	}
	
	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(20,20);
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		setForeground(Color.BLUE);
		g.setColor(Color.BLUE);
		g.fillRect(0,0, 20, 20);
		g.dispose();
	}
	public double distance(){
		targetX = Clock.shooter[0][Clock.nSeconds];
		targetY = 300-Clock.shooter[1][Clock.nSeconds];
		return Math.pow((Math.pow((x-targetX),2)+Math.pow(y-targetY, 2)), 0.5);
	}
	
	
	
	

}
