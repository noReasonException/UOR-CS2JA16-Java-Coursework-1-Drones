package main;
import logging.DefaultLogger;
import logging.Logger;
import tests.databaseSpec.DatabaseSpec;
import tests.etc.Testable;
import tests.mathSpec.VectorCoreUtilsSpec;
import tests.mathSpec.vector.Vector1Spec;
import tests.mathSpec.vector.Vector2Spec;
import tests.mathSpec.vector.Vector3Spec;
import tests.worldSpec.WorldSpec;

import java.util.ArrayList;

/**
 * The type Tests main.
 */
public class TestsMain {
    /**
     * The constant components.
     */
    public static ArrayList<Testable> components=new ArrayList<>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        Logger logger=new DefaultLogger();
        components.add(new DatabaseSpec(logger));
        components.add(new VectorCoreUtilsSpec(logger));
        components.add(new Vector1Spec(logger));
        components.add(new Vector2Spec(logger));
        components.add(new Vector3Spec(logger));
        components.add(new WorldSpec(logger));

        if(components.stream().map(Testable::test).reduce(true,(a,b)->{return a&&b;})){
            logger.info("All tests are passed");
        }else{
            logger.info("Some tests failed");
        }
    }

}
