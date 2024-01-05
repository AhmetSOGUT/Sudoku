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
    ImageIcon iconic = new ImageIcon("Sudoku/image/giris.jpg");
    JLabel label = new JLabel();
    JPanel panel = new JPanel();
    JButton buton = new JButton("Giriş");
    JComboBox zorluklar = new JComboBox(zorluk);
    String adi;

    //BitisEkrani  çağrıldığında iki pencere açılmaması için boş constructor gerekliydi.
    GirisEkrani(int a){}
    GirisEkrani(){

        label.setIcon(icon);
        panel.setBounds(48,0,675,675);

        frame.setIconImage(iconic.getImage());
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


            adi= isim.getText();

            if (!file.exists()){
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }

            adi =isim.getText();
            try {
                if (adi.isEmpty())
                    throw new IllegalArgumentException();


                Arayuz arayuz =new Arayuz(zorlukTutucu);
                frame.setVisible(false);
                arayuz.setVisible(true);
                frame.dispose();

                try (FileWriter writer = new FileWriter(file,true)) {
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);
                    bufferedWriter.newLine();
                    bufferedWriter.write(adi+" - "+zorlukTutucu);
                    bufferedWriter.close();

                }
                catch (IOException a) {
                    a.printStackTrace();
                }

            }catch (IllegalArgumentException exception){
                System.out.println("İsim boş bırakılamaz!!!");
                JOptionPane.showMessageDialog(null, "Kullanıcı adı boş bırakılamaz");
            }




        }



}
}

