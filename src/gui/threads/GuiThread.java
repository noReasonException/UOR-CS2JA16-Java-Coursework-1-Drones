package gui.threads;

import gui.InformationPanel;
import javafx.animation.AnimationTimer;

public class GuiThread extends AnimationTimer {
    private InformationPanel panel;

    public GuiThread(InformationPanel panel) {
        this.panel = panel;
    }

    @Override
    public void handle(long l) {
       if(l%50==0){
            panel.update();
       }

    }
}
