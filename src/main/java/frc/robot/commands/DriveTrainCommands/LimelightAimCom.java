/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.DriveTrainCommands;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSub;

public class LimelightAimCom extends CommandBase {

  private DriveTrainSub driveSub;

  private double tv;
  private double tx;

  /**
   * Creates a new LimelightAimCom.
   */
  public LimelightAimCom(DriveTrainSub driveSub) {
    addRequirements(driveSub);
    this.driveSub = driveSub;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    tv = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
    if (tv == 0)
      return;
    tx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    if (tx > 0 ) {
      System.out.println("TURN LEFT");
      driveSub.arcadeDrive(0, tx);
    } else if (tx < 0) {
      System.out.println("TURN RIGHT");
      driveSub.arcadeDrive(0, tx);
    }
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
