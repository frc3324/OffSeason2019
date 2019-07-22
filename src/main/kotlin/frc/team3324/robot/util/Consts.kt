package frc.team3324.robot.util

object Consts {
    object DriveTrain {
        val DRIVETRAIN_PCM_MODULE = 0

        // Motor ports
        val FL_MOTOR = 7 // Victor
        val BL_MOTOR = 6 // Talon
        val FR_MOTOR = 0 // Talon
        val BR_MOTOR = 1 // Victor

        val LEFT_ENCODER_PORT_A = 0
        val LEFT_ENCODER_PORT_B = 1
        val RIGHT_ENCODER_PORT_A = 2
        val RIGHT_ENCODER_PORT_B = 3

        // Encoder and Auto constants
        val WHEEL_DIAMETER_METERS = 0.1555575
        val CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER_METERS
        val PULSES = 1870 // 256 (pulses) * 4(quad, 4 ticks/pulse) * 3 * 25 (gear ratios)
        val TICKS = PULSES * 4
        val DISTANCE_PER_PULSE = CIRCUMFERENCE / PULSES
        val DISTANCE_BETWEEN_WHEELS = 0.61

        val HIGH_GEAR_MAX_VELOCITY = 3.4072
        val HIGH_GEAR_MAX_ACCELERATION = 4.38
        val LOW_GEAR_MAX_VELOCITY = 1.8
        val LOW_GEAR_MAX_ACCELERATION = 6.51

        val GEARSHIFTER_FORWARD = 0
        val GEARSHIFTER_REVERSE = 1
    }

    object Arm {
        val MOTOR_PORT_ARM_ONE = 2
        val MOTOR_PORT_ARM_TWO = 3
        val MOTOR_PORT_ARM_THREE = 5

        val ENCODER_PORT_A = 7
        val ENCODER_PORT_B = 6

        val ENCODER_TICKS_PER_REV = 256

        val FRONT_LIMIT_SWITCH = 9
        val BACK_LIMIT_SWITCH = 8
    }

    object HatchIntake {
        val HATCH_INTAKE_PORT_FORWARD = 6
        val HATCH_INTAKE_PORT_BACKWARD = 7
    }

    object CargoIntake {
        val CARGO_INTAKE_MOTOR = 4;
    }

    object Climber {
        val CLIMBER_BACK_PCM_MODULE = 1

        val CLIMBER_BACK_FORWARD = 5
        val CLIMBER_BACK_BACKWARD = 4
        val CLIMBER_FRONT_FORWARD = 1
        val CLIMBER_FRONT_BACKWARD = 0
    }

    object LED {
        val LED_PCM_MODULE = 1

        val RED_LED_PORT = 7
        val GREEN_LED_PORT = 6
        val BLUE_LED_PORT = 5
    }

}