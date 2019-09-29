# MVC-Timer
 A timer made using the Model-View-Controller design

Write a very simple "timer" dialog in Java. The
dialog shall consist of three GUI components: a text field to display
the elapse time in the hh:mm:ss format and start and stop buttons to
start and stop the timer (see a demo).

Code it incrementally.
  P1*: GUI consisting of a text field and two buttons.
      Swing features: JLabel, JButton, and layout managers like
        BorderLayout and FlowLayout

  P2: Logic for starting and stopping the timer and showing only
      the start/stop time.
      Swing features: Event, event handler and event registration
        ActionEvent, ActionListener, addActionListener
	long System.currentTimeMillies()

  P3: Display the elapsed time continuously (e.g., at every second).
      Swing feature: single threadness
        To update the display periodically, use either 
	the javax.swing.Timer class:
          Timer(int, ActionListener), start(), stop()
        or the Thread class and SwingUtilities.invokeLater(Runnable)
