package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

@Disabled
@TeleOp(name = "2021 Servo Test")
public class ServoTest extends OpMode {

    /**
     * Stick sensitivity.
     */
    private static final int SENSITIVITY = 1000;
    private final ElapsedTime aDelay = new ElapsedTime();
    int pos = 0;
    /**
     * Servo to test.
     */
    private Servo servo0 = null;
    private Servo servo1 = null;
    private Servo servo2 = null;
    private Servo servo3 = null;
    private Servo servo4 = null;
    private Servo servo5 = null;

    @Override
    public void init() {
        servo0 = hardwareMap.servo.get("testServo0"); // Change "servo" to servo's name in hardware map
        servo1 = hardwareMap.servo.get("testServo1"); // Change "servo" to servo's name in hardware map
        servo2 = hardwareMap.servo.get("testServo2"); // Change "servo" to servo's name in hardware map
        servo3 = hardwareMap.servo.get("testServo3"); // Change "servo" to servo's name in hardware map
        servo4 = hardwareMap.servo.get("testServo4"); // Change "servo" to servo's name in hardware map
        servo5 = hardwareMap.servo.get("testServo5"); // Change "servo" to servo's name in hardware map

    }

    @Override
    public void loop() {
        telemetry.addData("Y Stick", gamepad1.left_stick_y);
        telemetry.addData("Pos", pos);

        if (gamepad1.a && aDelay.seconds() > 1) {
            if (pos == 6) {
                pos = 0;
            } else {
                pos++;
            }
            aDelay.reset();
        }


        if (pos == 0) {
            if (gamepad1.left_stick_y != 0) {
                servo0.setPosition(servo0.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));
                telemetry.addData("Servo Position 0", servo0.getPosition());
            }

        } else if (pos == 1) {
            if (gamepad1.left_stick_y != 0) {
                servo1.setPosition(servo1.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));
            }
            telemetry.addData("Servo Position 1", servo1.getPosition());


        } else if (pos == 2) {
            if (gamepad1.left_stick_y != 0) {
                servo2.setPosition(servo2.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));
            }
            telemetry.addData("Servo Position 2", servo2.getPosition());

        } else if (pos == 3) {
            if (gamepad1.left_stick_y != 0) {
                servo3.setPosition(servo3.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));
            }
            telemetry.addData("Servo Position 3", servo3.getPosition());

        } else if (pos == 4) {
            if (gamepad1.left_stick_y != 0) {
                servo4.setPosition(servo4.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));

            }
            telemetry.addData("Servo Position 4", servo4.getPosition());

        } else if (pos == 5) {
            if (gamepad1.left_stick_y != 0) {
                servo5.setPosition(servo5.getPosition() + (-gamepad1.left_stick_y / SENSITIVITY));

            }
            telemetry.addData("Servo Position 5", servo5.getPosition());

        }
        telemetry.update();
    }

}