package frc.team3324.robot.drivetrain.commands.teleop

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command
import frc.team3324.robot.drivetrain.DriveTrain
import frc.team3324.robot.util.Consts
import frc.team3324.robot.util.TrapezoidProfile


class FollowPath(val goal: TrapezoidProfile.State, val kp: Double, val kv: Double): Command() {
    val timeStart = Timer.getFPGATimestamp()
    val encoderOffset = (DriveTrain.getLeftEncoderDistance() + DriveTrain.getRightEncoderDistance()) / 2.0
    val constraints = TrapezoidProfile.Constraints(Consts.DriveTrain.HIGH_GEAR_MAX_VELOCITY, Consts.DriveTrain.HIGH_GEAR_MAX_ACCELERATION)
    val path = TrapezoidProfile(constraints, goal)
    var timeDifference = Timer.getFPGATimestamp() - timeStart

    override fun execute() {
        timeDifference = Timer.getFPGATimestamp() - timeStart
        val distance_covered: Double = (DriveTrain.getLeftEncoderDistance() + DriveTrain.getRightEncoderDistance() / 2.0) - encoderOffset
        val seg = path.calculate(timeDifference)
        val error = seg.position - distance_covered
        val calculated_value: Double = kp * error + (kv * seg.velocity) // V and A Terms
    }

    override fun isFinished(): Boolean {
      return path.isFinished(timeDifference)
    }
}