package frc.team3324.robot

import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.PowerDistributionPanel
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Scheduler
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard
import frc.team3324.robot.arm.Arm

import frc.team3324.robot.drivetrain.DriveTrain
import frc.team3324.robot.util.OI

class Robot : TimedRobot() {
    val compressor = Compressor(1)

    override fun robotInit() {
        compressor.start()
        SmartDashboard.putBoolean("Compressor", compressor.pressureSwitchValue)
        val pdp = PowerDistributionPanel()
        pdp.totalCurrent

        DriveTrain
        OI
        Arm
        println("Hello World from Kotlin!")
    }

    override fun robotPeriodic() {
        Scheduler.getInstance().run()
    }

    override fun teleopPeriodic() {
    }
}
