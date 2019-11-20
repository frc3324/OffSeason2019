package frc.team3324.lib.commands

import edu.wpi.first.wpilibj.DoubleSolenoid
import edu.wpi.first.wpilibj.command.InstantCommand

class PneumaticShiftCommand(val solenoid: DoubleSolenoid): InstantCommand() {

    override fun initialize() {
        if (solenoid.get() == DoubleSolenoid.Value.kForward) {
            solenoid.set(DoubleSolenoid.Value.kReverse)
        } else {
            solenoid.set(DoubleSolenoid.Value.kForward)
        }
    }

}