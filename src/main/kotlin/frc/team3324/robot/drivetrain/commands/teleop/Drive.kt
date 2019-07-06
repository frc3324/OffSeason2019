package frc.team3324.robot.drivetrain.commands.teleop

import edu.wpi.first.wpilibj.GenericHID
import edu.wpi.first.wpilibj.command.Command
import frc.team3324.robot.drivetrain.DriveTrain
import frc.team3324.robot.util.OI

class Drive: Command() {
    init {
        requires(DriveTrain)
    }

    override fun execute() {
        val xSpeed = OI.primaryController.getY(GenericHID.Hand.kLeft)
        val ySpeed = OI.primaryController.getX(GenericHID.Hand.kRight)

        DriveTrain.curvatureDrive(xSpeed, ySpeed)
    }

    override fun isFinished(): Boolean {
        return false
    }
}