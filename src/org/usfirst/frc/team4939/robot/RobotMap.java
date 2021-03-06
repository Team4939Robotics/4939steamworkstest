package org.usfirst.frc.team4939.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	//CAN 
		public static final int leftDriveFront = 3;
		public static final int leftDriveBack = 1;
		public static final int rightDriveBack = 2;
		public static final int rightDriveFront = 4;
		public static final int CIMTop = 5;
		public static final int CIMBottom = 6;
		
		// Solenoids 
		public static final int release = 0;
		public static final int reset = 1;
		public static final int ramp = 2;
		public static final int ramp_in_frame = 3;
		
	//PWM
		public static final int intake775 = 0;
//		public static final int lights = 1;
		
		// SPI Gyro
		public static final int gyro = 0;
		
	// DIO 
		public static final int ultrasonicback = 0;
		public static final int gearsensor = 1;
		
}
    
