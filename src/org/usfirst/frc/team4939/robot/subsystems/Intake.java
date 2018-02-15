package org.usfirst.frc.team4939.robot.subsystems;

import org.usfirst.frc.team4939.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	public Spark intake775 = new Spark(RobotMap.intake775);
	public String gear_mover_state = "off";
	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
	public void intake(){
		this.intake775.set(0.75);
		this.gear_mover_state = "intake";
	}
	public void outtake(){
		this.intake775.set(-0.5);
		this.gear_mover_state = "outtake";
	}
	public void stop(){
		this.intake775.set(0);
		this.gear_mover_state = "off";
	}
	

}
