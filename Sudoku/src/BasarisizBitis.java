import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BasarisizBitis implements ActionListener {

    JFrame frame = new JFrame("Sudoku");
    ImageIcon icon = new ImageIcon("Sudoku/image/sas.png");
    ImageIcon iconic = new ImageIcon("Sudoku/image/giris.jpg");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JButton buton = new JButton("Yeni oyun");

    BasarisizBitis(){
        ekran();
    }


    public void ekran(){

        label.setIcon(icon);
        panel.setBounds(48,0,675,675);
        label.setText("Süreniz doldu maalesef basarısız oldunuz");



        label.setHorizontalTextPosition(JLabel.CENTER);
       label.setVerticalTextPosition(JLabel.BOTTOM);
       label.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));


        frame.setIconImage(iconic.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setBounds(400,75,800,700);
        frame.setVisible(true);


        buton.setBounds(320,450,130,30);

        buton.addActionListener(this);

        frame.add(buton);
        panel.add(label);
        frame.add(panel);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==buton){
            frame.dispose();
            GirisEkrani girisEkrani = new GirisEkrani();
        }

    }
}
