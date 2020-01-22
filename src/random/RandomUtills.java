package random;

import etc.Constants;
import etc.WindowInfo;
import math.vector.Vector1;
import math.vector.Vector3;

import java.io.Serializable;
import java.util.Random;
import java.util.function.Function;


/***
 * Useful class for generating randomised locations , direction etc
 */
public class RandomUtills  implements Serializable {
    private Random random = new Random();

    private WindowInfo windowInfo;

    public RandomUtills(WindowInfo windowInfo) {
        this.windowInfo = windowInfo;
    }

    /***
     * generates a random location , tries Constant.upper times before termninates for preventing
     * @see Constants#upper
     * @param untilPredicate the condition that flags the end of the computation
     * @return a new Vector
     */
    public Vector3 getRandomLocation(Function<Vector3, Boolean> untilPredicate) {
        Vector3 v;
        int upper = Constants.upper;
        do {
            v = getRandomLocationVector();
            upper -= 1;
        } while (untilPredicate.apply(v) && upper > 0);
        return v;
    }

    /***
     * generates a random direction , tries Constant.upper times before termninates for preventing
     * @see Constants#upper
     * @param untilPredicate the condition that flags the end of the computation
     * @return a new Vector
     */
    public Double getRandomDirection(Function<Double, Boolean> untilPredicate) {
        double v;
        int upper = Constants.upper;
        do {
            v = Math.abs(random.nextInt(360));
            upper -= 1;
        } while (untilPredicate.apply(v) && upper > 0);
        return v;
    }

    /**
     *
     * @return a randomised Location vector
     */
    private Vector3 getRandomLocationVector() {
        //double x=random.nextInt((int)sizeX-20),y=random.nextInt((int) sizeY-20),z=random.nextInt((int)sizeZ-20);
        double x = Math.abs(random.nextInt((int) windowInfo.getWindowY() - 200)+100), y = Math.abs(random.nextInt((int) windowInfo.getWindowY() - 200)+100),z=Math.abs(random.nextInt(windowInfo.getCubeZ()-1)+1);
        return new Vector3(x, y, 2);
    }
}
