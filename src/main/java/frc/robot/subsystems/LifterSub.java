/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LifterSub extends SubsystemBase {

  private WPI_VictorSPX frontLifter;
  private WPI_VictorSPX rearLifter;

  private Encoder frontEncoder;
  private Encoder rearEncoder;

  private PIDController frontPID;
  private PIDController rearPID;

  private double maxLift;

  /**
   * Creates a new LifterSub.
   */
  public LifterSub() {
    frontLifter = new WPI_VictorSPX(Constants.FRONT_LIFTER_MOTOR);
    rearLifter = new WPI_VictorSPX(Constants.REAR_LIFTER_MOTOR);

    frontEncoder = new Encoder(Constants.FRONT_LIFTER_ENCODER[0], Constants.FRONT_LIFTER_ENCODER[1]);
    rearEncoder = new Encoder(Constants.REAR_LIFTER_ENCODER[0], Constants.REAR_LIFTER_ENCODER[1]);

    frontPID = new PIDController(0.002, 0, 0);
    rearPID = new PIDController(0.002, 0, 0);

    frontPID.setIntegratorRange(-0.5, 0.5);
    rearPID.setIntegratorRange(-0.5, 0.5);

    maxLift = 10000;
  }

  public void lift(double speed) {
    if (frontEncoder.getDistance() < maxLift) {
      frontLifter.set(speed);
      rearLifter.set(-speed + rearPID.calculate(rearEncoder.getDistance(), frontEncoder.getDistance()));
    } else if (speed > 0) {
      frontLifter.set(speed);
      rearLifter.set(-speed + rearPID.calculate(rearEncoder.getDistance(), frontEncoder.getDistance()));
    } else {
      rearLifter.set(rearPID.calculate(rearEncoder.getDistance(), frontEncoder.getDistance()));
    }
    // System.out.println(frontEncoder.getDistance() + "   " + rearEncoder.getDistance() + "     " + rearPID.calculate(rearEncoder.getDistance(), frontEncoder.getDistance()));
  }

  public void stopLift() {
    frontLifter.set(0);
    rearLifter.set(0);
  }

  public void resetLimit() {
    frontEncoder.reset();
    rearEncoder.reset();
  }
}
