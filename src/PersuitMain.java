import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class PersuitMain extends JPanel{
	JLabel timeLabel = new JLabel();
	public static Timer timer = new Timer();
	Target A,B,C,D;
	public static UpdateUITask updater;
	public PersuitMain(){
		formatter = new DecimalFormat("#0.0");
		A = new Target(20,0);B=new Target(400,0);C=new Target(400,400);D=new Target(0,400);
		A.setxLess(true);A.setyLess(true);B.setxLess(false);B.setyLess(true);C.setxLess(false);C.setyLess(false);D.setxLess(true);D.setyLess(false);
		A.setFollowing(B);B.setFollowing(C);C.setFollowing(D);D.setFollowing(A);
		updater = new UpdateUITask();
		timer.schedule(updater,0, 50);
	}
	int nSeconds;
	NumberFormat formatter; 
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
                	
                		
                	
                	if(counter/10>=5+nSeconds)
                		nSeconds=counter/10;
//                		setAll(nSeconds,targetCoords[0].get(nSeconds),targetCoords[1].get(nSeconds));
                		
//                		moveToTarget();
//                		if(counter/10==nSeconds)
                		nSeconds = counter/10;
                		A.updatePosition();
//                		if(counter/10==nSeconds+1)
                		B.updatePosition();
//                		if(counter/10==2+nSeconds)
                		C.updatePosition();
//                		if(counter/10==3+nSeconds)
                		D.updatePosition();
                		repaint();
                		System.out.println(A.getDistance()+", "+B.getDistance()+", "+C.getDistance()+", "+D.getDistance());
                	
                		if(A.check()||B.check()||C.check()||D.check()||!(A.inside()&&B.inside()&&C.inside()&&D.inside())){
                			if(frame!=null) frame.repaint();
                			cancel();
                		}
                	}
                
                
                    
                
            });
        }
    }



	@Override
public void paint(Graphics arg0) {
	// TODO Auto-generated method stub
	super.paint(arg0);
	Graphics2D g = (Graphics2D)arg0;
	g.setColor(Color.red);
	g.fill(A.targetObj);
	g.setColor(Color.blue);
	g.fill(B.targetObj);
	g.setColor(Color.green);
	g.fill(C.targetObj);
	g.setColor(Color.CYAN);
	g.fill(D.targetObj);
}


	public static PersuitMain p;
	static JFrame frame;
	static String[] targetNames={"A","B","C","D"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frame = new JFrame("Persuit");
		
		frame.setLayout(null);
//		frame.setSize(1600, 800);
		frame.setVisible(true);
		
		JPanel settings = new JPanel();
		settings.setLayout(null);
		settings.setBounds(700,0,500,800);
		JButton btn = new JButton("START");
		frame.setSize(1200, 800);
		settings.setBackground(Color.red);
		JLabel[] speedLabels = new JLabel[4];
		JTextField[] speedText = new JTextField[4];
		for(int i=0;i<4;i++){
			speedLabels[i] = new JLabel("Speed OF "+targetNames[i]+":");
			speedText[i] = new JTextField("10");
			speedLabels[i].setBounds(10,10+i*100,100,40);
			speedText[i].setBounds(120,10+i*100,90, 30);
			settings.add(speedLabels[i]);settings.add(speedText[i]);
			
		}
		
		
		
		btn.setBounds(100, 600, 100, 40);
		settings.add(btn);
		frame.add(settings);frame.repaint();
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if(p!=null) frame.remove(p);
				p = new PersuitMain();
				p.A.speed=Double.parseDouble(speedText[0].getText().toString());
				p.B.speed=Double.parseDouble(speedText[1].getText().toString());
				p.C.speed=Double.parseDouble(speedText[2].getText().toString());
				p.D.speed=Double.parseDouble(speedText[3].getText().toString());
		p.setBounds(50,50,550,700);
		p.setBackground(Color.gray);
		p.timeLabel.setBounds(400,700,300,40);
		frame.add(p);
		
		frame.repaint();
//		frame.add(btn);
			}
		});
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
