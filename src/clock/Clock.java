package clock;

import engines.AbstractEngine;
import logging.Logger;

import java.util.List;

public class Clock implements Runnable, Logger {
    private List<Thread> subscribers;
    private int frequency;
    private boolean stop=false;
    @Override
    public void run() {
        try{
            while (!stop){
                Thread.sleep((1/frequency)*1000);
                for (Thread any:subscribers){
                    any.start();
                }

            }
        }catch (InterruptedException e){
            warn("Clock Interrupted , Recovery");
        }
    }

    public Clock interrupt() {
        this.stop = false;
        return this;
    }

    public Clock(List<Thread> subscribers, int frequency) {
        this.subscribers = subscribers;
        this.frequency=frequency;
    }
}
