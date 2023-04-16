public class NBody{
    public static double readRadius(String file){
        In in = new In(file);
        int firstItemInFile = in.readInt();
        double secondItemInFile = in.readDouble();
        return secondItemInFile;
    }

    public static Planet[] readPlanets(String file){
        In in = new In(file);
        int N = in.readInt();
        double radius = in.readDouble();
        Planet[] p = new Planet[N];
        for (int i = 0; i < N; i++){
            p[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readString());
        }
        return p;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);
        int len = planets.length;
        double[] xForces = new double[len];
        double[] yForces = new double[len];

        StdDraw.enableDoubleBuffering();
        StdDraw.setCanvasSize(512,512);
        StdDraw.setScale(-radius,radius);

        for (double t0 = 0; t0 < T; t0 += dt){
            for (int j = 0; j < len; j++){
                xForces[j] = planets[j].calcNetForceExertedByX(planets);
                yForces[j] = planets[j].calcNetForceExertedByY(planets);
                planets[j].update(dt, xForces[j], yForces[j]);
            }

            StdDraw.picture(0,0, "images/starfield.jpg");
            for (int i = 0; i < len; i++){
                planets[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
        }

        StdOut.printf("%d\n", len);
        StdOut.printf("%.2e\n",radius);
        for (int k = 0; k < len; k++){
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName); 
        }
    }
}