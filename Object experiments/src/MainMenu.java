import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class MainMenu extends JPanel implements ActionListener {
    int activeButton = 0;
    int numberOfButtons = 4;
    public boolean inMenu = true;
    public MainMenu() {
        setBackground(Color.black);
        addKeyListener(new KeyListener());
        setFocusable(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inMenu) {
            repaint();
        }
    }

    class KeyListener extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                if (inMenu) {
                    super.keyPressed(e);
                    int key = e.getKeyCode();
                    if (key == KeyEvent.VK_ENTER) {
                        if (activeButton == 0) {
                            return;

                        }

                    }
                    if (key == KeyEvent.VK_DOWN) {
                        if (activeButton != numberOfButtons - 1) {
                            activeButton++;
                        } else {
                            activeButton = 0;
                        }
                    }
                    if (key == KeyEvent.VK_UP) {
                        if (activeButton != 0) {
                            activeButton--;
                        } else {
                            activeButton = numberOfButtons - 1;
                        }
                    }
                    System.out.println(activeButton);
                    repaint();

                }
            }
    }

    @Override
    protected void paintComponent (Graphics g) {
        if (inMenu) {
            Graphics2D g2d = (Graphics2D) g;
            super.paintComponent(g);
            String[] strings = {"Start", "Records", "Credits", "Exit"};
            int[][] fonts = {{40, 105, 120},
                    {30, 105, 120},
                    {40, 105, 160},
                    {30, 105, 160},
                    {40, 105, 200},
                    {30, 105, 200},
                    {40, 105, 240},
                    {30, 105, 240}};
            int x;
            int y;

            Font f = new Font("Arial", Font.BOLD, fonts[2][1]);
            for (int i = 0; i < strings.length; i++) {
                if (activeButton == i) {
                    f = new Font("Arial", Font.BOLD, fonts[i * 2][0]);
                    g.setColor(Color.pink);
                    x = fonts[i * 2][1];
                    y = fonts[i * 2][2];
                } else {
                    f = new Font("Arial", Font.BOLD, fonts[i * 2 + 1][0]);
                    g.setColor(Color.white);
                    x = fonts[i * 2 + 1][1];
                    y = fonts[i * 2 + 1][2];

                }

                g.setFont(f);
                g.drawString(strings[i], x, y);

            }


        }
    }

    }
//    public static void main(String[] args){
//        MainMenu mm = new MainMenu();
//    }


