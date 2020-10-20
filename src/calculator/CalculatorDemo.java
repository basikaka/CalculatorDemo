package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Pattern;

public class CalculatorDemo extends JFrame {

    private static final int BUT_WIDTH = 80;
    private static final int BUT_HEIGHT = 70;
    private static final int WINDOW_WIDTH = 410;
    private static final int WINDOW_HEIGHT = 600;
    private static final int MARGIN_X = 20;
    private static final int MARGIN_Y = 60;

    private boolean addWrite = true;  // control the text field display
    private boolean keepgo   = true;  // control the Opt model

    JTextField tout;
    JButton but_c, but_back, but_mod, but_div,
            but_7, but_8, but_9, but_mul,
            but_4, but_5, but_6, but_add,
            but_1, but_2, but_3, but_sub,
            but_dot, but_0, but_equal;

    JPanel panel;
    // Button fonts
    Font bigTxtBtnFont = new Font("Comic Sans MS", Font.PLAIN, 33);
    Font butFont = new Font("Comic Sans MS", Font.PLAIN, 28);
    Font smallTxtBtnFont = new Font("Comic Sans MS", Font.PLAIN, 24);

    public enum Opt {
        NORMAL,  // NULL Operator
        MOD,
        DIV,
        MUL,
        ADD,
        SUB
    }
    Opt opt = Opt.NORMAL;

    private double saveVal = 0; //save current result of calc or first input

