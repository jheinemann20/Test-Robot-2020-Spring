/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HerderArmSub extends SubsystemBase {

  private WPI_VictorSPX herderArmMotor;

  /**
   * Creates a new HerderArmSub.
   */
  public HerderArmSub() {
    herderArmMotor = new WPI_VictorSPX(Constants.HERDER_ARM_MOTOR);
  }

  public void lowerArm() {
    herderArmMotor.set(0.75);
  }

  public void raiseArm() {
    herderArmMotor.set(-1);
  }

  public void stopArm() {
    herderArmMotor.set(0);
  }
}
