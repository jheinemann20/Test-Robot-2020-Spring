/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HerderSub extends SubsystemBase {

  private WPI_TalonSRX herderMotor;
  private WPI_TalonSRX herderArmMotor;

  /**
   * Creates a new HerderSub.
   */
  public HerderSub() {
    herderMotor = new WPI_TalonSRX(Constants.HERDER_MOTOR);
    herderArmMotor = new WPI_TalonSRX(Constants.HERDER_ARM_MOTOR);
  }

  public void herd() {
    herderMotor.set(1);
  }

  public void stopHerd() {
    herderMotor.set(0);
  }

  public void lowerArm() {
    herderArmMotor.set(-0.5);
  }

  public void raiseArm() {
    herderArmMotor.set(0.5);
  }

  public void stopArm() {
    herderArmMotor.set(0);
  }

}
