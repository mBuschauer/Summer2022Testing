package org.firstinspires.ftc.teamcode.teleop;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.util.CyGoat;
import org.firstinspires.ftc.teamcode.util.controllerPlus;

@TeleOp(name = "Hermoine Blue")
public class Hermoine extends LinearOpMode {
    private final CyGoat goat = new CyGoat();
    private final controllerPlus cOne = new controllerPlus();
    private final controllerPlus cTwo = new controllerPlus();

    @Override
    public void runOpMode() throws InterruptedException {
        goat.init(hardwareMap);
        goat.imu();

        telemetry.addLine("Start");
        telemetry.update();

        waitForStart();
        while (opModeIsActive()) {
            cOne.functionPlus(gamepad1.x, gamepad1.y, gamepad1.a, gamepad1.b);
            cTwo.functionPlus(gamepad2.x, gamepad2.y, gamepad2.a, gamepad2.b);
            drive();
            telemetry.update();
        }
    }

    // Drive Code
    private void drive() {
        double y = -gamepad1.left_stick_y / (gamepad1.right_trigger + 1); // Remember, this is reversed!
        double x = gamepad1.left_stick_x / (gamepad1.right_trigger + 1);
        double rx = gamepad1.right_stick_x / (gamepad1.right_trigger + 1);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double frontRightPower = (y - x - rx) / denominator;
        double backRightPower = (y + x - rx) / denominator;

        goat.front_left.setPower(frontLeftPower);
        goat.back_left.setPower(backLeftPower);
        goat.front_right.setPower(frontRightPower);
        goat.back_right.setPower(backRightPower);
    }

}
