/*package org.usfirst.frc.team967.robot.subsystems;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import org.usfirst.frc.team967.robot.RobotMap;
import edu.wpi.first.wpilibj.*;


/**
 *
 *//*
public class ShooterFlyWheel extends PIDSubsystem {
	
	private CANTalon motor;

    // Initialize your subsystem here
    public ShooterFlyWheel() {
    	super("ShooterFlyWheel", 2, 0, 0);// P, I, and D constants that are used when computing motor output.
    	setSetpoint(1000);
    	setAbsoluteTolerance(10);
    	enable();
    	motor = new CANTalon(7);
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
    	motor.getSpeed();
      
    	
    	
    	// Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
//    	return 0.0;
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    }
}
*/