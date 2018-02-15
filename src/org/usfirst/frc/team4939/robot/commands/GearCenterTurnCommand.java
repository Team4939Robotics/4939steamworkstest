package org.usfirst.frc.team4939.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class GearCenterTurnCommand extends CommandGroup {

    public GearCenterTurnCommand() {
    	 addSequential(new DriveCommand(0.25, -0.25, 2.8));
         addSequential(new WaitCommand(1));
         addSequential(new resetgear());
         addSequential(new WaitCommand(0.5));
         addSequential(new DriveCommand(-0.23, 0.25, 2));
         addSequential(new WaitCommand(1)); // change timings 
         addSequential(new Turn(1, 1, 0.5));// change timings 
         addSequential(new WaitCommand(1));// change timings
         addSequential(new DriveCommand(0.45, -0.45, 2.2));
         addSequential(new Turn(-1, -1, 0.4));// change timings 
//         addSequential(new WaitCommand(1));// change timings
         addSequential(new DriveCommand(0.45, -0.45, 2.2));
         
    }
}
