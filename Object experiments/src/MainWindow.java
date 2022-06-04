import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Xonix");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(357+16*40,387+16*40);
        setLocation(500,005);
//        add(new MainMenu());
            add(new GameField());

        setVisible(true);
    }
    public static void main(String[] args){
        MainWindow mw = new MainWindow();



    }

}
