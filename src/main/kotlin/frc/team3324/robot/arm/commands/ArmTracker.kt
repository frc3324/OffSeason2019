package frc.team3324.robot.arm.commands

import edu.wpi.first.wpilibj.Timer
import edu.wpi.first.wpilibj.command.Command
import frc.team3324.robot.arm.Arm

object ArmTracker: Command() {
    var lastVelocity = 0.0
    var lastTime: Double = Timer.getFPGATimestamp()



    override fun execute() {
        val time = Timer.getFPGATimestamp()
        Arm.acceleration = (Arm.velocity - lastVelocity) / (time - lastTime)
        lastTime = time
        lastVelocity = Arm.velocity
    }

    override fun isFinished(): Boolean {
        return false
    }
}