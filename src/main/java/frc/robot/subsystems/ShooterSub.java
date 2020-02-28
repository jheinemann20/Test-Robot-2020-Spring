/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {

  // private CANSparkMax shooterMotor;
  // @JsonIgnore // encoder needed
  // private CANEncoder shooterEncoder;
  // private CANPIDController shooterPID;

  // private double kP, kI, kD, kIz, kFF, rpm;

  private WPI_VictorSPX shooterMotor;

  /**
   * Creates a new ShooterSub.
   */
  public ShooterSub() {
    shooterMotor = new WPI_VictorSPX(Constants.SHOOTER_MOTOR);
    shooterMotor.configClosedloopRamp(2);
    // shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR, MotorType.kBrushless);
    // shooterEncoder = new CANEncoder(shooterMotor);
    // shooterPID = shooterMotor.getPIDController();

    // kP = 5e-5; 
    // kI = 1e-6;
    // kD = 0; 
    // kIz = 0; 
    // kFF = 0;
    // rpm = 2000; // 5700 max

    // shooterPID.setP(kP);
    // shooterPID.setI(kI);
    // shooterPID.setD(kD);
    // shooterPID.setIZone(kIz);
    // shooterPID.setFF(kFF);
    // shooterPID.setOutputRange(-1, 1);

    // shooterMotor.setClosedLoopRampRate(0.5);
  }

  public void startShoot() {
    shooterMotor.set(1);
    // shooterPID.setReference(rpm, ControlType.kVelocity);
  }

  public void stopShoot() {
    shooterMotor.set(0);
  }
}
