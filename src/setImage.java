import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class setImage extends JPanel{
    private int width;
    private int height;
    private Image myImage;

    public setImage(String nameFile, int x, int y, int width, int height) { //In ra anh tai vi tri x,y va
        this.width = width;                                                 //chieu rong width, chieu cao height
        this.height = height;
        String s = getClass().getResource(nameFile).toString();
        this.myImage = new ImageIcon(getClass().getResource(nameFile)).getImage();
        setLayout(null);
        this.setBounds(x, y, width, height);
        repaint();
    }
    public void setPicture(String nameFile) {
        this.myImage = new ImageIcon(getClass().getResource(nameFile)).getImage();
    }
    @Override
    public void paintComponent(Graphics g) { //Ham ve anh
        g.drawImage(myImage, 0, 0, this);
    }
}
