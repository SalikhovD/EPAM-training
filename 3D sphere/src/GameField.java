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
    private final int SIZE = 320+16*40;
    private final int ALL_DOTS = 400;
    private int[] x = new int[ALL_DOTS];
    private int[] y = new int[ALL_DOTS];
    private int[][] sphereMatrix = new int[SIZE][SIZE];
    private double[][] cameraMatrixX = new double[SIZE][SIZE];
    private double[][] cameraMatrixY = new double[SIZE][SIZE];
    private double[][] cameraMatrixZ = new double[SIZE][SIZE];
    private float[][] screenMatrix = new float[SIZE][SIZE];
    private float[][] screenMatrixColor = new float[SIZE][SIZE];
    private double[] sphereCener = {100, 0, 0};
    private double[] lightVector = {1, 1, -1};
    private double[] lightPoint = {100, 25, 0};
    private double lightPointBrightness = 40;
    private double sphereRadius = 15;
    private double shading = 1;
    private double rot = 0;
    private int cameraAngle = 60;
    private double[] cameraPosition = {0, 0, 0};
    private double[] cameraVector = {1, 0, 0};
    private int time = 0;
    private int time2 = 0;
    private int dist = 10;
    float brightness;
    float color;
    float diffLight = 0.1f;
    private int [] check = {480,480};
    private Timer timer;
    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;
    private boolean forward = false;
    private boolean back = false;
    private boolean inGame = true;
    private boolean moved = true;
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
        right=false;
        up=false;
        down=false;
        refreshCameraMatrix();
        timer = new Timer(17,this);
        timer.start();
    }

    public void loadImages () {

        Sphere s1 = new Sphere();
        Sphere s2 = new Sphere();
        s1.radius = 25;
//        System.out.println(s1.radius);
//        System.out.println(s2.radius);

    }

    @Override
    protected void paintComponent(Graphics g) {
        time +=1;


        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g);
        if (inGame) {
            AffineTransform trans = new AffineTransform();

            for (int i = (SIZE)-1; i > 0; i--) {
                for (int j = (SIZE) - 1; j > 0; j--) {
                    if (screenMatrix[i][j] != 0.0f){

                        g.setColor(Color.getHSBColor(120, screenMatrixColor[i][j], screenMatrix[i][j]));
                        g.drawLine(i , j , i , j);
                    }

                }
            }
            g.setColor(Color.getHSBColor(120, 1f, 1f));
            g.drawLine(check[0]-5 , check[1]-5, check[0]+5 , check[1]+5);
            g.drawLine(check[0]-5 , check[1]+5, check[0]+5 , check[1]-5);

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
        fillMatrix();
//        System.out.print(cameraVector[0]+ "   " + cameraVector[1] + "   ");
//        System.out.println(Math.sqrt(Math.pow(cameraVector[0],2)+Math.pow(cameraVector[1],2)));

        if (left) {
//            lightPoint[1] += 1;
            cameraPosition[1] += 10*cameraVector[0];
            cameraPosition[0] -= 10*cameraVector[1];
        refreshCameraMatrix();
        }
        if (right) {
//            lightPoint[1] -= 1;
            cameraPosition[1] -= 10*cameraVector[0];
            cameraPosition[0] += 10*cameraVector[1];
            refreshCameraMatrix();
        }
        if (up) {
//            lightPoint[0] += 1;
            cameraPosition[0] += 10*cameraVector[0];
            cameraPosition[1] += 10*cameraVector[1];
            refreshCameraMatrix();
        }
        if (down) {
//            lightPoint[0] -= 1;
            cameraPosition[0] -= 10*cameraVector[0];
            cameraPosition[1] -= 10*cameraVector[1];
            refreshCameraMatrix();
        }
        if (forward) {
//            lightPoint[2] += 1;
            rot += 5;
            cameraVector[0] = Math.cos(Math.toRadians(rot));
            cameraVector[1] = Math.sin(Math.toRadians(rot));
            refreshCameraMatrix();
        }
        if (back) {
//            lightPoint[2] -= 1;
            rot -= 5;
            cameraVector[0] = Math.cos(Math.toRadians(rot));
            cameraVector[1] = Math.sin(Math.toRadians(rot));
            refreshCameraMatrix();
        }
//        System.out.println(cameraPosition[0] + "   " +cameraPosition[1]+ "   " + rot);


//        System.out.print((int)cameraPosition[0]+","+(int)cameraPosition[1]+","+(int)cameraPosition[2]+ "    ");
//        System.out.println(cameraMatrixX[400][400]+","+cameraMatrixY[400][400]+","+cameraMatrixZ[400][400]);

        lightVector[1] = Math.sin(0.05*time2);
        lightVector[0] = Math.sin(0.05*time2+0.785398);
        time2 += 1;
        time += 0.1;
        lightPoint[1] = sphereCener[1] + Math.cos(0.2*time)*(sphereRadius+dist);
        lightPoint[0] = sphereCener[0] + Math.sin(0.2*time)*(sphereRadius+dist);
        lightPoint[2] = sphereCener[2] +4;

        left = false;
        right = false;
        up = false;
        down = false;
        forward = false;
        back = false;
        moved = true;
    }

    private void refreshCameraMatrix() {
//        double sinCamera = Math.sin(Math.toRadians((double)cameraAngle/2));
//        double angStep = cameraAngle/(double)(SIZE);
//        System.out.println(angStep);
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                cameraMatrixY[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*j));
//                cameraMatrixZ[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*i));
//                cameraMatrixX[j][i] = Math.sqrt(1-Math.pow(cameraMatrixY[j][i],2)-Math.pow(cameraMatrixZ[j][i],2));
//            }
//        }
//    }
//        System.out.println(time);
        double sinCamera = Math.sin(Math.toRadians((double)cameraAngle/2));
        double angStep = cameraAngle/(double)(SIZE);
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j <= SIZE/2; j++) {
                cameraMatrixY[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*j));
                cameraMatrixZ[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*i));
                cameraMatrixX[j][i] = Math.sqrt(1-Math.pow(cameraMatrixY[j][i],2)-Math.pow(cameraMatrixZ[j][i],2));
                double length = Math.sqrt(Math.pow(cameraMatrixY[j][i],2)+Math.pow(cameraMatrixX[j][i],2));
                cameraMatrixY[j][i] /= length;
                cameraMatrixX[j][i] /= length;
                cameraMatrixY[j][i] = Math.sin(Math.asin(cameraMatrixY[j][i])+Math.toRadians(rot))*length;
                cameraMatrixX[j][i] = Math.cos(Math.acos(cameraMatrixX[j][i])+Math.toRadians(rot))*length;
                cameraMatrixY[j][i] += cameraPosition[1];
                cameraMatrixZ[j][i] += cameraPosition[2];
                cameraMatrixX[j][i] += cameraPosition[0];

            }
            for (int j = SIZE/2+1; j < SIZE; j++) {
                cameraMatrixY[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*j));
                cameraMatrixZ[j][i] = Math.sin(Math.toRadians((double)cameraAngle/2-angStep*i));
                cameraMatrixX[j][i] = Math.sqrt(1-Math.pow(cameraMatrixY[j][i],2)-Math.pow(cameraMatrixZ[j][i],2));
                double length = Math.sqrt(Math.pow(cameraMatrixY[j][i],2)+Math.pow(cameraMatrixX[j][i],2));
                cameraMatrixY[j][i] /= length;
                cameraMatrixX[j][i] /= length;
                cameraMatrixY[j][i] = Math.sin(Math.asin(cameraMatrixY[j][i])+Math.toRadians(rot))*length;
                cameraMatrixX[j][i] = Math.cos(Math.acos(cameraMatrixX[j][i])+Math.toRadians(-rot))*length;
                cameraMatrixY[j][i] += cameraPosition[1];
                cameraMatrixZ[j][i] += cameraPosition[2];
                cameraMatrixX[j][i] += cameraPosition[0];

            }
        }

