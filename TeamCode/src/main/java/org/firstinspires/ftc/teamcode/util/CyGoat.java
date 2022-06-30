package org.firstinspires.ftc.teamcode.util;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Hardware Map configuration class.
 */
public class CyGoat {

    public DcMotor front_left = null;
    public DcMotor front_right = null;
    public DcMotor back_left = null;
    public DcMotor back_right = null;

    public DcMotor intake = null;
    public DcMotor wheelTurn = null;

    public DcMotor extendMotor = null;
    public DcMotor slideTurnMotor = null;
    public Servo boxTurn = null;

    public BNO055IMU imu;

    HardwareMap hwMap = null;

    public CyGoat() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap hwMap) {
        // DRIVE (ON CONTROL HUB)
        front_left = hwMap.dcMotor.get("front_left");
        front_right = hwMap.dcMotor.get("front_right");
        back_left = hwMap.dcMotor.get("back_left");
        back_right = hwMap.dcMotor.get("back_right");


        front_left.setDirection(DcMotor.Direction.REVERSE);
        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_left.setDirection(DcMotor.Direction.FORWARD);
        back_right.setDirection(DcMotor.Direction.REVERSE);

        front_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        back_right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        front_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        front_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_left.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        back_right.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Intake

        intake = hwMap.dcMotor.get("intake");

        intake.setDirection(DcMotor.Direction.FORWARD);
        intake.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        intake.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Ducky

        wheelTurn = hwMap.dcMotor.get("wheelTurn");

        wheelTurn.setDirection(DcMotor.Direction.FORWARD);
        wheelTurn.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        wheelTurn.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        wheelTurn.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // Linear Slide (On Extension Hub)
        extendMotor = hwMap.dcMotor.get("extendMotor");
        slideTurnMotor = hwMap.dcMotor.get("slideTurnMotor");
        boxTurn = hwMap.servo.get("boxTurn");


        extendMotor.setDirection(DcMotor.Direction.FORWARD);
        slideTurnMotor.setDirection(DcMotor.Direction.FORWARD);

        extendMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        slideTurnMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        extendMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slideTurnMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        extendMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        slideTurnMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        // IMU
        imu = hwMap.get(BNO055IMU.class, "imu");
    }

    public void imu() {
        /* IMU STUFF */
        BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();

        parameters.mode = BNO055IMU.SensorMode.IMU;
        parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
        parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
        parameters.calibrationDataFile = "BNO055IMUCalibration.json"; // see the calibration sample opmode
        parameters.loggingTag = "IMU";
        parameters.accelerationIntegrationAlgorithm = new JustLoggingAccelerationIntegrator();
        parameters.loggingEnabled = true;

        imu.initialize(parameters);
    }
}