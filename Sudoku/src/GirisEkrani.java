import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

class GirisEkrani  implements ActionListener{
    String[] zorluk={"kolay","orta","zor"};
    File file = new File("Sonuçlar.txt");
    static String zorlukTutucu="kolay";
    JFrame frame = new JFrame("Sudoku");
    JTextField isim = new JTextField();
    ImageIcon icon = new ImageIcon("Sudoku/image/sas.png");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JButton buton = new JButton("Giriş");
    JComboBox zorluklar = new JComboBox(zorluk);


    GirisEkrani(){

        label.setIcon(icon);
        panel.setBounds(48,0,675,675);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(400,75,800,700);
        frame.setVisible(true);

        isim.setBounds(310,430,150,30);
        zorluklar.setBounds(320,470,130,30);
        buton.setBounds(320,520,130,30);


        zorluklar.addActionListener(this);
        buton.addActionListener(this);

        frame.add(zorluklar);
        frame.add(buton);
        panel.add(label);
        frame.add(panel);
        frame.add(isim);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==zorluklar){
            zorlukTutucu= (String) zorluklar.getSelectedItem();
            System.out.println(zorlukTutucu);
        }

        if(e.getSource()==buton){

            Arayuz arayuz =new Arayuz(zorlukTutucu);

            if (!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            String adı =isim.getText();

            try (FileWriter writer = new FileWriter(file)) {
                writer.write("");
                writer.write(adı+" "+zorlukTutucu);
                writer.write("");
                writer.close();

            } catch (IOException a) {
                a.printStackTrace();
            }
            frame.setVisible(false);
            arayuz.setVisible(true);
        }
    }

}

