package com.example.caudeber.newyearapp.modules;

import com.example.caudeber.newyearapp.MainActivity;

public class Roue extends Thread {

    public interface WheelListener {
        void newImage(int img);
    }

    private static int[] imgs = {0, 1, 2};
    public int currentIndex;
    private WheelListener wheelListener;
    private long frameDuration;
    private long startIn;
    private boolean isStarted;

    public Roue(WheelListener wheelListener, long frameDuration, long startIn) {
        this.wheelListener = wheelListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;
    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == imgs.length) {
            currentIndex = 0;
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(startIn);
        } catch (InterruptedException e) {
        }

        while(isStarted) {
            try {
                Thread.sleep(frameDuration);
            } catch (InterruptedException e) {
            }

            nextImg();

            if (wheelListener != null) {
                wheelListener.newImage(imgs[currentIndex]);
            }
        }
    }

    public void stopWheel() {
        isStarted = false;
    }
}