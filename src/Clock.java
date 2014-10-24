import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class Clock extends JFrame{

    private Timer timer = new Timer();
    private JLabel timeLabel = new JLabel(" ", JLabel.CENTER);
    GameEvent event;
   public static int[][] shooter = {{100,100,120,160,180,200,220,250,260},
    					{0,6,10,18,24,30,40,40,40}
    					};
    public Clock() {
    	
    	event = new GameEvent();
    	updater = new UpdateUITask();
    	timeLabel.setText(String.valueOf(-1));
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2,1));

        add(timeLabel);
        add(event);

        pack();
//        setLocationRelativeTo(null);
        setVisible(true);
        timer.schedule(updater, 0, 100);
    }

    public static UpdateUITask updater;
    

    





	private class UpdateUITask extends TimerTask {

        int nSeconds = 0;
        int counter = 0;
        public UpdateUITask(){
        	
        }

        @Override
        public void run() {
            EventQueue.invokeLater(new Runnable() {

                @Override
                public void run() {
                	if(counter/10>=shooter[0].length||(event.distance()<30&&counter/10>0)){
                		cancel();return;
                	}
                		
                	counter++;
                	event.moveToTarget();
                    if(counter/10>nSeconds){                    	
                    	nSeconds=counter/10;
                    	event.setAll(counter/10,shooter[0][counter/10], shooter[1][counter/10]);
                    	}
                    
                    	timeLabel.setText(String.valueOf(counter/10) +"  Distance"+(int)event.distance());
                    	
                	}
                
                    
                
            });
        }
    }

	public static Clock mainClock;
    public static void main(String args[]) {
    	final Clock clock  = new Clock();
    	clock.setForeground(Color.GRAY);
//        EventQueue.invokeLater(new Runnable() {
//
//            @Override
//            public void run() {
//            	if(clock.event.isInRange())
//            		updater.cancel();
//            }
//        });
    }
}