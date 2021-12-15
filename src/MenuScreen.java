
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class MenuScreen extends JPanel {
    public MenuScreen() throws IOException {
        int width = 800; //chieu rong
        int height = 600;//chieu dai
        setLayout(null); // De dinh vi cac components mot cach tuyet doi bang ham setBounds
        setBounds(0,0, width, height); //ham dung de thiet lap cac vi tri

        Image onePlayerImage = ImageIO.read(getClass().getResource("img/CARO.png"));
        Image twoPlayerImage = ImageIO.read(getClass().getResource("img/2ngchoi.png"));
        Image exitImage      = ImageIO.read(getClass().getResource("img/exit.png"));

        //Khoi tao cac button
        JButton onePlayerButton = new JButton("");
        onePlayerButton.setIcon(new ImageIcon(onePlayerImage));
        JButton twoPlayerButton = new JButton("");
        twoPlayerButton.setIcon(new ImageIcon(twoPlayerImage));
        JButton exitButton      = new JButton("");
        exitButton.setIcon(new ImageIcon(exitImage));

        //setup vi tri cho cac button
        onePlayerButton.setBounds(310,400,150,40);
        twoPlayerButton.setBounds(310,450,150,40);
        exitButton.setBounds(310,500,150,40);

        // Them action listener cho cac button
        onePlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                System.out.println("1 player key pressed");
                //Chuong trinh se xoa menu Screen sau do se add game Screen vao voi so ng choi la 1(Choi voi may);
                JFrame msgDialog = new JFrame();
                JOptionPane.showMessageDialog(msgDialog,"Chế độ chơi đang được update");
            }
        });
        twoPlayerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //Chuong trinh se xoa menu Screen sau do se add game Screen vao voi so ng choi la 2;
                MainGame.jFrame.remove(MainGame.menuScreen);
                MainGame.gameScreen = new GameScreen();
                MainGame.gameScreen.numsPlayer = 2;
                MainGame.jFrame.add(MainGame.gameScreen);
                MainGame.jFrame.repaint();
            }

        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) { //Cai nay la exit
                System.exit(0);
            }
        });

        //Add button
        add(onePlayerButton);
        add(twoPlayerButton);
        add(exitButton);
        setImage backgroundImage = new setImage("img/menuSc.png",0,0,800,600); //set bg cho menu
        this.add(backgroundImage);
    }

}
