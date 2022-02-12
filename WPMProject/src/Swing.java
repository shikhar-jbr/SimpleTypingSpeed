import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Swing extends JFrame {

    private JTextField textField1, textField2;
    private JLabel label1, label2, label3;
    private String worr;
    private JButton button,button2;
    private double start;
    static String[] words={"afforest","aftermath","cloud","becalm","blithesome","broadsheet","buffoonish","caprice","capricious","causerie","chivalrous","congratulatory","dapper","debonaire","emblazon","eudaemonia","extremum","exultant","featherbrained","felicity","gabble","gallant","gilt","gleeful","halcyon","heyday","hotheaded","indefinite","madcap","majestic","merry","natty","noble","nuance","phantasy","pollyannaish","prate","salad","sappy","snappy","soda","spiffy","stunner","timbre","timberland","twaddle","vividness","wearisome","whimsical","whimsy","zippy"};

    public Swing() throws InterruptedException {
        Random random= new Random();
        Scanner scanner= new Scanner(System.in);
        String ok=" ";
        setLayout(null);
        setTitle("Typing Program");

        for(int i=0; i<10; i++){
            worr=words[random.nextInt(51)]+" ";
            ok+=worr;
        }

        label1= new JLabel("Welcome to Typing Speed Program");
        label1.setFont(new Font("Times New Roman",Font.BOLD,24));
        label1.setBounds(250,20,500,50);
        add(label1);

        label3 = new JLabel("Words");
        label3.setFont(new Font("Times New Roman",Font.ITALIC,20));
        label3.setBounds(20,130,70,60);
        add(label3);

        textField1= new JTextField(ok);
        textField1.setEditable(false);
        textField1.setBounds(80,130,890,60);
        textField1.setFont(new Font("Comic Sans",Font.BOLD,20));
        add(textField1);

        button= new JButton("Start");
        button.setBounds(450,210,100,40);
        button.setFont(new Font("Times New Roman",Font.BOLD,18));
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textField2.setVisible(true);
                start=LocalTime.now().toSecondOfDay();
                button.setFocusable(false);
            }
        });
        add(button);

        textField2= new JTextField();
        textField2.setFont(new Font("Comic Sans",Font.BOLD,20));
        textField2.setBounds(80,270,890,60);
        textField2.setVisible(false);
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                double end= LocalTime.now().toSecondOfDay();
                double elapsedTime= end-start;

                int numchars= textField2.getText().length();

                int wpm=(int)((((double) numchars/5)/elapsedTime)*60);

                label2.setText("Your WPM is: "+wpm+"!");
                button2.setVisible(true);
            }
        });
        add(textField2);

        label2= new JLabel();
        label2.setBounds(350,350,200,40);
        label2.setFont(new Font("Comic Sans",Font.BOLD,18));
        add(label2);

        button2= new JButton("Try Again");
        button2.setVisible(false);
        button2.setBounds(425,400,150,40);
        button2.setFont(new Font("Times New Roman",Font.BOLD,18));
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                dispose();
                try {
                    Swing sw= new Swing();
                    sw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    sw.setVisible(true);
                    sw.setSize(1000,1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        add(button2);

    }

    public static void main(String[] args) throws InterruptedException {
        Swing swing= new Swing();
        swing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swing.setVisible(true);
        swing.setSize(1000,600);
    }

}
