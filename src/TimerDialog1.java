import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;


public class TimerDialog1 extends JDialog {

    /** Start this timer. */
    protected final JButton startButton = new JButton("Start");

    /** Stop this timer. */
    protected final JButton stopButton = new JButton("Stop");

    /** Display the elapsed time. */
    protected final static JLabel timeDisplay = 
        new JLabel("0:00:00", SwingConstants.CENTER);

    protected static Timer timer;
    
	public TimerDialog1() {
        super((JFrame) null, "Timer");
        setSize(new Dimension(200,120));
        configureUI();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        setResizable(false);
    }

    private void configureUI() {
        setLayout(new BorderLayout());
        add(timeDisplay, BorderLayout.CENTER);
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttons.setBorder(BorderFactory.createEmptyBorder(0,0,10,0));
        buttons.add(startButton);
        buttons.add(stopButton);
        add(buttons, BorderLayout.SOUTH);

        startButton.setFocusPainted(false);
        startButton.addActionListener(e -> startClicked());

        stopButton.setFocusPainted(false);
        stopButton.addActionListener(e -> stopClicked());
    }

    /** Callback to be invoked when the start button is clicked.
     * Hook to be overridden by a subclass. */
    protected void startClicked() {
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
        TimerModel.start();
        timer.start();
        
        timeDisplay.setText("0:00:00");
    }

    /** Callback to be invoked when the stop button is clicked.
     * Hook to be overridden by a subclass. */
    protected void stopClicked() {
        stopButton.setEnabled(false);
        startButton.setEnabled(true);

        timer.stop();
    }
    
    /** Initialize the 1 second timer that updates the timeDisplay
     * in the GUI. */
    protected static void timerThread() {
    	ActionListener actListner = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				long ss = TimerModel.elapsedTime() / 1000;
            	long mm = ss / 60;
            	long hh = mm / 60;
            	ss = ss % 60;
            	mm = mm % 60;
            	timeDisplay.setText(String.format("%d:%02d:%02d", hh, mm, ss));
            	timeDisplay.repaint();
			}
			
        };

        timer = new Timer(1000, actListner);
    }

    public static void main(String[] args) {
        new TimerDialog1();
        new TimerModel();
        
        timerThread();
        
        
        
        
    }
    
    
}
