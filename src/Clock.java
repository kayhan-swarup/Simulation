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
    	
    	updater = new UpdateUITask();
    	
    	timeLabel.setText(String.valueOf(-1));
    	timeLabel.setBounds(200, 20, 100, 50);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100,800, 600);
        JPanel main = new JPanel();
        setLayout(new BorderLayout());
        main.setLayout(null);
        main.setSize(500,500);
//        main.add(event);
        main.add(shooterObj);
        main.add(targetObj);
        add(timeLabel,BorderLayout.PAGE_START);
        add(main,BorderLayout.CENTER);
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
                	
                		
                	
                	if(counter/10>nSeconds){
                		nSeconds=counter/10;
                    	targetObj.setNextPos();
                		}
                	else if(counter/10==nSeconds){                    	
                		shooterObj.moveToTarget();
                    	}
                    
                	
                    	timeLabel.setText(String.valueOf(counter/10) +"  Distance"+(int)event.distance());
                    	if(counter/10 + 1>=shooter[0].length){
                    		cancel();return;
                    	}	
                    	
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