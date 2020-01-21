package random;

import etc.Constants;
import etc.WindowInfo;
import math.vector.Vector1;
import math.vector.Vector3;

import java.util.Random;
import java.util.function.Function;


public class RandomUtills {
    private Random random = new Random();

    private WindowInfo windowInfo;

    public RandomUtills(WindowInfo windowInfo) {
        this.windowInfo = windowInfo;
    }

    public Vector3 getRandomLocation(Function<Vector3, Boolean> untilPredicate) {
        Vector3 v;
        int upper = Constants.upper;
        do {
            System.out.println("rand-LOCATION/");
            v = getRandomLocationVector();
            upper -= 1;
        } while (untilPredicate.apply(v) && upper > 0);
        return v;
    }

    public Double getRandomDirection(Function<Double, Boolean> untilPredicate) {
        double v;
        int upper = Constants.upper;
        do {
            v = random.nextInt(360);
            System.out.println("rand-DIRECTION");
            upper -= 1;
        } while (untilPredicate.apply(v) && upper > 0);
        return v;
    }

    public Vector3 getRandomLocationVector() {
        //double x=random.nextInt((int)sizeX-20),y=random.nextInt((int) sizeY-20),z=random.nextInt((int)sizeZ-20);
        double x = random.nextInt((int) windowInfo.getWindowY() - 20), y = random.nextInt((int) windowInfo.getWindowY() - 20);
        return new Vector3(x, y, 5);
    }
}
