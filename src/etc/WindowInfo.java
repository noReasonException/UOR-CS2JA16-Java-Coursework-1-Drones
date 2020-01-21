package etc;

public class WindowInfo {
    private int cubeX, cubeY, cubeZ, windowX, windowY, windowZ;

    public WindowInfo(int cubeX, int cubeY, int cubeZ, int windowX, int windowY, int windowZ) {
        this.cubeX = cubeX;
        this.cubeY = cubeY;
        this.cubeZ = cubeZ;
        this.windowX = windowX;
        this.windowY = windowY;
        this.windowZ = windowZ;
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
}