//            System.out.println(cameraMatrixX[480][1]);
//
//            System.out.println(cameraMatrixX[480][480]);
//
//            System.out.println(cameraMatrixX[480][959]);

    }

    private void fillMatrix() {
        double h;
        double S;
        double d;
        double Pd[] = new double [3];
        double V[] = new double [3];
        double OP[] = new double [3];
        double BO[] = new double[3];
        double AO[] = new double[3];
        double P [] = new double[3];
        double P2 [] = new double[3];
        double n [] = new double[3];
        double l [] = new double[3];
        double matrixVec [] = new double[3];
        double cosa;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                matrixVec = new double[] {cameraMatrixX[j][i],cameraMatrixY[j][i],cameraMatrixZ[j][i]};
                h=VectorToPointDistance(cameraPosition,matrixVec,sphereCener);
                screenMatrix [j][i] = 0;
                brightness = 0f;
                color = 0f;
                if (h<=sphereRadius) {
                    d = Math.sqrt(+Math.pow(sphereRadius, 2) - Math.pow(h, 2)); //Находим растояние от точки пересечения луча до точки P
                    Pd = new double [] {(matrixVec[0]-cameraPosition[0]) * d,(matrixVec[1]-cameraPosition[1]) * d,(matrixVec[2]-cameraPosition[2]) * d}; //Находим вектор от точки пересечения луча со сферой до точки P
                    BO = VectorSubtraction(sphereCener,matrixVec);
                    AO = VectorSubtraction(sphereCener,cameraPosition);
                    V = VectorProduct(BO,AO);
                    OP = VectorProduct(V,VectorSubtraction(matrixVec,cameraPosition));
                    P = VectorSumm(sphereCener, OP); // Находим ближайшую точку от луча до центра сферы
                    P2 = VectorSubtraction(P, Pd); // Находим точку пересечения луча со сферой
                    n = VectorSubtraction(P2, sphereCener);
                    l = VectorSubtraction(P2, lightPoint);
                    if (j == check[0] && i == check[1]) {
//                        System.out.println(Pd[0]+ " " + Pd[1]+ " " +Pd[2]);
//                        System.out.println(d);
                    }

                    //Вычисляем освещенность от направленного света
                    cosa = VectorsCos(n,lightVector);
                    brightness = diffLight;
                    if (cosa >= -1 && cosa <= 0) {
                        brightness += (float) Math.log(-cosa +1);
                    }

                    //Вычисляем освещенность от точечного света
                    cosa = VectorsCos(n,l);
                    if (cosa >= -1 && cosa <= 0) {
                        brightness += (float) Math.log(-cosa +1) * lightPointBrightness / (Math.pow(l[0], 2) + Math.pow(l[1], 2) + Math.pow(l[2], 2));
                        color += (float) Math.log(-cosa +1) * lightPointBrightness / (Math.pow(l[0], 2) + Math.pow(l[1], 2) + Math.pow(l[2], 2));
                    }

                    //Рисуем источник света
                    if (PointToPointDistance(P2,cameraPosition) >= PointToPointDistance(lightPoint,cameraPosition))
                    {
                        h=VectorToPointDistance(cameraPosition,matrixVec,lightPoint);
                        if (h >= 0 && h <= 25) {
                            brightness += (float) lightPointBrightness / 50 / Math.pow(h, 3);
                            brightness += (float) lightPointBrightness / 200 / Math.pow(h, 2);
                            color += (float) lightPointBrightness / 50 / Math.pow(h, 3);
                            color += (float) lightPointBrightness / 200 / Math.pow(h, 2);
                        }
                    }

                }
                else {
                    h=VectorToPointDistance(cameraPosition,matrixVec,lightPoint);
                    if (h >= 0 && h <= 15) {
                        brightness += (float) lightPointBrightness / 50 / Math.pow(h, 3);
                        brightness += (float) lightPointBrightness / 200 / Math.pow(h, 2);
                        color += (float) lightPointBrightness / 50 / Math.pow(h, 3);
                        color += (float) lightPointBrightness / 200 / Math.pow(h, 2);
                    }
                }
                    brightness /= shading; //Корректируем общую освещенность

                    //Заполняем матрицы освещенность и цвета
                    if (brightness>=0f && brightness<=1f) {
                        screenMatrix[j][i] = brightness;
                    }
                    else screenMatrix[j][i] = 1f;
                    if (color>=0f && color<=1f) {
                        screenMatrixColor[j][i] = color;
                    }
                    else screenMatrixColor[j][i] = 1f;



            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }
    private double DotProduct(double [] v0, double[] v1) {
        return v0[0]*v1[0]+v0[1]*v1[1]+v0[2]*v1[2];
    }

    private double [] VectorProduct(double [] v0, double[] v1) {
        return new double [] {v0[1]*v1[2]-v0[2]*v1[1],-v0[0]*v1[2]+v0[2]*v1[0],v0[0]*v1[1]-v0[1]*v1[0]};
    }
    private double [] VectorSumm(double [] v0, double[] v1) {
        return new double [] {v0[0]+v1[0],v0[1]+v1[1],v0[2]+v1[2]};
    }
    private double [] VectorSubtraction(double [] v0, double[] v1) {
        return new double [] {v0[0]-v1[0],v0[1]-v1[1],v0[2]-v1[2]};
    }
    private double VectorToPointDistance(double [] v0, double [] v1, double[] p) {
        double [] v = VectorSubtraction(v1,v0);
        p = VectorSubtraction(p,v0);
        double S = Math.sqrt(Math.pow(v[1]*p[2]-v[2]*p[1],2) + Math.pow(v[2]*p[0]-v[0]*p[2],2) + Math.pow(v[0]*p[1]-v[1]*p[0],2));
        return S/Math.sqrt(Math.pow(v[0],2)+Math.pow(v[1],2)+Math.pow(v[2],2));
    }
    private double PointToPointDistance(double [] p0, double[] p1) {
        double [] p = VectorSubtraction(p0,p1);
        return Math.sqrt(Math.pow(p[0],2)+Math.pow(p[1],2)+Math.pow(p[2],2));
    }

    private double VectorsCos(double [] v0, double[] v1) {
        return (DotProduct(v0,v1)) / (Math.sqrt(Math.pow(v0[0], 2) + Math.pow(v0[1], 2) + Math.pow(v0[2], 2)) * Math.sqrt(Math.pow(v1[0], 2) + Math.pow(v1[1], 2) + Math.pow(v1[2], 2)));
    }

    private double [] Normalised(double [] v) {
        double length = Math.sqrt(Math.pow(v[0],2)+Math.pow(v[1],2)+Math.pow(v[2],2));
//        System.out.println(length);
        return new double [] {v[0]/length,v[1]/length,v[2]/length};
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
