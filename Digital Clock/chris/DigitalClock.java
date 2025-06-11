import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {
    private JLabel clockLabel;

    public DigitalClock() {
        setTitle("Digital Clock");
        setSize(300, 100);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        clockLabel = new JLabel();
        clockLabel.setFont(new Font("Arial", Font.BOLD, 32));
        add(clockLabel);

        // Timer updates every second
        Timer timer = new Timer(1000, e -> updateClock());
        timer.start();

        updateClock(); // initialize immediately
        setVisible(true);
    }

    private void updateClock() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        clockLabel.setText(sdf.format(new Date()));
    }

    public static void main(String[] args) {
        new DigitalClock();
    }
}

