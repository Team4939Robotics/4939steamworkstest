package org.usfirst.frc.team4939.robot;

import org.usfirst.frc.team4939.robot.commands.Balls_in;
import org.usfirst.frc.team4939.robot.commands.Balls_out;
import org.usfirst.frc.team4939.robot.commands.Stop_climber;
import org.usfirst.frc.team4939.robot.commands.climb_up;
import org.usfirst.frc.team4939.robot.commands.fastclimb;
import org.usfirst.frc.team4939.robot.commands.ramp_engage;
import org.usfirst.frc.team4939.robot.commands.ramp_reset;
import org.usfirst.frc.team4939.robot.commands.releasegear;
import org.usfirst.frc.team4939.robot.commands.resetgear;
import org.usfirst.frc.team4939.robot.commands.stop_intake;
import org.usfirst.frc.team4939.robot.commands.turntime1;
import org.usfirst.frc.team4939.robot.commands.turntime2;
import org.usfirst.frc.team4939.robot.commands.turntime3;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;



/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	//intialize joysticks
	public Joystick DriverController = new Joystick(1);
	public Joystick ShooterController = new Joystick(2);
	
	private Button releasegear = new JoystickButton(this.ShooterController, 1);
	private Button resetgear = new JoystickButton(this.ShooterController, 4);
	private Button ramp_engage = new JoystickButton(this.ShooterController, 6);
	private Button ramp_reset = new JoystickButton(this.ShooterController, 5);
	private Button engage_climb = new JoystickButton(this.DriverController, 5);
	private Button stop_climb = new JoystickButton(this.DriverController,6);
	private Button balls_in = new JoystickButton(this.ShooterController,2);
	private Button balls_out = new JoystickButton(this.ShooterController,3);
	private Button stop_intake = new JoystickButton(this.ShooterController, 9);
	private Button fastclimb = new JoystickButton(this.DriverController, 1);
	private Button turn045 = new JoystickButton(this.DriverController, 2);
	private Button turn050 = new JoystickButton(this.DriverController, 3);
	private Button turn055 = new JoystickButton(this.DriverController, 4);
	
	
	public OI()
	{
		this.releasegear.whenPressed(new releasegear());
		this.resetgear.whenPressed(new resetgear());
		this.ramp_engage.whenPressed(new ramp_engage());
		this.ramp_reset.whenPressed(new ramp_reset());
		this.engage_climb.whenPressed(new climb_up());
		this.stop_climb.whenPressed(new Stop_climber());
		this.balls_in.toggleWhenPressed(new Balls_in());
		this.balls_out.toggleWhenPressed(new Balls_out());
		this.stop_intake.whenPressed(new stop_intake());
		this.fastclimb.whenPressed(new fastclimb());
		this.turn045.whenPressed(new turntime1());
		this.turn050.whenPressed(new turntime2());
		this.turn055.whenPressed(new turntime3());
		}

public double left()
{
	double joy = DriverController.getRawAxis(1);
	 if(Math.abs(joy)<0.05)
		 return 0.0;
	 else
		 return joy;
}

public double right()
{
	double joy = DriverController.getRawAxis(5);
	 if(Math.abs(joy)<0.05)
		 return 0.0;
	 else
		 return joy;
}
public boolean VisionEngage()
{
	return DriverController.getRawButton(1);
}
}