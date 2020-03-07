/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LoaderSub extends SubsystemBase {

  private DoubleSolenoid loaderSol;

  /**
   * Creates a new LoaderSub.
   */
  public LoaderSub() {
    loaderSol = new DoubleSolenoid(Constants.SHOOTER_LOAD_SOL[0], Constants.SHOOTER_LOAD_SOL[1]);
    loaderSol.set(Value.kForward);
  }

  public void load() {
    loaderSol.set(Value.kReverse);
  }

  public void stopLoad() {
    loaderSol.set(Value.kForward);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
