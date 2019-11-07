package frc.team3324.robot

import edu.wpi.first.cameraserver.CameraServer
import edu.wpi.first.wpilibj.Compressor
import edu.wpi.first.wpilibj.TimedRobot
import edu.wpi.first.wpilibj.command.Scheduler
import frc.team3324.lib.commands.MotorCommand
import frc.team3324.lib.subsystems.MotorSubsystem
import frc.team3324.robot.arm.Arm

import frc.team3324.robot.drivetrain.DriveTrain
import frc.team3324.robot.intake.hatch.Hatch
import frc.team3324.robot.util.Consts
import frc.team3324.robot.util.LED
import frc.team3324.robot.util.OI

class Robot : TimedRobot() {
    private val compressor = Compressor(1)
    companion object {
        var cargo = MotorSubsystem(Consts.CargoIntake.motor, 5, 0.06)
    }

    override fun robotInit() {
        compressor.start()

        DriveTrain
        OI
        Arm
        Hatch
        LED

        LED.redStatus = true
        LED.blueStatus = true
        LED.greenStatus = true


        CameraServer.getInstance().startAutomaticCapture(1)
        CameraServer.getInstance().startAutomaticCapture(0)

        CameraServer.getInstance().putVideo("Camera output", 240, 144)

    }

    override fun robotPeriodic() {
        CameraServer.getInstance().video
        Scheduler.getInstance().run()
    }

    override fun teleopPeriodic() {
    }
}
