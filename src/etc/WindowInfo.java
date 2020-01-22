package etc;


import java.io.Serializable;

/**
 * This class provides useful information about the screen and the world size(watch out , there is a difference)
 *
 */
public class WindowInfo implements Serializable {
    private int cubeX, cubeY, cubeZ, windowX, windowY, windowZ;

    public WindowInfo(int cubeX, int cubeY, int windowX, int windowY) {
        this.cubeX = cubeX;
        this.cubeY = cubeY;
        this.cubeZ = Constants.cubeZ;
        this.windowX = windowX;
        this.windowY = windowY;
    }

    public int getCubeX() {
        return cubeX;
    }

    public void setCubeX(int cubeX) {
        this.cubeX = cubeX;
    }

    public int getCubeY() {
        return cubeY;
    }

    public void setCubeY(int cubeY) {
        this.cubeY = cubeY;
    }

    public int getCubeZ() {
        return cubeZ;
    }

    public void setCubeZ(int cubeZ) {
        this.cubeZ = cubeZ;
    }

    public int getWindowX() {
        return windowX;
    }

    public void setWindowX(int windowX) {
        this.windowX = windowX;
    }

    public int getWindowY() {
        return windowY;
    }

    public void setWindowY(int windowY) {
        this.windowY = windowY;
    }

    public static WindowInfo genDefault(){
        return  new WindowInfo(50, 50, 500, 500);
    }
}
