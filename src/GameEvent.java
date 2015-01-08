import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	Shooter shooter;
	Target target;
	
	public GameEvent(){
		setLayout(new FlowLayout(FlowLayout.LEFT));
		setOpaque(false);
//		setBackground(null);
		setBackground(Color.GREEN);
		this.x = 0;this.y =  50;
		this.targetX = Clock.shooter[0][0];
		this.targetY = Clock.shooter[1][0];
		this.angle = Math.tanh((double)(getY()-this.getTargetY())/(double)(getX()-getTargetX()));
//		targetImage=new Ellipse2D.Double(getTargetX(),getTargetY(),40,20);
//		shooterImage=new Rectangle2D.Double(getX(),getY(),20,40);
		
//		setBounds(0,0,100,500);
		
		
		shooter = new Shooter(getX(),getY());
		target = new Target(getTargetX(),getTargetY());
//		shooter.setBounds(0,50,30,30);
//		target.setBounds(getTargetX(), getTargetY(),40,20);
		add(shooter);
//		add(target);
		
	}
	
	@Override
	   public Dimension getPreferredSize() {
	      return new Dimension(1000,500);
	   }
	
	public GameEvent(int second,int x,int y,int targetX,int targetY){
		
		this.second = second;
		this.x = x;
		this.y =  y;
		this.targetX = targetX;
		this.targetY =  targetY;
		
		this.angle = Math.tanh((getY()-getTargetY())/(getX()-getTargetX()));
	}
	
	public void moveToTarget(){
		
		double tempDis = distance()-(distance()*(double)1/100);
		this.x= (int)(tempDis * Math.cos(angle));
		this.y = (int)(tempDis * Math.sin(angle));
//		repaint();
		
	}
	public void setTargetBounds(int x,int y,int w,int h){
//		target.setBounds(x,y,w,h);
	}
	public void setShooterBounds(int x,int y,int w,int h){
		shooter.setBounds(getX(),getY(),20,20);
	}
	
	double m=-101;
	public void setAll(int second,int targetX,int targetY){
		this.second = second;
		this.targetX = targetX;
		this.targetY =  targetY;
		
		System.out.println(Clock.nSeconds+"sec "+"Target Location"+getTargetX()+","+getTargetY());

//		repaint();
	
	}
	
	
	public int getSecond() {
		return second;
	}



	public void setSecond(int second) {
		this.second = second;
	}



	public int getX() {
		int tempX = 100+x;
		return tempX;
	}



	public void setX(int x) {
		this.x = x;
	}



	public int getY() {
		int tempY = 500-y;
		return tempY;
	}



	public void setY(int y) {
		this.y = y;
	}



	public int getTargetX() {
		int tempTargetX = 100+targetX;
		return tempTargetX;
	}



	public void setTargetX(int targetX) {
		this.targetX = targetX;
	}



	public int getTargetY() {
		int tempTargetY = 500-targetY;
		return tempTargetY;
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
	


	Ellipse2D.Double targetImage;
	Rectangle2D.Double shooterImage;

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
//		target.setBounds(getTargetX(), getTargetY(),target.getWidth(),target.getHeight());
		shooter.setBounds(getX(),getY(),shooter.getWidth(),shooter.getHeight());
		
		setOpaque(false);
		setBackground(null);
		g.dispose();
	}




	public double distance(){
		
		return Math.pow((Math.pow((getX()-getTargetX()),2)+Math.pow(getY()-getTargetY(), 2)), 0.5);
		
	}

}
