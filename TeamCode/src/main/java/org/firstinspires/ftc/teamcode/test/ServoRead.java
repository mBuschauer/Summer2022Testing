package org.firstinspires.ftc.teamcode.test;

import static java.lang.Math.round;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp(name = "2022 Servo Test")
public class ServoRead extends OpMode {
    private final ElapsedTime aDelay = new ElapsedTime();
    private final ElapsedTime xDelay = new ElapsedTime();
    private final ElapsedTime yDelay = new ElapsedTime();
    private final ElapsedTime waiter = new ElapsedTime();

    private Servo servo0 = null;

    private double holder = 0;
    private double increaseNum = 0.1;

    private final int waitTime = 1000;
    private int waitFactor = 1;
    private final ElapsedTime stickDelay = new ElapsedTime();

    @Override
    public void init() {
        servo0 = hardwareMap.servo.get("testServo0"); // Change "servo" to servo's name in hardware map
        xDelay.reset();
        aDelay.reset();
        yDelay.reset();
        waiter.reset();
        stickDelay.reset();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void loop() {
        telemetry.addLine("gamepad1.left_stick_y adds or subtracts from holder");
        telemetry.addLine("gamepad1.dpad_up and gamepad1.dpad_down make the increaseNum larger or smaller");
        telemetry.addData("Set To Position", holder);
        telemetry.addData("Change #", increaseNum);
        if (waiter.seconds() > 3) {
            if (yDelay.milliseconds() > 250 && gamepad1.dpad_up) {
                increaseNum = increaseNum * 10;
            }
            else if (aDelay.milliseconds() > 250 && gamepad1.dpad_down) {
                increaseNum = increaseNum / 10;
            }

            if (gamepad1.left_stick_y != 0 && stickDelay.milliseconds() > round((float) waitTime/ (float) waitFactor)) {
                if (gamepad1.left_stick_y > 0) {
                    holder = holder + increaseNum;
                } else {
                    holder = holder - increaseNum;
                }
                waitFactor++;
                if (waitFactor > 5){
                    waitFactor = 5;
                }
            }
            if (gamepad1.left_stick_y == 0) {
                waitFactor = 1;
            }

            if (holder > 1) {
                holder = 1;
            } else if (holder < 0) {
                holder = 0;
            }
            if (increaseNum > 1) {
                increaseNum = 1;
            } else if (increaseNum < 0) {
                increaseNum = 0;
            }

            if (xDelay.milliseconds() > 100 && gamepad1.x) {
                holder = 0;
                increaseNum = 0.1;
                servo0.setPosition(holder);
            }
        } else {
            double waitTime = 3 - waiter.seconds();
            telemetry.addLine(String.format("Wait %f seconds.", (float) waitTime));
        }
        telemetry.update();
    }
}
