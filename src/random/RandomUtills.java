package random;
import math.vector.Vector1;
import math.vector.Vector3;

import java.util.Random;
import java.util.function.Function;

public class RandomUtills {
    private Random random=new Random();

    private double sizeX,sizeY,sizeZ;

    public RandomUtills(double sizeX, double sizeY, double sizeZ) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.sizeZ = sizeZ;
    }

    public Vector3 getRandomLocation(Function<Vector3,Boolean> untilPredicate){
        Vector3 v;
        do{
            System.out.println("rand");
            v=getRandomLocationVector();
        }while (untilPredicate.apply(v));
        return v;
    }
    public Double getRandomDirection(Function<Double,Boolean> untilPredicate){
        double v;
        do{
            v=random.nextInt(360);
        }while (untilPredicate.apply(v));
        return v;
    }

    public Vector3 getRandomLocationVector(){
        //double x=random.nextInt((int)sizeX-20),y=random.nextInt((int) sizeY-20),z=random.nextInt((int)sizeZ-20);
        double x=random.nextInt((int)sizeX-20),y=random.nextInt((int) sizeY-20);
        return new Vector3(x,y,5);
    }
}
