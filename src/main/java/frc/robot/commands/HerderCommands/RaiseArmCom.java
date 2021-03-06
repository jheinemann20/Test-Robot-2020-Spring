/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.HerderCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderArmSub;

public class RaiseArmCom extends CommandBase {
  
  private HerderArmSub herderArmSub;

  /**
   * Creates a new RaiseArmCom.
   */
  public RaiseArmCom(HerderArmSub herderArmSub) {
    addRequirements(herderArmSub);
    this.herderArmSub = herderArmSub;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    herderArmSub.raiseArm();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    herderArmSub.stopArm();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
