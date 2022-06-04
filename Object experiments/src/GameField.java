import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;

public class GameField extends JPanel implements ActionListener {
    private final int SIZE = 320+16*40;
    private final int ALL_DOTS = 400;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int G = 1000;
    private double energy = 0;
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean forward = false;
    private boolean back = false;
    private boolean inGame = true;
    private boolean moved = true;

    Circle circle[] = new Circle[25];





    public GameField() {
        setBackground(Color.black);
        loadObjects();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
        System.out.println("Game Field is running");

    }
    public void initGame() {
                inGame = true;
        left=false;
        right=false;
        up=false;
        down=false;
        timer = new Timer(5,this);
        timer.start();
    }

    public void loadObjects () {
        for (int i = 1; i < circle.length; i++) {
            int Dia = 50;
            circle[i] = new Circle(new double[] {Math.random()*(SIZE-Dia),Math.random()*(SIZE-Dia)},new double[] {Math.random(),Math.random()},Math.random()*25);

        }
        circle[0] = new Circle(new double[] {400,400},new double[] {0,0.001},200);
//        circle[1] = new Circle(new double [] {600,400},new double[] {0,2},1);
//        circle[2] = new Circle(new double [] {200,400},new double[] {0,-2},1);
    }



    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        AffineTransform trans = new AffineTransform();
        g.setColor(Color.getHSBColor(120, 60, 60));


