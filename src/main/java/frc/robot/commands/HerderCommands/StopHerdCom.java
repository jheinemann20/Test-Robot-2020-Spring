/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.HerderCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.HerderSub;

public class StopHerdCom extends CommandBase {
  
  private HerderSub herderSub;

  /**
   * Creates a new StopHerdCom.
   */
  public StopHerdCom(HerderSub herderSub) {
    addRequirements(herderSub);
    this.herderSub = herderSub;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    herderSub.stopHerd();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}