import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Clock extends JFrame{

    private Timer timer = new Timer();
    private JLabel timeLabel = new JLabel(" ", JLabel.CENTER);
    GameEvent event;
   public static int[][] shooter = {{100,100,120,130,140,150,160,175,180},
    					{0,3,5,9,12,15,20,20,20}
    	
   };
   public static int[] getXY(){
	   return new int[] {shooterObj.getX(),shooterObj.getY()};
   }
   public static Shooter shooterObj;
   public static Target targetObj;
    public Clock() {
    	
    	event = new GameEvent();
    	shooterObj = new Shooter();
    	targetObj = new Target();
    	
    	timeLabel.setBounds(100, 0, 100, 50);
    	shooterObj.setLocation(0,50);
    	targetObj.setLocation(100,0);
    	updater = new UpdateUITask();
    	
    	timeLabel.setText(String.valueOf(-1));
    	timeLabel.setSize(500,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(0,0);
	    setVisible(true);
        JPanel main = new JPanel();
        
        setLayout(null);
//        main.add(event);
        add(timeLabel);
        add(shooterObj);
        add(targetObj);
//        getContentPane().add(main);
        pack();
//        setLocationRelativeTo(null);
        setVisible(true);
        timer.schedule(updater, 0, 100);
    }

    public static UpdateUITask updater;
    

    
    





	@Override
	public Dimension getPreferredSize() {
		// TODO Auto-generated method stub
		return new Dimension(800,800);
	}
	public static int nSeconds = 0;
	private class UpdateUITask extends TimerTask {

        
        int counter = 0;
        public UpdateUITask(){
        	nSeconds = 0;
        }

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                	counter++;
                	if(counter/10>=shooter[0].length){
                		cancel();return;
                	}
                		
                	
                	if(counter/10==nSeconds){
                		shooterObj.moveToTarget();
                		}
                	else {                    	
                    	nSeconds=counter/10;
                    	targetObj.setNextPos();
                    	}
                    
                    	timeLabel.setText(String.valueOf(counter/10) +"  Distance"+(int)event.distance());
                    	
                	}
                
                    
                
            });
        }
    }

	public static Clock mainClock;
    public static void main(String args[]) {
    
    	
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
            	final Clock clock  = new Clock();
//            	clock.setForeground(Color.GRAY);
            }
        });
    }
}