        for (int i = 0; i < circle.length; i++) {
            g.setColor(Color.getHSBColor(120, 60, 60));
            g.fillOval((int) (circle[i].circlePos[0]-circle[i].circleDia/2), (int) (circle[i].circlePos[1]-circle[i].circleDia/2), (int) circle[i].circleDia, (int) circle[i].circleDia);
//            g.setColor(Color.getHSBColor(0, 0, 0));
//            g.drawString(String.valueOf(circle[i].circleVel),(int)circle[i].circlePos[0],(int)circle[i].circlePos[1]);
        }
    }


    public void move() {
        energy = 0;


        for (int i = 0; i < circle.length; i++) {

            double acc[] = new double[2];
            acc[0] = acc[0]+defineForces(i)[0]/circle[i].Mass;
            acc[1] = acc[1]+defineForces(i)[1]/circle[i].Mass;
            circle[i].circleVel = VectorSumm(circle[i].circleVel,acc);

            circle[i].circlePos [0] += circle[i].circleVel[0];
            circle[i].circlePos [1] += circle[i].circleVel[1];
            energy += circle[i].Mass*Math.pow(PointToPointDistance(circle[i].circleVel,new double [] {0,0}),2)/2;
//            if (circle[i].circlePos[0] <= circle[i].circleDia/2 || circle[i].circlePos[0] >= SIZE-circle[i].circleDia/2) {
//                circle[i].circleVel[0] *= -1;
//            }
//            if (circle[i].circlePos[1] <= circle[i].circleDia/2 || circle[i].circlePos[1] >= SIZE-circle[i].circleDia/2) {
//                circle[i].circleVel[1] *= -1;
//            }

        }
        System.out.println(energy+"  ");


        left = false;
        right = false;
        up = false;
        down = false;
        forward = false;
        back = false;
        moved = true;
    }

    public double [] defineForces(int i){
        double forces [] = {0,0};

        for (int j = 0; j < circle.length; j++) {
            if (j != i) {
                if (PointToPointDistance(circle[j].circlePos, circle[i].circlePos) > (circle[j].circleDia + circle[i].circleDia) / 2) {
                    forces[0] += PointToPointVector(circle[j].circlePos, circle[i].circlePos)[0]/Math.pow(PointToPointDistance(circle[j].circlePos, circle[i].circlePos),2);
                    forces[1] += PointToPointVector(circle[j].circlePos, circle[i].circlePos)[1]/Math.pow(PointToPointDistance(circle[j].circlePos, circle[i].circlePos),2);

                }
            }
        }
        forces[0] *= G;
        forces[1] *= G;
        return forces;
    }

    public void checkCollision(int i) {
//
//        for (int j = 0; j < circle.length; j++) {
//            if (j != i) {
//                if (PointToPointDistance(circle[j].circlePos, circle[i].circlePos) < (circle[j].circleDia + circle[i].circleDia) / 2) {
//                    System.out.println("Столкновение");
//                    double kinetic[] = new double[2];
//                    kinetic[0] = circle[j].circleVec[0]*circle[j].circleVel + circle[i].circleVec[0]*circle[i].circleVel;
//                    kinetic[1] = circle[j].circleVec[1]*circle[j].circleVel + circle[i].circleVec[1]*circle[i].circleVel;
//                    circle[j].circleVec = Normalised(kinetic);
//                    circle[i].circleVec = Normalised(kinetic);
//                    circle[j].circleVel = Math.sqrt(Math.pow(kinetic[0],2)+Math.pow(kinetic[1],2))/2;
//                    circle[i].circleVel = Math.sqrt(Math.pow(kinetic[0],2)+Math.pow(kinetic[1],2))/2;
//
//                }
//            }
//        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    private double DotProduct(double [] v0, double[] v1) {
        return v0[0]*v1[0]+v0[1]*v1[1];
    }

    private double [] VectorProduct(double [] v0, double[] v1) {
        return new double [] {v0[1]*v1[2]-v0[2]*v1[1],-v0[0]*v1[2]+v0[2]*v1[0],v0[0]*v1[1]-v0[1]*v1[0]};
    }
    private double [] VectorSumm(double [] v0, double[] v1) {
        return new double [] {v0[0]+v1[0],v0[1]+v1[1]};
    }
    private double [] VectorSubtraction(double [] v0, double[] v1) {
        return new double [] {v0[0]-v1[0],v0[1]-v1[1]};
    }
    private double VectorToPointDistance(double [] v0, double [] v1, double[] p) {
        double [] v = VectorSubtraction(v1,v0);
        p = VectorSubtraction(p,v0);
        double S = Math.sqrt(Math.pow(v[1]*p[2]-v[2]*p[1],2) + Math.pow(v[2]*p[0]-v[0]*p[2],2) + Math.pow(v[0]*p[1]-v[1]*p[0],2));
        return S/Math.sqrt(Math.pow(v[0],2)+Math.pow(v[1],2)+Math.pow(v[2],2));
    }
    private double PointToPointDistance(double [] p0, double[] p1) {
        double [] p = VectorSubtraction(p0,p1);
        return Math.sqrt(Math.pow(p[0],2)+Math.pow(p[1],2));
    }

    private double [] PointToPointVector(double [] p0, double[] p1) {
        double p2[] = new double[2];
        p2 = Normalised(VectorSubtraction(p0,p1));
        return p2;
    }

    private double VectorsCos(double [] v0, double[] v1) {
        return (DotProduct(v0,v1)) / (Math.sqrt(Math.pow(v0[0], 2) + Math.pow(v0[1], 2) + Math.pow(v0[2], 2)) * Math.sqrt(Math.pow(v1[0], 2) + Math.pow(v1[1], 2) + Math.pow(v1[2], 2)));
    }

    private double [] Normalised(double [] v) {
        double length = Math.sqrt(Math.pow(v[0],2)+Math.pow(v[1],2));
        return new double [] {v[0]/length,v[1]/length};
    }

  class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if (!inGame && key == KeyEvent.VK_ENTER)
                initGame();


            if (key == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (key == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (key == KeyEvent.VK_UP) {
                up = true;
            }
            if (key == KeyEvent.VK_DOWN) {
                down = true;
            }
            if (key == KeyEvent.VK_PAGE_UP) {
                forward = true;
            }
            if (key == KeyEvent.VK_PAGE_DOWN) {
                back = true;
            }

            moved = false;
        }

    }



}
