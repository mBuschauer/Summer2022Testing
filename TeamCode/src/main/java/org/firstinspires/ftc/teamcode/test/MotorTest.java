package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name = "2022 Motor Test")
public class MotorTest extends OpMode {

    double[] lastPositions = new double[2];
    private DcMotor motor0 = null;
    private DcMotor motor1 = null;

    // Code runs when init is pressed
    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("back_left");
        motor1 = hardwareMap.dcMotor.get("back_right");

        motor0.setDirection(DcMotorSimple.Direction.FORWARD);
        motor0.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        motor1.setDirection(DcMotorSimple.Direction.FORWARD);
        motor1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        lastPositions[0] = motor0.getCurrentPosition();
        lastPositions[1] = motor1.getCurrentPosition();
    }

    @Override
    public void loop() {
        telemetry.addData("gamepad1.left_stick_x", gamepad1.left_stick_x);
        if (gamepad1.left_stick_x != 0) {
            motor0.setPower(gamepad1.left_stick_x);
        } else {
            motor0.setPower(0);
        }

        if (gamepad1.right_stick_x != 0) {
            motor1.setPower(gamepad1.right_stick_x);
        } else {
            motor1.setPower(0);
        }
        telemetry.addData("Motor 0 Change", motor0.getCurrentPosition() - lastPositions[0]);
        telemetry.addData("Motor 1 Change", motor1.getCurrentPosition() - lastPositions[1]);


        lastPositions[0] = motor0.getCurrentPosition();
        lastPositions[1] = motor1.getCurrentPosition();

        telemetry.update();
    }

}

