package calculator;

import javax.swing.*;

public class CalculatorDemo extends JFrame {

    private final int BUT_WIDTH = 60;
    private final int BUT_HEIGHT = 30;
    JButton but_0, but_1, but_2, but_3, but_4,
            but_5, but_6, but_7, but_8, but_9,
            but_add, but_sub, but_multi, but_div;
    


    JTextField tout;

    public CalculatorDemo(){
        prepareGUI();
    }

    public void prepareGUI(){
        setTitle("CalculatorDemo");
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void showGUI(){
        pack();
        setVisible(true);
    }

    public static void main(String [] args){
        CalculatorDemo demo = new CalculatorDemo();
        demo.showGUI();
    }

}
