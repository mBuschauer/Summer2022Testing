package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.robotcore.util.ElapsedTime;

public class controllerPlus {
    private final ElapsedTime init = new ElapsedTime();
    private final int memoryLength = 20;
    private final ElapsedTime xHold = new ElapsedTime();
    private final ElapsedTime yHold = new ElapsedTime();
    private final ElapsedTime aHold = new ElapsedTime();
    private final ElapsedTime bHold = new ElapsedTime();
    private final double[] xPresses = new double[memoryLength];
    private int xPressCounter = 0;
    private final double[] yPresses = new double[memoryLength];
    private int yPressCounter = 0;
    private final double[] aPresses = new double[memoryLength];
    private int aPressCounter = 0;
    private final double[] bPresses = new double[memoryLength];
    private int bPressCounter = 0;
    private boolean lastX = false;
    private boolean lastY = false;
    private boolean lastA = false;
    private boolean lastB = false;

    public void functionPlus(boolean xVal, boolean yVal, boolean aVal, boolean bVal) {
        // for hold function
        if (!xVal) {
            xHold.reset();
        }
        if (!yVal) {
            yHold.reset();
        }
        if (!aVal) {
            aHold.reset();
        }
        if (!bVal) {
            bHold.reset();
        }

        // for clicks/time function
        if (lastX && !xVal) {
            xPresses[xPressCounter % memoryLength] = init.milliseconds();
            xPressCounter++;
        }
        if (lastY && !yVal) {
            yPresses[yPressCounter % memoryLength] = init.milliseconds();
            yPressCounter++;
        }
        if (lastA && !aVal) {
            aPresses[aPressCounter % memoryLength] = init.milliseconds();
            aPressCounter++;
        }
        if (lastB && !bVal) {
            bPresses[bPressCounter % memoryLength] = init.milliseconds();
            bPressCounter++;
        }


        // keep on bottom
        lastX = xVal;
        lastY = yVal;
        lastA = aVal;
        lastB = bVal;
    }

    // gets length of time a button has been held
    public ElapsedTime getXHold() {
        return xHold;
    }
    public ElapsedTime getYHold() {
        return yHold;
    }
    public ElapsedTime getAHold() {
        return aHold;
    }
    public ElapsedTime getBHold() {
        return bHold;
    }

    // given an input of milliseconds, it return the number of clicks in the last x milliseconds
    public int XClicks(int milliseconds) {
        int xCounter = 0;
        for (int i = 0; i < memoryLength; i++){
            if (xPresses[i] >= init.milliseconds() - milliseconds){
                xCounter++;
            }
        }
        return xCounter;
    }
    public int YClicks(int milliseconds) {
        int yCounter = 0;
        for (int i = 0; i < memoryLength; i++){
            if (yPresses[i] >= init.milliseconds() - milliseconds){
                yCounter++;
            }
        }
        return yCounter;    }
    public int AClicks(int milliseconds) {
        int aCounter = 0;
        for (int i = 0; i < memoryLength; i++){
            if (aPresses[i] >= init.milliseconds() - milliseconds){
                aCounter++;
            }
        }
        return aCounter;    }
    public int BClicks(int milliseconds) {
        int bCounter = 0;
        for (int i = 0; i < memoryLength; i++){
            if (bPresses[i] >= init.milliseconds() - milliseconds){
                bCounter++;
            }
        }
        return bCounter;    }
}
