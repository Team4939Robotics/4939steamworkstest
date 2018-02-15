
package org.usfirst.frc.team4939.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team4939.robot.subsystems.Climber;
import org.usfirst.frc.team4939.robot.subsystems.DriveSubsystem;
import org.usfirst.frc.team4939.robot.subsystems.GearSubsystem;
import org.usfirst.frc.team4939.robot.subsystems.Intake;
import org.usfirst.frc.team4939.robot.subsystems.Ramp;
import org.usfirst.frc.team4939.robot.*;
import org.usfirst.frc.team4939.robot.commands.DoNothing;
import org.usfirst.frc.team4939.robot.commands.GearCenterCommand;
import org.usfirst.frc.team4939.robot.commands.PlaceOnCenterPeg;
import org.usfirst.frc.team4939.robot.commands.PlaceOnLeftPeg;
import org.usfirst.frc.team4939.robot.commands.PlaceOnRightPeg;
import org.usfirst.frc.team4939.robot.commands.ReachBaseline;
import org.usfirst.frc.team4939.robot.commands.lowVleft;
import org.usfirst.frc.team4939.robot.commands.lowVright;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	public static DriveSubsystem dt = new DriveSubsystem();
	public static OI oi;
	public static GearSubsystem gear = new GearSubsystem();
	public static Compressor compressor; 
	public static Camera camera;
	public static Ramp ramp = new Ramp();
	public static Climber climber = new Climber();
	public static Intake intake = new Intake();
	public AnalogInput ultrasonicback = new AnalogInput(0);
	public int dist = 0;
	public double d = 0;
	
//	CameraServer server;
	
	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		compressor = new Compressor (0);
		compressor.start();
		camera = new Camera();
		
		dt.calibrate_gyro();
//		server.startAutomaticCapture(1);
		
		chooser.addDefault("Do Nothing", new DoNothing());
		chooser.addObject("Reach Baseline", new ReachBaseline());
		chooser.addObject("Place On Center Peg", new PlaceOnCenterPeg());
		chooser.addObject("Place On Right Peg", new PlaceOnRightPeg());
		chooser.addObject("Place On Left Peg", new PlaceOnLeftPeg());
		chooser.addObject("Place On Center Peg (gyro)", new GearCenterCommand());
		chooser.addObject("rightPeg 12V", new lowVright());
		chooser.addObject("LeftPeg 12V", new lowVleft());
		SmartDashboard.putData("Auto mode", chooser);
		
			dist = ultrasonicback.getAverageValue();
			d = ultrasonicback.getValue();

    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		compressor.stop();
		dist = ultrasonicback.getAverageValue();
		d = ultrasonicback.getValue();
	       SmartDashboard.putNumber("angle", Robot.dt.angle());
	        SmartDashboard.putNumber("rate", Robot.dt.rate());
	        SmartDashboard.putNumber("Average Distance", dist);
	        SmartDashboard.putNumber("Distance", d);
	        SmartDashboard.putBoolean("Gear Mech State", Robot.gear.dooropen);
	        SmartDashboard.putBoolean("Ramp State", Robot.ramp.rampengaged);
	        
	        SmartDashboard.putString("Climber State", Robot.climber.climb_state);
	        SmartDashboard.putString("Floor Gear Movement State", Robot.intake.gear_mover_state);
	        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
	}
	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
    	
    	autonomousCommand = chooser.getSelected();
    	dt.resetGyroYaw();
    	//dt.calibrate_gyro();
	
		if (autonomousCommand != null)
			autonomousCommand.start();
    	
    	// schedule the autonomous command (example)
//        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putNumber("angle", Robot.dt.angle());
        SmartDashboard.putNumber("rate", Robot.dt.rate());
        SmartDashboard.putNumber("Average Distance", dist);
        SmartDashboard.putNumber("Distance", d);
        SmartDashboard.putBoolean("Gear Mech State", Robot.gear.dooropen);
        SmartDashboard.putBoolean("Ramp State", Robot.ramp.rampengaged);
        
        SmartDashboard.putString("Climber State", Robot.climber.climb_state);
        SmartDashboard.putString("Floor Gear Movement State", Robot.intake.gear_mover_state);
        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
        
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
 //       if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        camera.control();
        compressor.start();
        
        dist = ultrasonicback.getAverageValue();
		d = ultrasonicback.getValue();
        
        SmartDashboard.putNumber("angle", Robot.dt.angle());
        SmartDashboard.putNumber("rate", Robot.dt.rate());
        SmartDashboard.putNumber("Average Distance", dist);
        SmartDashboard.putNumber("Distance", d);
        SmartDashboard.putBoolean("Gear Mech State", Robot.gear.dooropen);
        SmartDashboard.putBoolean("Ramp State", Robot.ramp.rampengaged);
        
        SmartDashboard.putString("Climber State", Robot.climber.climb_state);
        SmartDashboard.putString("Floor Gear Movement State", Robot.intake.gear_mover_state);
        SmartDashboard.putNumber("gyro yaw", Robot.dt.getGyroYaw());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
