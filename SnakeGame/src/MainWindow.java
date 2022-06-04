import javax.swing.*;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Xonix");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(357,387);
        setLocation(400,400);
//        add(new MainMenu());
            add(new GameField());

        setVisible(true);
    }
    public static void main(String[] args){
        MainWindow mw = new MainWindow();



    }

}
