import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
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
    public Clock() {
    	
    	event = new GameEvent();
    	event.setBounds(0,0,1000,500);
    	updater = new UpdateUITask();
    	
    	timeLabel.setText(String.valueOf(-1));
    	setBackground(null);
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        JPanel main = new JPanel();
       setLayout(new FlowLayout());
       add(timeLabel);
       
       add(event);
        
//        getContentPane().add(event);
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
		return new Dimension(1400,800);
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
                		event.setAll(nSeconds,shooter[0][nSeconds],shooter[1][nSeconds]);
                		event.moveToTarget();
                		}
                	else if(counter/10==nSeconds){
                		event.moveToTarget();
                    	}
                    
                    	timeLabel.setText(String.valueOf(counter/10) +"  Distance"+(int)event.distance());
                    	if(counter/10 + 1>=shooter[0].length){
                    		cancel();
                    	}	
                    	
                	}
                
                
                    
                
            });
        }
    }
	

//	@Override
//	public void paint(Graphics arg0) {
//		// TODO Auto-generated method stub
//		super.paint(arg0);
//		
//	}
	public static Clock mainClock;
    public static void main(String args[]) {
    
    	Clock clock = new Clock();
    	clock.setBounds(0,0,1400,800);
        
    }
}