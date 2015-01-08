

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

public class Target {
	
	private int targetX,targetY;
	 Ellipse2D.Double targetObj;
	Target following;
	double speed=10;
	double x=0;
	double y=0;
	boolean xLess=false;boolean yLess=false;
	double angle;
	
	public Target(double x,double y){
		this.x = x;
		this.y=y;
		targetObj = new Ellipse2D.Double(x,y,65,65);
		
	}
	public void setFollowing(Target following){
		this.following=following;
	}

	public boolean inside(){
		return (x<=700&&x>=0)&&(y<=700&&y>=0);
	}
	public void updatePosition(){
		double yDel = (following.y>y)?following.y-y:y-following.y;
		double xDel = (following.x>x)?following.x-x:x-following.x;
		angle = Math.tanh((yDel)/(xDel));
		if(angle<0) angle *=-1;
		double delX=(double)speed*Math.sin(angle);
		double delY = (double)speed*Math.cos(angle);
		
		x= (isxLess())?x+delX:x-delX;
//		x +=delX;
		
		y= (isyLess())?y+delY:y-delY;
//		y+=delY;
		
		targetObj.setFrame(x, y, 65, 65);
	}

	public double getDistance(){
		double dis = Math.pow(Math.pow(x-following.x,2)+Math.pow(y-following.y,2),.5);
		return dis;
	}

	public boolean check(){
		return getDistance()<=80;
	}

	public boolean isxLess() {
		return xLess;
	}
	public void setxLess(boolean xLess) {
		this.xLess = xLess;
	}
	public boolean isyLess() {
		return yLess;
	}
	public void setyLess(boolean yLess) {
		this.yLess = yLess;
	}


	Ellipse2D.Double targetImg;


	

}
