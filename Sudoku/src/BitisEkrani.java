import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BitisEkrani implements ActionListener {

    JFrame frame = new JFrame("Sudoku");
    ImageIcon icon = new ImageIcon("C:/Users/ahmet/OneDrive/Masaüstü/SudokuJava1-main/Sudoku/Sudoku/image/sas.png");
    ImageIcon iconic = new ImageIcon("C:/Users/ahmet/OneDrive/Masaüstü/SudokuJava1-main/Sudoku/Sudoku/image/giris.jpg");
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel = new JPanel();
    String zaman ;

    JButton buton = new JButton("Yeni oyun");

    BitisEkrani(String zaman){
       this.zaman=zaman;
        ekran();
    }


    public void ekran(){

        label.setIcon(icon);
        panel.setBounds(140,0,500,420);
        panel1.setBounds(150,415,400,30);



        label.setText("    Tebrikler   ");
        label1.setText("      Bitirme Süreinz :  "+zaman);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        label.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        label.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));
        label1.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));


        frame.setIconImage(iconic.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setBounds(400,75,800,700);
        frame.setVisible(true);


        buton.setBounds(320,500,130,30);

        buton.addActionListener(this);

        frame.add(buton);
        panel1.add(label1);
        panel.add(label);

        frame.add(panel1);
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
