/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//Retrieve libraries from WPILIB
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//Import Class
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;


/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Declare Motor Controllers variables
  Talon leftFrontTalon = null;
  Talon leftBackTalon = null;
  Talon rightFrontTalon = null;
  Talon rightBackTalon = null;
  Spark leftSpark = null;
  Spark rightSpark = null;

  //Declare Drive Type
  DifferentialDrive differentialDrive = null;

  //Assign motor controllers to RoboRio Ports
  public Drivetrain() {
    //Talons
    leftFrontTalon = new Talon(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
    leftBackTalon = new Talon (RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
    rightFrontTalon = new Talon (RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
    rightBackTalon = new Talon (RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);

    //Sparks
    leftSpark = new Spark (RobotMap.DRIVETRAIN_LEFT_SPARK);
    rightSpark = new Spark (RobotMap.DRIVETRAIN_RIGHT_SPARK);

    //Assign Drive Type
    //Talon
    SpeedControllerGroup leftTalonMotors = new SpeedControllerGroup(leftFrontTalon, leftBackTalon);
    SpeedControllerGroup rightTalonMotors = new SpeedControllerGroup(rightFrontTalon, rightBackTalon);
    
    //Spark
    SpeedControllerGroup leftSparkMotors = new SpeedControllerGroup(leftSpark);
    SpeedControllerGroup rightSparkMotors = new SpeedControllerGroup(rightSpark);

    differentialDrive = new DifferentialDrive(leftTalonMotors, rightTalonMotors);
    differentialDrive = new DifferentialDrive(leftSparkMotors, rightSparkMotors);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new DriveArcade());
  }

public void arcadeDrive(double moveSpeed, double rotateSpeed) {
}
}
