import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.Timer;

class Counter {

private static int cnt;
static JFrame f;
public static void main(String args[]) {

	 f=new JFrame();
	 f.setSize(100,100);
	 f.setVisible(true);


	 ActionListener actListner = new ActionListener() {
		 @Override
		 public void actionPerformed(ActionEvent event) {
			 cnt += 1;
			 if(cnt%2==0)
			 {
			    f.setVisible(true);
			 }
			 else
			 {
			    f.setVisible(false);
			 }
		}
	};
		
	Timer timer = new Timer(1000, actListner);
		
	timer.start();
	}
}