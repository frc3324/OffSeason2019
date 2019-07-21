package frc.team3324.robot

import edu.wpi.first.wpilibj.TimedRobot
import frc.team3324.robot.arm.Arm

import frc.team3324.robot.drivetrain.DriveTrain
import frc.team3324.robot.util.OI

class Robot : TimedRobot() {

    override fun robotInit() {
        DriveTrain
        OI
        Arm
        println("Hello World from Kotlin!")
    }
}
