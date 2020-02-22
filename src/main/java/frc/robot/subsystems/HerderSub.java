/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HerderSub extends SubsystemBase {

  private WPI_VictorSPX herderMotor;
  

  /**
   * Creates a new HerderSub.
   */
  public HerderSub() {
    herderMotor = new WPI_VictorSPX(Constants.HERDER_MOTOR);
    herderMotor.configClosedloopRamp(2);
  }

  public void herd() {
    herderMotor.set(-0.65);
  }

  public void stopHerd() {
    herderMotor.set(0);
  }

}
