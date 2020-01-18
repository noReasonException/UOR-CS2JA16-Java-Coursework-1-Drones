package random;

import factories.specification.AbstractEngineFactory;
import math.vector.Vector;
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
            v=getRandomLocationVector();
        }while (untilPredicate.apply(v));
        return v;
    }
    public Vector1 getRandomDirection(Function<Vector1,Boolean> untilPredicate){
        Vector1 v;
        do{
            v=getRandomDirectionVector();
        }while (untilPredicate.apply(v));
        return v;
    }

    public Vector3 getRandomLocationVector(){
        double x=random.nextDouble()%sizeX,y=random.nextDouble()%sizeY,z=random.nextDouble()%sizeZ;
        return new Vector3(x,y,z);
    }
    public Vector1 getRandomDirectionVector(){
        double x=random.nextDouble()%(Math.PI*2);
        return new Vector1(x);
    }
}
