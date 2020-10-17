package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CalculatorDemo extends JFrame {

    private static final int BUT_WIDTH = 80;
    private static final int BUT_HEIGHT = 70;
    private static final int WINDOW_WIDTH = 410;
    private static final int WINDOW_HEIGHT = 600;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;

    JTextField tout;
    JButton but_c, but_back, but_mod, but_div,
            but_7, but_8, but_9, but_mul,
            but_4, but_5, but_6, but_add,
            but_dot, but_0, but_equal;

    JPanel panel;
    // Button fonts
    Font bigTxtBtnFont = new Font("Comic Sans MS", Font.PLAIN, 33);
    Font butFont = new Font("Comic Sans MS", Font.PLAIN, 28);
    Font smallTxtBtnFont = new Font("Comic Sans MS", Font.PLAIN, 24);

    public CalculatorDemo(){

        /*
        this.addWindowListener(  new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);}} );// end addWindowListener
*/
        super();
        setLocationRelativeTo(null);
        setTitle("CalculatorDemo");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int [] x = { MARGIN_X, MARGIN_X + 90, MARGIN_X + 180, MARGIN_X + 270, 380};
        int [] y = { MARGIN_Y, MARGIN_Y + 100, MARGIN_Y + 180, MARGIN_Y + 260, MARGIN_Y +340, MARGIN_Y + 420};
        Cursor cur = new Cursor(Cursor.HAND_CURSOR);

        panel = new JPanel();
        panel.setLayout(null);
        tout = new JTextField("0");
        tout.setFont(bigTxtBtnFont);
        tout.setBounds(x[0], y[0], 330, 70);
        tout.setBackground(Color.WHITE);
        tout.setEditable(false);
        panel.add(tout);


        but_c = new JButton("C");
        but_c.setFont(butFont);
        but_c.setBackground(Color.WHITE);
        but_c.setBounds(x[0],y[1], BUT_WIDTH, BUT_HEIGHT);
        but_c.setCursor( cur );
        panel.add(but_c);

        but_back = new JButton("<-");
        but_back.setFont(butFont);
        but_back.setBackground(Color.WHITE);
        but_back.setBounds(x[1], y[1], BUT_WIDTH, BUT_HEIGHT);
        but_back.setCursor(cur);
        panel.add(but_back);

        add(panel);

    }



    public void showGUI(){
        //pack();
        setVisible(true);
    }

    public static void main(String [] args){
        CalculatorDemo demo = new CalculatorDemo();
        demo.showGUI();
    }

}
