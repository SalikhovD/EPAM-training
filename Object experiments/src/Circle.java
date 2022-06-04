class Circle {

    public double circleDia = 0;
    public double[] circlePos = new double[2];
    public double[] circleVel = new double[2];
    public double Mass = 0;

    public Circle (double [] circlePos, double [] circleVel, double mass) {
        this.circlePos = circlePos;
        this.circleVel = circleVel;
        this.Mass = mass;
        this.circleVel = circleVel;
        if (Mass <= 2500)
              this.circleDia = Math.sqrt(Mass)*10;
        else  this.circleDia = 50;
    }

}
