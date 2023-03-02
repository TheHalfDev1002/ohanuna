

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Dialog implements ActionListener
{
    JFrame fr;
    JButton b1,b2,b3;

    Dialog()
    {
        fr=new JFrame("Mifras Menu");
        fr.setLayout(null);
        fr.setSize(800,600);

        b1=new JButton("Notes");
        b1.setBounds(350,200,100,30);
        fr.add(b1);
        b2=new JButton("Quiz");
        b2.setBounds(350,250,100,30);
        fr.add(b2);
        b3=new JButton("QUIT");
        b3.setBounds(350, 300, 100, 30);
        fr.add(b3);
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        fr.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    { 
        if(e.getSource()==b1)
        {
            String[] dayCodes = {"mndi","3412"};
            String[] letters = {"Day 1:","day 2:"};
            String x=JOptionPane.showInputDialog(fr,"enter day code");
            int len = dayCodes.length;
            int i;
            boolean a;
            for(i = 0;i<len;i++){
                if(x == dayCodes[i]){
                    JOptionPane.showConfirmDialog(fr,letters[i]);
                    a = true;
                    break;
                }else{a = false;}
            }if(a = false){
               JOptionPane.showMessageDialog(fr,"Invalid Day Code");
            }
        }
        if(e.getSource()==b2)
        {
            String[] options = {"2","3","Googol"};
            int x=JOptionPane.showOptionDialog(fr,"1+1=?","Question #1",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
            if(x==JOptionPane.YES_OPTION)
                JOptionPane.showMessageDialog(fr,"Wrong! Its 3 lol");
            if(x==JOptionPane.NO_OPTION)
                JOptionPane.showMessageDialog(fr,"Right!");
            if(x==JOptionPane.CANCEL_OPTION)
                JOptionPane.showMessageDialog(fr,"Maybe");
        }
        if(e.getSource()==b3)
        {String name=JOptionPane.showInputDialog(fr,"enter your name", "Ori hanuna");
            if (name != null) {
            JOptionPane.showConfirmDialog(fr,"Welcome "+name+", Wanna start our journey?", "Q&a", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            }
        else{
                JOptionPane.showConfirmDialog(fr,"Welcome Unknown user, Wanna start our journey?", "Q&a", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            }
        }
    }

    
}
public class Mifras{
    public static void run()
    {
        new Dialog();
    }
}