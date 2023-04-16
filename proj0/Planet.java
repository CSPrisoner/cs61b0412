public class Planet{
    static final double G = 6.67e-11;
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public  Planet(double xP, double yP, double xV, double yV, double m, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet b){
        xxPos = b.xxPos;
        yyPos = b.yyPos;
        xxVel = b.xxVel;
        yyVel = b.yyVel;
        mass = b.mass;
        imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet p){
        return Math.sqrt((xxPos - p.xxPos) * (xxPos - p.xxPos) + (yyPos - p.yyPos) * (yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet P){
        double r = calcDistance(P);
        return (G * mass * P.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet P){
        double r = calcDistance(P);
        return (G * mass * P.mass) * (P.xxPos - xxPos) / (r * r * r);
    }

    public double calcForceExertedByY(Planet P){
        double r = calcDistance(P);
        return (G * mass * P.mass) * (P.yyPos - yyPos) / (r * r * r);
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        int len = allPlanets.length;
        double force_x = 0;
        if (allPlanets == null)
            return 0;
        for (int i = 0; i < len; i++){
            if (!this.equals(allPlanets[i]))
                force_x += calcForceExertedByX(allPlanets[i]);
        }
        return force_x;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        int len = allPlanets.length;
        double force_y = 0;
        if (allPlanets == null)
            return 0;
        for (int i = 0; i < len; i++){
            if (!this.equals(allPlanets[i]))
                force_y += calcForceExertedByY(allPlanets[i]);
        }
        return force_y;
    }

    public void update(double dt, double fx, double fy){
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel = this.xxVel + dt * ax;
        this.yyVel = this.yyVel + dt * ay;
        this.xxPos = this.xxPos + this.xxVel * dt;
        this.yyPos = this.yyPos + this.yyVel * dt;  
    }

    public void draw(){
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }

}