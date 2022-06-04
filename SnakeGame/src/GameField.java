import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320;
    private final int DOT_SIZE = 16;
    private final int ALL_DOTS = 400;
    private Image dot;
    private Image head;
    private Image apple;
    private int appleX;
    private int appleY;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int dots;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean inGame = true;
    private boolean moved = true;
    private char keyStacked = 's';
    AffineTransform identity = new AffineTransform();





    public GameField() {
        setBackground(Color.black);
        loadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
        System.out.println("Game Field is running");

    }
    public void initGame() {
                inGame = true;
        left=false;
        right=true;
        up=false;
        down=false;
        dots = 3;
        for (int i = 0; i < dots; i++) {
            x[i] = 48 - i*DOT_SIZE;
            y[i] = 48;
        }
        timer = new Timer(100,this);
        timer.start();
        createApple();
    }

    private void createApple() {
        appleX = new Random().nextInt(20)*DOT_SIZE;
        appleY = new Random().nextInt(20)*DOT_SIZE;
        for (int i = 0; i < dots; i++) {
            if (appleX == x[i] && appleY == y[i])
                createApple();
        }
    }

    public void loadImages () {
        ImageIcon iia = new ImageIcon("Apple.png");
        apple = iia.getImage();
        ImageIcon iid = new ImageIcon("SnakeBody.png");
        dot = iid.getImage();
        ImageIcon iih = new ImageIcon("SnakeHead.png");
        head = iih.getImage();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        if (inGame) {
            AffineTransform trans = new AffineTransform();

            g2d.drawImage(apple, appleX, appleY, this);
            for (int i = 1; i < dots; i++) {
                g.drawImage(dot, x[i], y[i], this);
            }

            trans.setTransform(identity);

            if (left){
                trans.translate(x[0], y[0]+DOT_SIZE);
                trans.rotate(Math.toRadians(-90));

        }
            if (right){
                trans.translate(x[0]+DOT_SIZE,y[0]);
                trans.rotate(Math.toRadians(90));

        }
            if (down){
                trans.translate(x[0]+DOT_SIZE, y[0]+DOT_SIZE);
                trans.rotate(Math.toRadians(180));

        }
            if (up){
                trans.rotate(Math.toRadians(0));
                trans.translate(x[0], y[0]);
            }

            g2d.drawImage(head,trans,this);

        }
        else
        {
            String str = "Game Over";
            String str2 = "Press Enter to try again";
            Font f = new Font("Arial",Font.BOLD,25);
            g.setColor(Color.red);
            g.setFont(f);
            g.drawString(str,105,SIZE/2);
            g.setColor(Color.white);
            f = new Font("Arial",Font.BOLD,14);
            g.setFont(f);
            g.drawString(str2,90,SIZE/2+25);
            timer.stop();

        }

    }

    public void move() {
        for (int i = dots; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        if (left) {
            x[0] -= DOT_SIZE;
        }
        if (right) {
            x[0] += DOT_SIZE;
        }
        if (up) {
            y[0] -= DOT_SIZE;
        }
        if (down) {
            y[0] += DOT_SIZE;
        }


        if (keyStacked == 'L') {
            left = true;
            up = false;
            down = false;
            keyStacked = 's';
        }
        if (keyStacked == 'R') {
            right = true;
            up = false;
            down = false;
            keyStacked = 's';
        }
        if (keyStacked == 'U') {
            up = true;
            left = false;
            right = false;
            keyStacked = 's';
        }
        if (keyStacked == 'D') {
            down = true;
            left = false;
            right = false;
            keyStacked = 's';
        }


        moved = true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            checkApple();
            move();
            checkCollisions();

        }
        repaint();
    }

    private void checkCollisions() {
        for (int i = dots; i > 0; i--) {
            if (x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
            }

        }

        if (x[0] > SIZE || y[0] > SIZE || x[0] < 0 || y[0] <0 ) {
            inGame = false;
        }
    }

    private void checkApple() {
        if (x[0] == appleX && y[0] == appleY) {
            dots++;
            createApple();
        }

    }
    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if (!inGame && key == KeyEvent.VK_ENTER)
                initGame();


            if (key == KeyEvent.VK_LEFT && !right && moved == false) {
                keyStacked = 'L';
            }
            if (key == KeyEvent.VK_RIGHT && !left && moved == false) {
                keyStacked = 'R';
            }
            if (key == KeyEvent.VK_UP && !down && moved == false) {
                keyStacked = 'U';
            }
            if (key == KeyEvent.VK_DOWN && !up && moved == false) {
                keyStacked = 'D';
            }

            if (key == KeyEvent.VK_LEFT && !right && moved) {
                left = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_RIGHT && !left && moved) {
                right = true;
                up = false;
                down = false;
            }
            if (key == KeyEvent.VK_UP && !down && moved) {
                up = true;
                left = false;
                right = false;
            }
            if (key == KeyEvent.VK_DOWN && !up && moved) {
                down = true;
                left = false;
                right = false;
            }

            moved = false;
        }

    }

    class MainMenu {


    }

}
