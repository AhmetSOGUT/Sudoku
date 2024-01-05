import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class BitisEkrani extends GirisEkrani implements ActionListener,Bitis {

    JFrame frame = new JFrame("Sudoku");
    ImageIcon icon = new ImageIcon("Sudoku/image/sas.png");
    ImageIcon iconic = new ImageIcon("Sudoku/image/giris.jpg");
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    JPanel panel1 = new JPanel();
    JPanel panel = new JPanel();
    static String zaman ;

    JButton buton = new JButton("Yeni oyun");

    BitisEkrani(String zaman){
        super(1);
        this.zaman=zaman;
        ekran();
    }

    public void ekran(){
        frame.setIconImage(iconic.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setMinimumSize(new Dimension(400,400));
        frame.setBounds(400,75,800,700);
        frame.setVisible(true);


        buton.setBounds(320,500,130,30);

        buton.addActionListener(this);

        frame.add(buton);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==buton){


            frame.setVisible(false);
            frame.dispose();
            GirisEkrani girisEkrani = new GirisEkrani();
        }

    }

    @Override
    public void basarisiz() {
        label.setIcon(icon);
        panel.setBounds(48,0,675,675);
        label.setText("Süreniz doldu maalesef basarısız oldunuz");

        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));

        panel.add(label);
        frame.add(panel);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println(zaman);

        try (FileWriter writer = new FileWriter(file,true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(" - "+" başarısız");
            bufferedWriter.newLine();
            bufferedWriter.close();
            writer.close();
        } catch (IOException a) {
            a.printStackTrace();
        }



    }

    @Override
    public void basarili() {
        label.setIcon(icon);
        panel.setBounds(140,0,500,420);
        panel1.setBounds(150,415,400,30);

        label.setText("    Tebrikler   ");
        label1.setText("      Bitirme Süreniz :  "+zaman);

        label.setHorizontalTextPosition(JLabel.CENTER);
        label1.setHorizontalTextPosition(JLabel.CENTER);

        label.setVerticalTextPosition(JLabel.BOTTOM);
        label1.setVerticalTextPosition(JLabel.BOTTOM);

        label.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));
        label1.setFont(new Font("MV Boli",Font.CENTER_BASELINE,20));

        panel1.add(label1);
        panel.add(label);

        frame.add(panel1);
        frame.add(panel);

        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

        System.out.println(zaman);

        try (FileWriter writer = new FileWriter(file,true)) {
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write(" - " +zaman);
            bufferedWriter.newLine();
            bufferedWriter.close();
            writer.close();

        } catch (IOException a) {
            a.printStackTrace();
        }


    }
}
