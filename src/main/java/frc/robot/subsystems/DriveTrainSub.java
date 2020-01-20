/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * An example subsystem. You can replace me with your own Subsystem.
 */
public class DriveTrainSub extends SubsystemBase {
  private CANSparkMax frontLeft, frontRight, rearLeft, rearRight;
  @JsonIgnore
  private CANEncoder frontLeftEncoder, frontRightEncoder, backLeftEncoder, backRightEncoder;
  private MecanumDrive mecDrive;
  private DifferentialDrive arcDrive;
  private SpeedControllerGroup leftSide;
  private SpeedControllerGroup rightSide;
  private DoubleSolenoid driveSol;

  private double deadband;

  public DriveTrainSub() {
    frontLeft = new CANSparkMax(Constants.FRONT_LEFT_MOTOR, MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR, MotorType.kBrushless);
    rearLeft = new CANSparkMax(Constants.REAR_LEFT_MOTOR, MotorType.kBrushless);
    rearRight = new CANSparkMax(Constants.REAR_RIGHT_MOTOR, MotorType.kBrushless);

    frontLeftEncoder = frontLeft.getEncoder();
    frontRightEncoder = frontRight.getEncoder();
    backLeftEncoder = rearLeft.getEncoder();
    backRightEncoder = rearRight.getEncoder();

    mecDrive = new MecanumDrive(frontLeft, rearLeft, frontRight, rearRight);
    mecDrive.setSafetyEnabled(false);

    leftSide = new SpeedControllerGroup(frontLeft, rearLeft);
    rightSide = new SpeedControllerGroup(frontRight, rearRight);
    arcDrive = new DifferentialDrive(leftSide, rightSide);

    frontLeft.setOpenLoopRampRate(0);
    frontRight.setOpenLoopRampRate(0);
    rearLeft.setOpenLoopRampRate(0);
    rearRight.setOpenLoopRampRate(0);

    frontLeft.setIdleMode(IdleMode.kCoast);
    frontRight.setIdleMode(IdleMode.kCoast);
    rearLeft.setIdleMode(IdleMode.kCoast);
    rearRight.setIdleMode(IdleMode.kCoast);

    deadband = Constants.DRIVESTICK_DEADBAND;

    driveSol = new DoubleSolenoid(Constants.SHIFT_FORWARD_SOL, Constants.SHIFT_REVERSE_SOL);
  }

  public void mecanumDrive(double ySpeed, double xSpeed, double zRotation) {
    driveSol.set(DoubleSolenoid.Value.kForward);
    mecDrive.driveCartesian(-ySpeed, xSpeed, -zRotation);

  }

  public void arcadeDrive(double xSpeed, double zRotation) {
    driveSol.set(DoubleSolenoid.Value.kReverse);
    arcDrive.arcadeDrive(xSpeed, zRotation);
  }

  public double getCurrent(String name) {
    if (name.equals("FR"))
      return frontRight.getOutputCurrent();
    else if (name.equals("FL"))
      return frontLeft.getOutputCurrent();
    else if (name.equals("RR"))
      return rearRight.getOutputCurrent();
    else if (name.equals("RL"))
      return rearLeft.getOutputCurrent();
    else
      return 0;
  }

  /**
   * Adds deadband to a given axis (for driving only)
   */
  public double addDeadband(double x) {
    if (x >= deadband)
      return x;
    else if (x <= -deadband)
      return x;
    else
      return 0;
  }
}
