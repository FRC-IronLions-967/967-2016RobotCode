package org.usfirst.frc.team967.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Navigation extends Subsystem {
	
	public AHRS ahrs;
	CameraServer serverFront, serverRear;
	public AnalogInput ultrasonic1;
	public AnalogInput ultrasonic2;
	public int auto;
	public AnalogInput position1;
	public DigitalInput position2, position3, position4, position5;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public Navigation() {
		ultrasonic1 = new AnalogInput(0);
		ultrasonic2 = new AnalogInput(1);
		ahrs = new AHRS(I2C.Port.kMXP); /* Alternatives:  SPI.Port.kMXP, I2C.Port.kMXP or SerialPort.Port.kUSB */	
		position1 = new AnalogInput(3);//DigitalInput(4);
		position2 = new DigitalInput(5);
/*		position3 = new DigitalInput(6);
		position4 = new DigitalInput(7);
		position5 = new DigitalInput(8);
	*/	//stream off camera to smartDashboard
		serverFront = CameraServer.getInstance();
    	serverFront.setQuality(7);
    	serverFront.startAutomaticCapture("cam0");
    	chooseAuto();
//    	serverRear = CameraServer.getInstance();
//    	serverRear.setQuality(50);
//    	serverRear.startAutomaticCapture("cam2");
	}
	
	public double getRawXAngle(){
		return ahrs.getRawGyroX();
	}
	public double getRawYAngle(){
		return ahrs.getRawGyroY();
	}
	public double getRawZAngle(){
		return ahrs.getRawGyroZ();
	}
	public int chooseAuto(){
		if(position1.getValue() > 100){
			auto = 1;
			return 1;
		}
		else if(position2.get() == true){
			auto = 2;
			return 2;
		}
	/*	else if(position3.get() == true){
			auto = 3;
			return 3;
		}
		else if(position4.get() == true){
			auto = 4;
			return 4;
		}
		else if(position5.get() == true){
			auto = 5;
			return 5;
		}*/
		else{
			auto = 50;
			return 50;
		}
		
	}
	
	
	
	
    public void initDefaultCommand() {
    	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void log() {	
    	SmartDashboard.putNumber("Ultrasonic2", ultrasonic2.getValue());
    	SmartDashboard.putNumber("Ultrasonic1", ultrasonic1.getValue());
    	SmartDashboard.putNumber("Auto Number", auto);
    	SmartDashboard.putNumber("position1", position1.getValue());
    	SmartDashboard.putBoolean("position2", position2.get());
//    	SmartDashboard.putBoolean("position3", position3.get());
//    	SmartDashboard.putBoolean("position4", position4.get());
    	
/*    	SmartDashboard.putNumber("NavX x-axis", ahrs.getRawGyroX());
    	SmartDashboard.putNumber("NavX y-axis", ahrs.getRawGyroY());
    	SmartDashboard.putNumber("NavX z-axis", ahrs.getRawGyroZ());
    	SmartDashboard.putNumber("Barometric Pressure", ahrs.getBarometricPressure());
    	SmartDashboard.putNumber("Mag x", ahrs.getRawMagX());
    	SmartDashboard.putNumber("Mag y", ahrs.getRawMagY());
    	SmartDashboard.putNumber("Mag z", ahrs.getRawMagZ());
    	SmartDashboard.putNumber("Accel x", ahrs.getRawAccelX());
    	SmartDashboard.putNumber("Accel y", ahrs.getRawAccelY());
    	SmartDashboard.putNumber("Accel z", ahrs.getRawAccelZ());
    	SmartDashboard.putNumber("Yaw", ahrs.getYaw());
    	SmartDashboard.putNumber("Pitch", ahrs.getPitch());
    	SmartDashboard.putNumber("Roll", ahrs.getRoll());
    	SmartDashboard.putNumber("PID get", ahrs.pidGet());
    	SmartDashboard.putBoolean("Magnometer Calibrated", ahrs.isMagnetometerCalibrated());
    	SmartDashboard.putNumber("Fused Heading", ahrs.getFusedHeading());
    	SmartDashboard.putNumber("Compass heading", ahrs.getCompassHeading());
  */  	

    }
}

