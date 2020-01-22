package tests.databaseSpec;

import database.Database;
import etc.WindowInfo;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import logging.Logger;
import math.vector.Vector3;
import object.AbstractObject;
import tests.etc.EntityInitException;
import tests.etc.Testable;

/**
 * This is the Database object tests
 * @see Database
 */
public class DatabaseSpec implements Testable<Database> {
    Logger logger;

    public DatabaseSpec(Logger logger) {
        this.logger = logger;
    }

    /**
     * Generate a new entity
     * @return a newrly created entity
     * @throws EntityInitException in case of any error
     */
    @Override
    public Database genEntity() throws EntityInitException {
        try{
            WindowInfo def=WindowInfo.genDefault();
            ResourceLoader loader= ResourceLoader.siglentonInitializer();
            AbstractGuiFactory guiFactory=new GuiFactory(def,loader);
            AbstractEngineFactory engineFactory=guiFactory.getEngineFactory();
            return engineFactory.getDatabase();
        }catch (Exception e){
            throw new EntityInitException(e);
        }
    }

    /**
     * Run all tests regarding this entity
     * @return true if all tests has been succeed;
     */
    @Override
    public boolean test() {
        return genDefaultDatabaseSpec()&&
                addDroneSpec()&&
                addTurretSpec()&&
                newBulletSpec()&&
                deleteObjectSpec();
    }

    /**
     * Tests the ability to generate a default database
     * used in default arena
     * @return true if the test succeeds
     */
    public boolean genDefaultDatabaseSpec(){
        try{
            Database d = genEntity();
            d.genDefaultDatabase();
            return d.asList().size()==3;
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }

    }

    /**
     * Tests the ability of database in adding a drone
     * @return true if the test succeeds
     */
    public boolean addDroneSpec() {
        try {
            Database d = genEntity();
            d.genDefaultDatabase();
            d.addDrone();
            return d.asList().size() == 3 + 1;
        } catch (EntityInitException e) {
            logger.error(e);
            return false;
        }
    }
    /**
     * Tests the ability of database in adding a turret
     * @return true if the test succeeds
     */
    public boolean addTurretSpec() {
        try {
            Database d = genEntity();
            d.genDefaultDatabase();
            d.addTurret();
            return d.asList().size() == 3 + 1;
        } catch (EntityInitException e) {
            logger.error(e);
            return false;
        }
    }
    /**
     * Tests the ability of database in adding a bullet
     * @return true if the test succeeds
     */
    public boolean newBulletSpec() {
        try {
            Database d = genEntity();
            d.genDefaultDatabase();
            AbstractObject o = d.addDrone();
            AbstractObject b = d.newBullet(o,new Vector3(1,2,3));
            return d.asList().size() == 3 + 1 + 1;
        } catch (EntityInitException e) {
            logger.error(e);
            return false;
        }
    }
    /**
     * Tests the ability of database in deleting a object
     * @return true if the test succeeds
     */
    public boolean deleteObjectSpec() {
        try {
            Database d = genEntity();
            d.genDefaultDatabase();
            AbstractObject turr=d.addTurret();
            d.deleteObject(turr);
            return d.asList().size() == 3;
        } catch (EntityInitException e) {
            logger.error(e);
            return false;
        }
    }
}
