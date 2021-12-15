import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainGame {
    public static JFrame jFrame;
    public static MenuScreen menuScreen;
    public static GameScreen gameScreen;
    public static boolean startGame;
    static {
        try {
            menuScreen = new MenuScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     public MainGame(){
        startGame = true;
        int width = 800;
        int height = 600;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 3 dong duoi la de game hien thi ra giữa màn hình
        int x = ((int) screenSize.getWidth() / 2 - 400);
        int y = ((int) screenSize.getHeight() / 2 -300);
        jFrame = new JFrame("Game caro");
        jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setLayout(null);
        jFrame.setBounds(100,100,width,height);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocation(x,y);
        jFrame.add(menuScreen);
    }
    public static void main(String[] args) {
        MainGame main = new MainGame();
    }
}
