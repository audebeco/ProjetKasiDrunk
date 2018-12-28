package com.example.caudeber.newyearapp.modules;

import com.example.caudeber.newyearapp.MainActivity;

import java.util.List;

public class Roue extends Thread {

    public interface WheelListener {
        void newImage(int img);
    }



    private static int[] imgs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public int currentIndex;
    private WheelListener wheelListener;
    private long frameDuration;
    private long startIn;
    private boolean isStarted;
    private int size;

    public Roue(WheelListener wheelListener, long frameDuration, long startIn, int size) {
        this.wheelListener = wheelListener;
        this.frameDuration = frameDuration;
        this.startIn = startIn;
        currentIndex = 0;
        isStarted = true;
        this.size = size;
    }

    public void nextImg() {
        currentIndex++;

        if (currentIndex == size) {
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