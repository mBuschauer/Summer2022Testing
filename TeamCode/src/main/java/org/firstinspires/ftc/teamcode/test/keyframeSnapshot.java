package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.util.CyGoat;

@TeleOp(name = "Keyframe Snapshot", group = "test")
public class keyframeSnapshot extends OpMode {
    private final CyGoat goat = new CyGoat();
    private double boxTurn = 0.384;

    @Override
    public void init() {
        goat.init(hardwareMap);
        goat.imu();
    }

    @Override
    public void loop() {
        goat.slideTurnMotor.setPower(gamepad1.left_stick_x / 8);

        if (gamepad1.a) {
            int currentArmPos = goat.slideTurnMotor.getCurrentPosition();
            if (currentArmPos >= 717) {
                boxTurn = .91;
            } else if (currentArmPos >= 594) {
                boxTurn = .788;
            } else if (currentArmPos >= 424) {
                boxTurn = .66;
            } else if (currentArmPos >= 369) {
                boxTurn = .557;
            } else if (currentArmPos >= 120) {
                boxTurn = .52;
            } else if (currentArmPos >= 110) {
                boxTurn = 0.47;
            } else if (currentArmPos >= 80) {
                boxTurn = .45;
            } else if (currentArmPos >= 65) {
                boxTurn = .38;
            }
        } else {
            boxTurn = boxTurn + gamepad1.right_stick_x / 1000;
        }
        if (boxTurn > 1) {
            boxTurn = 1;
        } else if (boxTurn < 0) {
            boxTurn = 0;
        }
        goat.boxTurn.setPosition(boxTurn);
        telemetry.addData("slideTurn Encoder Pos", goat.slideTurnMotor.getCurrentPosition());
        telemetry.addData("boxTurn Pos", goat.boxTurn.getPosition());
        telemetry.update();
    }


}
