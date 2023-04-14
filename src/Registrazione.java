import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Registrazione extends JFrame implements ActionListener {
    JButton b1, b2;
    JTextField f1, f2, f3;
    JLabel l1,l2,l3, l0, l,scelta;
    Font f;
    ArrayList<String[]> reg= new ArrayList<String[]>();
    JFrame frame1=new JFrame();
    JFrame frame2= new JFrame();
    JFrame frame3= new JFrame();

    JButton c1,c2;
    JTextArea a;
    JLabel label1, label2;
    JPanel panel1;
    JButton p1, p2, p3;
    Registrazione(){


        //FRAME 1 - REGISTRAZIONE
        f1= new JTextField();
        f2= new JTextField();
        f3= new JTextField();

        f1.setBounds(110, 65, 150, 20);
        f2.setBounds(130, 115, 130, 20);
        f3.setBounds(110, 165, 150, 20);

        f= new Font("Helvetica", Font.BOLD, 15);

        l0= new JLabel("REGISTRAZIONE");
        l1= new JLabel("Nome:");
        l2= new JLabel("Cognome:");
        l3= new JLabel("Email:");

        l0.setFont(f);

        l0.setBounds(105, 5, 150, 50);
        l1.setBounds(60,65,50,20);
        l2.setBounds(60,115,70,20);
        l3.setBounds(60, 165, 50,20);

        b1=new JButton("REGISTRA");
        b1.setBounds(110, 215, 115, 35);


        b2= new JButton("...");
        b2.setBounds(1, 1,25, 25);
        b2.setBackground(Color.LIGHT_GRAY);

        b2.addActionListener(this);
        b1.addActionListener(this);

        frame1.add(l0);
        frame1.add(l1);
        frame1.add(l2);
        frame1.add(l3);

        frame1.add(f1);
        frame1.add(f2);
        frame1.add(f3);

        frame1.add(b1);
        frame1.add(b2);



        l= new JLabel();

        frame1.add(l);


        frame1.setTitle("Registrazione");
        frame1.setSize(350, 330);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(false);

        frame2.setTitle("Registrazioni");
        frame2.setSize(500, 500);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setResizable(false);

        label1= new JLabel("REGISTRAZIONI");
        frame2.add(label1);

        a= new JTextArea();
        a.setVisible(true);
        a.setBounds(0,0, 500,500);
        a.setEditable(false);
        frame2.add(a);

        //FRAME 3 - SCELTA COLORI

        panel1= new JPanel();
        panel1.setBackground(Color.black);
        panel1.setBounds(17, 10, 300, 200);
        frame3.add(panel1);

        label2= new JLabel("SCEGLI UN COLORE SELEZIONANDOLO");
        label2.setBounds(55, 215, 220, 30);
        frame3.add(label2);

        p1= new JButton();
        p1.setBounds(40, 250, 50, 25);
        p1.setBackground(Color.red);
        p2= new JButton();
        p2.setBounds(140, 250, 50, 25);
        p2.setBackground(Color.blue);
        p3= new JButton();
        p3.setBounds(240, 250, 50, 25);
        p3.setBackground(Color.yellow);

        frame3.add(p1);
        frame3.add(p2);
        frame3.add(p3);
        p1.addActionListener(this);
        p2.addActionListener(this);
        p3.addActionListener(this);



        frame3.add(l);
        frame3.setTitle("Scelta colori");
        frame3.setSize(350, 330);
        frame3.setResizable(false);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.setVisible(false);



        //FRAME 2 - SCELTA

        scelta= new JLabel("SCEGLI UN PROGRAMMA");
        scelta.setBounds(165,40,200,50);
        scelta.setFont(f);
        this.add(scelta);
        c1= new JButton("REGISTRAZIONI");
        c2=new JButton("SCELTA COLORE");
        c1.setBounds(75,100,150,50);
        c2.setBounds(275,100,150,50);
        c1.addActionListener(this);
        c2.addActionListener(this);
        this.add(c1);
        this.add(c2);
        this.add(l);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(500,250);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==c1) {
            this.setVisible(false);
            frame1.setVisible(true);
        }
        if(e.getSource()==c2){
            this.setVisible(false);
            frame3.setVisible(true);
        }
        if(e.getSource()==p1){
            panel1.setBackground(Color.red);
        }else if(e.getSource()==p2){
            panel1.setBackground(Color.blue);
        }else if(e.getSource()==p3){
            panel1.setBackground(Color.yellow);
        }

        if(e.getSource()==b1){
            String[] cont= {f1.getText(), f2.getText(), f3.getText()};
            reg.add(cont);
            f1.setText("");
            f2.setText("");
            f3.setText("");

        }else if(e.getSource()==b2){
            this.setVisible(false);
            frame2.setVisible(true);
            String testo= "";

            for(int i= 0; i < reg.size(); i++){
                String[] cont= reg.get(i);
                testo += "Persona"+(i+1) + "\n"+" Nome: " + cont[0] + " Cognome: " + cont[1] + " Indirizzo: " + cont[2] + "\n";
            }
            a.setText(testo);
        }
    }
}