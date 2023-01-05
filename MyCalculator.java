import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*<applet code="MyCalculator.class";width=300 height=300></applet>*/
public class MyCalculator extends Applet implements ActionListener {
    Button b[] = new Button[10];
    Button bopr[] = new Button[6];
    String opr[] = {"+", "-", "*", "/", "C", "="};
    TextField result = new TextField();
    int val1 = 0, val2 = 0;
    String operation = "";

    public void init(){
        super.init();
        setVisible(true);
        setLayout(new GridLayout(5,4));

        for(int i = 0; i < 10; i++) {
            b[i] = new Button(""+i);
            add(b[i]);
            b[i].addActionListener(this);
        }

        for(int i = 0; i < 6; i++) {
            bopr[i] = new Button(opr[i]);
            add(bopr[i]);
            bopr[i].addActionListener(this);
        }
        add(result);
        result.setText("");

    }

    public void actionPerformed(ActionEvent e){
        String s = e.getActionCommand();

        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            val1 = Integer.parseInt(result.getText());
            operation = s;
            result.setText("");
        }
        else if (s.equals("=")){
            val2 = Integer.parseInt(result.getText());
            int re = 0;
            s = operation;
            if (s.equals("+"))
                re = val1 + val2;
            else if (s.equals("-"))
                re = val1 - val2;
            else if (s.equals("*"))
                re = val1 * val2;
            else if (s.equals("/"))
                re = val1 / val2;
            result.setText(""+re);
            val1 = 0;
            val2 = 0;
        }
        else if (s.equals("C"))
            result.setText("");
        else
            result.setText(result.getText() + s);
    }

}