package org.usfirst.frc.team967.robot.subsystems;

import org.usfirst.frc.team967.robot.Robot;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.FeedbackDevice;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team967.robot.*;
import org.usfirst.frc.team967.robot.commands.*;


/**
 *
 */
public class Shooter extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
		CANTalon motor; 
		int shooterRpm = 0;
		int incrementVal = 10;
		double P = 0;
		float I = 0;
		float D = 0;
		// Put methods for controlling this subsystem
	    // here. Call these from Commands.

	    public Shooter() {
	    	motor = new CANTalon(6);
	    	motor.changeControlMode(TalonControlMode.Speed);
	    	motor.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
	    	motor.reverseSensor(false);
//	    	motor.configEncoderCodesPerRev(512);//Needs to be checked with sensors. 
	    	motor.configNominalOutputVoltage(+0.0f, -0.0f);
	    	motor.configPeakOutputVoltage(+12.0f, -12.0f);
	    	motor.setProfile(0);
	    	motor.setP(0.1);
	    	motor.setI(0);
	    	motor.setD(0);
	    	motor.setF(0);// www.chiefdelphi.com/forums/showthread.php?t=142381
	    }
	    
	    public void ShootSpeedUp(){
	    	shooterRpm = shooterRpm + incrementVal;
	    	motor.set(shooterRpm);
	    }
	    public void ShootSpeedDown(){
	    	shooterRpm = shooterRpm + -incrementVal;
	    	motor.set(shooterRpm);
	    }
	    
	    public void PUp(){
	    	P = P + .001;
	    	motor.setP(P);
	    }
	    public void PDown(){
	    	P = P - .001;
	    	motor.setP(P);
	    }
//	    void ShootSpeed(){
//	    	double setpoint =shooterRpm;// .685333
//	    	motor.set(setpoint);
//	    }
	    
	    public void initDefaultCommand() {
	    	setDefaultCommand(new ShootSpeed());
	    	// Set the default command for a subsystem here.
	        //setDefaultCommand(new MySpecialCommand());
	    }
	    public void log(){

	    	SmartDashboard.putNumber("Talon Fly Wheel Speed", motor.getSpeed());
	    	SmartDashboard.putNumber("Talon Fly Wheel P", motor.getP());
	    	SmartDashboard.putNumber("Talon Fly Wheel I", motor.getI());
	    	SmartDashboard.putNumber("Talon Fly Wheel D", motor.getD());
	    	SmartDashboard.putNumber("Talon Fly Wheel Setpoint", motor.getSetpoint());
	    	SmartDashboard.putNumber("Talon position", motor.getEncPosition());
	    	SmartDashboard.putNumber("Talon Fly Wheel Velocity", motor.getEncVelocity());
	    	SmartDashboard.putNumber("SetPointRpm", shooterRpm);
	    	SmartDashboard.putNumber("Talon closed loop error", motor.getClosedLoopError());
	    }
    }

