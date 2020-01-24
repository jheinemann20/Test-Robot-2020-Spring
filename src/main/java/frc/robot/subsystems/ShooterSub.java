/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSub extends SubsystemBase {

  private CANSparkMax shooterMotor;
  private CANEncoder shooterEncoder;

  /**
   * Creates a new ShooterSub.
   */
  public ShooterSub() {
    shooterMotor = new CANSparkMax(Constants.SHOOTER_MOTOR, MotorType.kBrushless);
    shooterEncoder = new CANEncoder(shooterMotor);

    shooterMotor.setOpenLoopRampRate(0.5);
    // shooterMotor.setSmartCurrentLimit(stallLimit, freeLimit, limitRPM); TODO: figure this out
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void fire() {
    shooterMotor.set(1);
  }
}