    public CalculatorDemo(){
        super();

        this.addWindowListener(  new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);}} );// end addWindowListener


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
        tout.setBounds(x[0], y[0], 350, 70);
        tout.setBackground(Color.WHITE);
        tout.setEditable(false);
        panel.add(tout);


        but_c = new JButton("C");
        but_c.setFont(butFont);
        but_c.setBackground(Color.WHITE);
        but_c.setBounds(x[0],y[1], BUT_WIDTH, BUT_HEIGHT);
        but_c.setCursor( cur );
        but_c.addActionListener(event -> {
            tout.setText("0");
        });
        panel.add(but_c);

        but_back = new JButton("<-");
        but_back.setFont(butFont);
        but_back.setBackground(Color.WHITE);
        but_back.setBounds(x[1], y[1], BUT_WIDTH, BUT_HEIGHT);
        but_back.setCursor(cur);
        but_back.addActionListener(event->{
           String str1 = tout.getText();
           StringBuilder str2 = new StringBuilder();
           for( int i = 0; i < (str1.length()-1); i++){
               str2.append(str1.charAt(i));
           }
           if( str2.toString().equals("")){
               tout.setText("0");
           }
           else{
               tout.setText( str2.toString());
               //System.out.println(str2.toString());
           }
        });
        panel.add(but_back);

        but_mod = new JButton("%");
        but_mod.setFont(butFont);
        but_mod.setBackground(Color.WHITE);
        but_mod.setBounds(x[2], y[1], BUT_WIDTH, BUT_HEIGHT);
        but_mod.setCursor(cur);
        panel.add(but_mod);

        but_div = new JButton("/");
        but_div.setFont(butFont);
        but_div.setBackground(Color.WHITE);
        but_div.setBounds(x[3], y[1], BUT_WIDTH, BUT_HEIGHT);
        but_div.setCursor(cur);
        but_div.addActionListener(event->{
            if(Pattern.matches("([-]?\\d+[.]\\d*)|(\\d+)", tout.getText())){
                if(keepgo){
                    saveVal = calc(saveVal, tout.getText(), opt);
                    if(Pattern.matches("([-]?\\d+[.][0]*)", String.valueOf(saveVal))){
                        tout.setText( String.valueOf((int) saveVal));
                    }else {
                        tout.setText( String.valueOf(saveVal));
                    }
                    keepgo = false;
                    addWrite = false;
                    opt = Opt.DIV;
                }
            }
        });
        panel.add(but_div);

        but_7 = new JButton("7");
        but_7.setFont(butFont);
        but_7.setBackground(Color.WHITE);
        but_7.setBounds(x[0], y[2], BUT_WIDTH, BUT_HEIGHT);
        but_7.setCursor(cur);
        but_7.addActionListener(event -> {
            if(addWrite){
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("7");
                }else {
                    tout.setText( tout.getText() + "7");
                }
            }else {
                tout.setText("7");
                addWrite = true;
            }
            keepgo = true;
        });

        panel.add(but_7);

        but_8 = new JButton("8");
        but_8.setFont(butFont);
        but_8.setBackground(Color.WHITE);
        but_8.setBounds(x[1], y[2], BUT_WIDTH, BUT_HEIGHT);
        but_8.setCursor(cur);
        but_8.addActionListener(event -> {
            if(addWrite){
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("8");
                }else {
                    tout.setText( tout.getText() + "8");
                }
            }else {
                tout.setText("8");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_8);

        but_9 = new JButton("9");
        but_9.setFont(butFont);
        but_9.setBackground(Color.WHITE);
        but_9.setBounds(x[2], y[2], BUT_WIDTH, BUT_HEIGHT);
        but_9.setCursor(cur);
        but_9.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("9");
                } else {
                    tout.setText(tout.getText() + "9");
                }
            }else {
                tout.setText("9");
                addWrite = true;
            }
            keepgo = true;

        });
        panel.add(but_9);

        but_mul = new JButton("*");
        but_mul.setFont(butFont);
        but_mul.setBackground(Color.WHITE);
        but_mul.setBounds(x[3], y[2], BUT_WIDTH, BUT_HEIGHT);
        but_mul.setCursor(cur);
        panel.add(but_mul);



        but_4 = new JButton("4");
        but_4.setFont(butFont);
        but_4.setBackground(Color.WHITE);
        but_4.setBounds(x[0], y[3], BUT_WIDTH, BUT_HEIGHT);
        but_4.setCursor(cur);
        but_4.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("4");
                } else {
                    tout.setText(tout.getText() + "4");
                }
            }else {
                tout.setText("4");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_4);

        but_5 = new JButton("5");
        but_5.setFont(butFont);
        but_5.setBackground(Color.WHITE);
        but_5.setBounds(x[1], y[3], BUT_WIDTH, BUT_HEIGHT);
        but_5.setCursor(cur);
        but_5.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("5");
                } else {
                    tout.setText(tout.getText() + "5");
                }
            }else {
                tout.setText("5");
                addWrite = true;
            }
            keepgo = true;

        });
        panel.add(but_5);

        but_6 = new JButton("6");
        but_6.setFont(butFont);
        but_6.setBackground(Color.WHITE);
        but_6.setBounds(x[2], y[3], BUT_WIDTH, BUT_HEIGHT);
        but_6.setCursor(cur);
        but_6.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("6");
                } else {
                    tout.setText(tout.getText() + "6");
                }
            }else {
                tout.setText("6");
                addWrite = true;
            }
            keepgo = true;

        });
        panel.add(but_6);

        but_add = new JButton("+");
        but_add.setFont(butFont);
        but_add.setBackground(Color.WHITE);
        but_add.setBounds(x[3], y[3], BUT_WIDTH, BUT_HEIGHT);
        but_add.setCursor(cur);
        panel.add(but_add);


        but_1 = new JButton("1");
        but_1.setFont(butFont);
        but_1.setBackground(Color.WHITE);
        but_1.setBounds(x[0], y[4], BUT_WIDTH, BUT_HEIGHT);
        but_1.setCursor(cur);
        but_1.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("1");
                } else {
                    tout.setText(tout.getText() + "1");
                }
            }else {
                tout.setText("1");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_1);

        but_2 = new JButton("2");
        but_2.setFont(butFont);
        but_2.setBackground(Color.WHITE);
        but_2.setBounds(x[1], y[4], BUT_WIDTH, BUT_HEIGHT);
        but_2.setCursor(cur);
        but_2.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("2");
                } else {
                    tout.setText(tout.getText() + "2");
                }
            }else {
                tout.setText("2");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_2);

        but_3 = new JButton("3");
        but_3.setFont(butFont);
        but_3.setBackground(Color.WHITE);
        but_3.setBounds(x[2], y[4], BUT_WIDTH, BUT_HEIGHT);
        but_3.setCursor(cur);
        but_3.addActionListener(event ->{
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("3");
                } else {
                    tout.setText(tout.getText() + "3");
                }
            }else {
                tout.setText("3");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_3);

        but_sub = new JButton("-");
        but_sub.setFont(butFont);
        but_sub.setBackground(Color.WHITE);
        but_sub.setBounds(x[3], y[4], BUT_WIDTH, BUT_HEIGHT);
        but_sub.setCursor(cur);
        panel.add(but_sub);

        but_dot = new JButton(".");
        but_dot.setFont(butFont);
        but_dot.setBackground(Color.WHITE);
        but_dot.setBounds(x[0], y[5], BUT_WIDTH, BUT_HEIGHT);
        but_dot.setCursor(cur);
        panel.add(but_dot);

        but_0 = new JButton("0");
        but_0.setFont(butFont);
        but_0.setBackground(Color.WHITE);
        but_0.setBounds(x[1], y[5], BUT_WIDTH, BUT_HEIGHT);
        but_0.setCursor(cur);
        but_0.addActionListener(event -> {
            if(addWrite) {
                if (Pattern.matches("[0]*", tout.getText())) {
                    tout.setText("0");
                } else {
                    tout.setText(tout.getText() + "0");
                }
            }else {
                tout.setText("0");
                addWrite = true;
            }
            keepgo = true;
        });
        panel.add(but_0);

        but_equal = new JButton("=");
        but_equal.setFont(butFont);
        but_equal.setBackground(Color.WHITE);
        but_equal.setBounds(x[2], y[5], BUT_WIDTH, BUT_HEIGHT);
        but_equal.setCursor(cur);
        panel.add(but_equal);

        add(panel);

    }



    public void showGUI(){
        //pack();
        setVisible(true);
    }

    public double calc( double x, String input, Opt model) {
        double y = Double.parseDouble(input);
        if (model == Opt.ADD) {
            return x + y;
        } else if (model == Opt.SUB) {
            return x - y;
        } else if (model == Opt.MUL) {
            return x * y;
        } else if (model == Opt.DIV) {
            return x / y;
        } else if (model == Opt.MOD) {
            return x % y;
        }
        return y;

    }

    public void repaintFont(){

    }

    public static void main(String [] args){
        CalculatorDemo demo = new CalculatorDemo();
        demo.showGUI();
    }

}
