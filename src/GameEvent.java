import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Vector;

import javax.swing.JPanel;

public class GameEvent extends JPanel{
	
	private int second;
	private int x;
	private int y;
	private int targetX;
	private int targetY;
	private GameEvent next;
	private double angle;
	private static Vector<GameEvent> list = new Vector<GameEvent>();
	public static GameEvent currentEvent;
	
	public GameEvent(){
		this.x = 20;this.y =  50;
		this.targetX = Clock.shooter[0][0];
		this.targetY = Clock.shooter[1][0];
		this.angle = Math.tanh((this.y-this.targetY)/(this.x-targetX));
		
	}
	
	@Override
	   public Dimension getPreferredSize() {
	      return new Dimension(800,800);
	   }
	
	public GameEvent(int second,int x,int y,int targetX,int targetY){
		
		this.second = second;
		this.x = 20+x;
		this.y =  y;
		this.targetX = -targetX;
		this.targetY =  targetY;
		
		this.angle = Math.tanh((this.y-this.targetY)/(this.x-targetX));
	}
	
	public void moveToTarget(){
		
		double tempDis = distance()-(5*distance()/100);
		this.x= (int)(tempDis * Math.cos(angle));
		this.y = (int)(tempDis * Math.sin(angle));
	}
	double m=-101;
	public void setAll(int second,int targetX,int targetY){
		this.second = second;
		this.targetX = 20+targetX;
		this.targetY =  targetY;
		
		
//		repaint();
		
	
	}
	
	
	public int getSecond() {
		return second;
	}



	public void setSecond(int second) {
		this.second = second;
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



	public GameEvent getNext() {
		return next;
	}



	public void setNext(GameEvent next) {
		
		this.next = next;
	}
	
	public boolean isInRange(){
		return (distance()<=(double)100);
	}
	



//	@Override
//	protected void paintComponent(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paintComponent(g);
//		Graphics2D g2d = (Graphics2D)g;
//		g2d.setColor(Color.RED);
//		g2d.drawOval(targetX, targetY, 5, 5);
//		
////		Graphics2D g2dPLAYER = (Graphics2D)g;
//		
//		g2d.setColor(Color.BLUE);
//		g2d.drawOval(x, y, 5, 10);
//		
//	}

	Ellipse2D.Double targetImage;
	Rectangle2D.Double shooterImage;
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		Graphics2D g2d = (Graphics2D)g;
		
		shooterImage = new Rectangle2D.Double(x,y,10,20);
		targetImage = new Ellipse2D.Double(targetX,targetY,15,15);
		
		g2d.setColor(Color.RED);
		g2d.fill(targetImage);
		g2d.setColor(Color.BLUE);
		g2d.fill(shooterImage);
		g2d.dispose();
		
		
		
		
	}




	public double distance(){
		
		return Math.pow((Math.pow((x-targetX),2)+Math.pow(y-targetY, 2)), 0.5);
		
	}

}
