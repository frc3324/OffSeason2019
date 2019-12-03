package frc.team3324.lib.physics

object Motors {
    abstract class Motor {
        abstract val freeSpeed: Double
        abstract val freeCurrent: Double
        abstract val stallTorque: Double
        abstract val stallCurrent: Double

        abstract val Kt: Double
        abstract val resistance: Double
        abstract val Kv: Double

    }
    class Cim(numberOfMotors: Double): Motor() {
        override val freeSpeed = 5310.0
        override val freeCurrent = 2.7
        override val stallTorque = 2.42 * numberOfMotors
        override val stallCurrent = 133.0

        override val Kt = stallTorque / stallCurrent
        override val resistance = 12 / stallCurrent
        override val Kv = freeSpeed / (12 - freeCurrent * resistance)
    }

    class MiniCim(numberOfMotors: Double): Motor() {
        override val freeSpeed = 6200.0
        override val freeCurrent = 1.5
        override val stallTorque = 1.4 * numberOfMotors
        override val stallCurrent = 86.0

        override val Kt = stallTorque / stallCurrent
        override val resistance = 12 / stallCurrent
        override val Kv = freeSpeed / (12 - freeCurrent * resistance)
    }
}