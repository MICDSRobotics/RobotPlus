package org.firstinspires.ftc.teamcode.robotplus.hardware;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.robotplus.robodata.EncoderValues;

/**
 * Created by BAbel on 4/11/2017.
 */

public class TankDrive extends Drivetrain implements EncoderValues {

    private MotorPair leftMotors;
    private MotorPair rightMotors;

    public TankDrive(){
        setMotorType(Motor.NEVERREST40);
    }

    public TankDrive(HardwareMap hardwareMap){
        leftMotors = new MotorPair(hardwareMap, "left front", "left back");
        rightMotors = new MotorPair(hardwareMap, "right front", "right back");

        setMotorType(Motor.NEVERREST40);
    }

    public MotorPair getLeftMotors() {
        return leftMotors;
    }

    public MotorPair getRightMotors() {
        return rightMotors;
    }

    public void setLeftMotors(MotorPair leftMotors) {
        this.leftMotors = leftMotors;
    }

    public void setRightMotors(MotorPair rightMotors) {
        this.rightMotors = rightMotors;
    }

    public void setTargetPosition(int position) {
        leftMotors.getMotor1().setTargetPosition(position);
        leftMotors.getMotor2().setTargetPosition(position);
        rightMotors.getMotor1().setTargetPosition(position);
        rightMotors.getMotor2().setTargetPosition(position);
    }

    /**
     * Rotates the robot dependent on degrees
     * @param degrees requested degrees
     */
    public void turnDegrees(int degrees) {
        switch (degrees) {
            case 90 : // turn 90 degrees
                this.getLeftMotors().getMotor1().setTargetPosition(FULL_ROTATION * 2);
                this.getLeftMotors().getMotor2().setTargetPosition(FULL_ROTATION * 2);
                break;
            default : break;
        }
    }

    @Override
    public void setPower(double power){
        rightMotors.setPowers(power);
        leftMotors.setPowers(power);
    }

    @Override
    public void setModes(DcMotor.RunMode mode){
        leftMotors.setModes(mode);
        rightMotors.setModes(mode);
    }

    @Override
    public void resetEncoders(){
        rightMotors.resetEncoders();
        leftMotors.resetEncoders();
    }

    @Override
    public void stopMoving(){
        leftMotors.setPowers(0);
        rightMotors.setPowers(0);
    }
}
