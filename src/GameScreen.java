import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public class GameScreen extends JPanel{
    int height; //So luong cac o cua game
    int width;
    int numsPlayer ; //So luong ng choi: 1 ng choi voi bot, 2 ng choi voi nhau
    int player; //player = 1 (X), player = 2 (O)
    public StatusBoard status; //trang thai cua cac o, chua danh = 0; 1|2 la x|o
    public int address; //toa do cua chuot khi click tren table
    public static setImage gameScreenBackground;
    public setImage table; //Bang cac o vuong
    public CheckWin check;
    public MouseAdapter onClick;
    public static int winner;
    public JButton backButton;

    public GameScreen(){
        winner = -1; //chua co ai win, = 0 la hoa, 1 la X win, 2 la O win
        setBounds(0, 0, 800, 600);
        setLayout(null);
        height= 16;
        width = 16;
        check = new CheckWin(height,width);
        status = new StatusBoard(height,width);
        player = 1; // cai nay de player 1 choi trc (X choi trc)
                    //co the nang cap hon bang switch case de chon xem X hay O di trc
        gameScreenBackground = new setImage("img/gameScreenBackgr.png", 0,0,800,600);
        table = new setImage("img/gameScreenBackgr.png",20,20,480,480);
        Image backButtonImage = null;
        try {
            backButtonImage = ImageIO.read(getClass().getResource("img/BackButton1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        backButton = new JButton("");
        backButton.setIcon(new ImageIcon(backButtonImage));
        backButton.setBorderPainted(false);
        backButton.setBounds(20,520,40,40);
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGame.jFrame.remove(MainGame.gameScreen);
                MainGame.jFrame.add(MainGame.menuScreen);
                MainGame.startGame = true;
                MainGame.jFrame.repaint();
            }
        });
        add(backButton);
        GamePlay();
        setImage[][] squareBox = new setImage[16][16]; //Dien tung o vuong vao cac o trong table
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                status.statusBoard[i][j] = 0; //set trang thai cua cac o = 0;
                squareBox[i][j] = new setImage("img/box1.png",i*32,j*32,31,31);
                table.add(squareBox[i][j]);
                squareBox[i][j].addMouseListener(onClick);
            }
        }
        add(table);
        add(gameScreenBackground);
        repaint();
    }

    public void GamePlay(){
        player = 1;
//        JPanel turn;
        onClick = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);

                if(MainGame.startGame){
                    MainGame.jFrame.repaint();
                    setImage a = (setImage) e.getComponent();
                    address = table.getComponentZOrder(a); //tra ve vi tri khi click chuot theo thu tu la cot doc
                    int row = address % 16;
                    int col = address / 16;

                    if (status.statusBoard[row][col] == 0){ //Dk trong if la de xet xem o nay dang co trang thai 0 hay 1|2 (Da dc danh hay chua)
                                                            //Neu = 0 thi check cac dk ben duoi va thay doi trang thai.
                        if(player == 1){
                            a.setPicture("img/XPoint1.png");
                            status.setStatus(row,col,player);
                            repaint();
                            if(check.isChecked(row, col, status.statusBoard, player)){
                                MainGame.startGame = false ;
                                JFrame msgDialog = new JFrame();
                                JOptionPane.showMessageDialog(msgDialog,"Người chơi 1 (X) đã thắng");
                                System.out.println("Người chơi 1 win");
                            }

                            else if(check.isDraw(status.statusBoard)){
                                MainGame.startGame = false;
                                JFrame msgDialog = new JFrame();
                                JOptionPane.showMessageDialog(msgDialog,"Trận chiến ngang tài, ngang sức");
                            }
                            player = 2;
                        }
                        else if(player == 2 ){
                            a.setPicture("img/OPoint1.png");
                            status.setStatus(row,col,player);
                            repaint();
                            if(check.isChecked(row, col, status.statusBoard, player)){
                                MainGame.startGame = false;
                                JFrame msgDialog = new JFrame();
                                JOptionPane.showMessageDialog(msgDialog,"Người chơi 2 (O) đã thắng");
                                System.out.println("Người chơi 2 win");
                            }
                            else if(check.isDraw(status.statusBoard)){
                                MainGame.startGame = false;
                                JFrame msgDialog = new JFrame();
                                JOptionPane.showMessageDialog(msgDialog,"Trận chiến ngang tài, ngang sức");
                            }
                            player = 1 ;
                        }
                    }
                }
            }
        };
    }
}
