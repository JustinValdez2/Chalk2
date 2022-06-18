package games.sourdough.chalk2.workoutconfiguration

interface WorkoutConfigurationContract {

    interface Model {
        fun retrieveWorkoutMaxes()
        fun persistWorkoutMaxes(deadliftMax: Int, benchMax: Int, squatMax: Int, shoulderPressMax: Int)
        fun getDeadliftMax(): Int
        fun getBenchMax(): Int
        fun getSquatMax(): Int
        fun getShoulderPressMax(): Int
    }

    interface View {
        fun getDeadliftMax(): Int
        fun setDeadliftMax(max: Int)
        fun getBenchMax(): Int
        fun setBenchMax(max: Int)
        fun getSquatMax(): Int
        fun setSquatMax(max: Int)
        fun getShoulderPressMax(): Int
        fun setShoulderPressMax(max: Int)
        fun saveButtonClicked()
        fun cancelButtonClicked()
        fun navigateToWorkoutCalculator()
    }

    interface Presenter {
        fun setView(view: View)
        fun saveButtonClicked()
        fun cancelButtonClicked()
        fun retrieveWorkoutMaxes()
    }
}