package gui.threads;

import gui.InformationPanel;
import javafx.animation.AnimationTimer;

public class GuiThread extends AnimationTimer {
    private InformationPanel panel;

    public GuiThread(InformationPanel panel) {
        this.panel = panel;
    }

    /***
     * the GuiThread animationTimer handler
     * in each frame is called and updates the information panel
     * (but not strictly in every frame , in order to avoid sudden frame drops)
     * @param l the milliseconds
     */
    @Override
    public void handle(long l) {
       if(l%50==0){
            panel.update();
       }

    }
}
