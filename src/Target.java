

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Target extends JPanel{
	
	private int targetX,targetY;
	private int x,y;
	private Ellipse2D.Double target;
	double angle;
	
	
	public Target(){
		int [] xy = Clock.getXY();
		x=xy[0];y=xy[1];				
		targetX = 50+Clock.shooter[0][0];
		targetY = 200-Clock.shooter[1][0];
		angle =  Math.tanh((this.y-this.targetY)/(this.x-targetX));
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


	public Ellipse2D.Double getTarget() {
		return target;
	}


	public void setTarget(Ellipse2D.Double target) {
		this.target = target;
	}


	public double getAngle() {
		return angle;
	}

	

	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(30,30);
	}


	public void setAngle(double angle) {
		this.angle = angle;
	}
	public void setNextPos(){
		Graphics2D g = (Graphics2D)getGraphics();
		this.targetX = 50+Clock.shooter[0][Clock.nSeconds];
		this.targetY = 200-Clock.shooter[1][Clock.nSeconds];
		setBounds(targetX,targetY,30,30);
	}


	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.RED);
		g.fillOval(0,0, 30, 30);
		g.dispose();
	}
	

}
