public class Planet {
    public double xxPos; // current x position
    public double yyPos; // current y position
    public double xxVel; // current velocity in the x direction
    public double yyVel; // current velocity in the y direction
    public double mass;  
    public String imgFileName;
    private static final double G = 6.67e-11;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p) {
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p) {
        double r = calcDistance(p);
        return G * mass * p.mass / (r * r);
    }

    public double calcForceExertedByX(Planet p) {
        double r = calcDistance(p);
        double x = p.xxPos - xxPos;
        return calcForceExertedBy(p) * x / r;
    }

    public double calcForceExertedByY(Planet p) {
        double r = calcDistance(p);
        double y = p.yyPos - yyPos;
        return calcForceExertedBy(p) * y / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double forceExertedByX = 0.0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) {
            	continue;
            }
            forceExertedByX += calcForceExertedByX(planet);
        }
        return forceExertedByX;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double forceExertedByY = 0.0;
        for (Planet planet : allPlanets) {
            if (this.equals(planet)) {
            	continue;
            }
            forceExertedByY += calcForceExertedByY(planet);
        }
        return forceExertedByY;
    }

    public void update(double dt, double fX, double fY){
        double ax = fX / mass;
        double ay = fY / mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
