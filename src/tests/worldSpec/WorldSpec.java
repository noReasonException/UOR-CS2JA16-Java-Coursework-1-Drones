package tests.worldSpec;

import database.Database;
import etc.WindowInfo;
import factories.GuiFactory;
import factories.ResourceLoader;
import factories.specification.AbstractEngineFactory;
import factories.specification.AbstractGuiFactory;
import logging.Logger;
import math.vector.Vector;
import math.vector.Vector3;
import object.AbstractObject;
import random.RandomUtills;
import tests.etc.EntityInitException;
import tests.etc.Testable;
import world.World;

public class WorldSpec implements Testable<World> {

    private Logger logger;
    private Database database;
    private RandomUtills u;

    public WorldSpec(Logger logger) {
        this.logger = logger;
    }

    @Override
    public World genEntity() throws EntityInitException {
        try{
            WindowInfo def=WindowInfo.genDefault();
            ResourceLoader loader= ResourceLoader.siglentonInitializer();
            AbstractGuiFactory guiFactory=new GuiFactory(def,loader);
            AbstractEngineFactory engineFactory=guiFactory.getEngineFactory();
            this.database=engineFactory.getDatabase();
            this.u=engineFactory.getRandomUtills();
            return engineFactory.getWorldMap();
        }catch (Exception e){
            throw new EntityInitException(e);
        }
    }

    @Override
    public boolean test() {
        return toWorldCoordinatesUntouched3rdDimensionSpec()&&
                toWorldCoordinatesProperDivisionSpec()&&
                collisionWithAnySpec()&&
                collisionWithAnyNonCollisionSpec()&&
                collisionSpec()&&
                collisionNonCollisionSpec()&&
                collisionWithOtherDroneSpec()&&
                collisionWithWallSpec()&&
                nonCollisionWithWallSpec()&&
                eraseObjectSpec()&&
                updatePositionSpec();
    }

    public boolean toWorldCoordinatesUntouched3rdDimensionSpec(){
        try{
            World d = genEntity();
            Vector3 location = new Vector3(120,320,3);
            Vector3 result=d.toWorldCoordinates(location);
            return result.getCore().getElement(2)==3;
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean toWorldCoordinatesProperDivisionSpec(){
        try{
            World d = genEntity();
            Vector3 location = new Vector3(120,120,3);
            Vector3 result=d.toWorldCoordinates(location);
            return result.getCore().getElement(0).intValue()==(120/WindowInfo.genDefault().getCubeX()+1)&&
                    result.getCore().getElement(1).intValue()==(120/WindowInfo.genDefault().getCubeY()+1);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionWithAnySpec(){
        try{
            World d = genEntity();
            AbstractObject obj =database.addDrone();
            Vector3 collisionLocation = obj.getPosition();
            return d.collisionWithAny(collisionLocation);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionSpec(){
        try{
            World d = genEntity();
            AbstractObject obj =database.addDrone();
            Vector3 collisionLocation = obj.getPosition();
            return !d.collision(obj,collisionLocation);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionWithAnyNonCollisionSpec(){
        try{
            World d = genEntity();
            AbstractObject obj =database.addDrone();
            Vector3 nonCollisionLocation = u.getRandomLocation(vector3 -> !(vector3.getCore().equals(obj.getPosition().getCore())));
            return !d.collisionWithAny(nonCollisionLocation);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionNonCollisionSpec(){
        try{
            World d = genEntity();
            AbstractObject obj =database.addDrone();
            Vector3 nonCollisionLocation = u.getRandomLocation(vector3 -> !(vector3.getCore().equals(obj.getPosition().getCore())));
            return !d.collision(obj,nonCollisionLocation);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionWithOtherDroneSpec(){
        try{
            World d = genEntity();
            AbstractObject obj =database.addDrone();
            AbstractObject obj2 =database.addDrone();
            return d.collision(obj,obj2.getPosition());
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean collisionWithWallSpec(){
        try{
            World d = genEntity();
            Vector3 v = new Vector3(2000,3000,4000);
            return d.collisionWithWall(v);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean nonCollisionWithWallSpec(){
        try{
            World d = genEntity();
            Vector3 v = new Vector3(50,50,2);
            return !d.collisionWithWall(v);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean eraseObjectSpec(){
        try{
            World d = genEntity();
            database.deleteObject(database.addDrone());
            return d.getData().size()==0;
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }
    public boolean updatePositionSpec(){
        try{
            World d = genEntity();
            AbstractObject o =database.addDrone();
            Vector3 locationAfter=o.getPosition().add(new Vector3(100,100,100));
            d.updatePosition(o,locationAfter);
            return d.collisionWithAny(locationAfter);
        }catch (EntityInitException e){
            logger.error(e);
            return false;
        }
    }

}
