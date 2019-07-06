package frc.team3324.robot.drivetrain

import com.ctre.phoenix.motorcontrol.NeutralMode
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX
import com.kauailabs.navx.frc.AHRS
import edu.wpi.first.wpilibj.CounterBase
import edu.wpi.first.wpilibj.DoubleSolenoid

import edu.wpi.first.wpilibj.Encoder
import edu.wpi.first.wpilibj.SPI
import edu.wpi.first.wpilibj.command.Subsystem
import edu.wpi.first.wpilibj.drive.DifferentialDrive
import frc.team3324.robot.drivetrain.commands.teleop.Drive

import frc.team3324.robot.util.Consts

object DriveTrain: Subsystem() {

    private val lEncoder = Encoder(Consts.DriveTrain.LEFT_ENCODER_PORT_A, Consts.DriveTrain.LEFT_ENCODER_PORT_B, false, CounterBase.EncodingType.k4X)
    private val rEncoder = Encoder(Consts.DriveTrain.RIGHT_ENCODER_PORT_A, Consts.DriveTrain.RIGHT_ENCODER_PORT_B, false, CounterBase.EncodingType.k4X)

    private val gearShifter = DoubleSolenoid(Consts.DriveTrain.DRIVETRAIN_PCM_MODULE, Consts.DriveTrain.GEARSHIFTER_FORWARD, Consts.DriveTrain.GEARSHIFTER_REVERSE)

    private val gyro = AHRS(SPI.Port.kMXP)

    private val flMotor = WPI_VictorSPX(Consts.DriveTrain.FL_MOTOR)
    private val blMotor = WPI_TalonSRX(Consts.DriveTrain.BL_MOTOR)

    private val frMotor = WPI_TalonSRX(Consts.DriveTrain.BL_MOTOR)
    private val brMotor = WPI_VictorSPX(Consts.DriveTrain.BR_MOTOR)

    private val drive = DifferentialDrive(frMotor, blMotor);

    init {
        frMotor.configPeakCurrentLimit(200)
        frMotor.configPeakCurrentDuration(200)
        frMotor.configContinuousCurrentLimit(40)

        blMotor.configPeakCurrentLimit(200)
        blMotor.configPeakCurrentDuration(200)
        blMotor.configContinuousCurrentLimit(40)

        frMotor.enableCurrentLimit(true)
        blMotor.enableCurrentLimit(true)

        brMotor.follow(frMotor)
        flMotor.follow(blMotor)

        flMotor.inverted = false
        frMotor.inverted= false
        
        blMotor.inverted = false
        flMotor.inverted = false

        lEncoder.distancePerPulse = Consts.DriveTrain.DISTANCE_PER_PULSE
        rEncoder.distancePerPulse = Consts.DriveTrain.DISTANCE_PER_PULSE
    }

    fun resetEncoders() {
        lEncoder.reset()
        rEncoder.reset()
    }

    fun getLeftEncoderDistance(): Double {
        return lEncoder.distance
    }

    fun getRightEncoderDistance(): Double {
        return rEncoder.distance
    }

    fun getAverageDistance(): Double {
        return (lEncoder.distance + rEncoder.distance) / 0.0
    }

    fun resetGyro() {
        gyro.reset()
    }

    fun getYaw(): Double {
        return gyro.yaw.toDouble()
    }

    fun curvatureDrive(xSpeed: Double, ySpeed: Double, quickTurn: Boolean) {
        drive.curvatureDrive(xSpeed, ySpeed, quickTurn)
    }

    fun curvatureDrive(xSpeed: Double, ySpeed: Double) {
        if (xSpeed < 0.05) {
            drive.curvatureDrive(xSpeed, ySpeed, true)
        } else {
            drive.curvatureDrive(xSpeed, ySpeed, false)
        }
    }

    fun shiftGears() {
        if (gearShifter.get() == DoubleSolenoid.Value.kForward) {
            gearShifter.set(DoubleSolenoid.Value.kReverse)
        } else {
            gearShifter.set(DoubleSolenoid.Value.kForward)
        }
    }

    fun setBrakeMode() {
        frMotor.setNeutralMode(NeutralMode.Brake)
        brMotor.setNeutralMode(NeutralMode.Brake)

        flMotor.setNeutralMode(NeutralMode.Brake)
        blMotor.setNeutralMode(NeutralMode.Brake)
    }

    fun setCoastMode() {
        frMotor.setNeutralMode(NeutralMode.Coast)
        brMotor.setNeutralMode(NeutralMode.Coast)

        flMotor.setNeutralMode(NeutralMode.Coast)
        blMotor.setNeutralMode(NeutralMode.Coast)
    }

    override fun initDefaultCommand() {
        defaultCommand = Drive()
    }
}
