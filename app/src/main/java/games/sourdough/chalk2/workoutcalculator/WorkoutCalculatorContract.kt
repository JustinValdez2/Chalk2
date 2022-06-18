package games.sourdough.chalk2.workoutcalculator

import games.sourdough.chalk2.entity.WorkoutMax

interface WorkoutCalculatorContract {

    interface Model {
        fun retrieveWorkoutMaxes()
        fun getOneRepMax(): Int
        fun setOneRepMax(oneRepMax: Int)
        fun getWorkoutMaxes(): List<WorkoutMax>
    }

    interface View {
        fun getOneRepMax(): Int
        fun setWeightTexts(weights: List<Int>)
        fun navigateToWorkoutConfigurations()
        fun setWorkoutMaxes(maxes: List<WorkoutMax>)
    }

    interface Presenter {
        fun setView(view: View)
        fun calculateWeekOne(): List<Int>
        fun calculateWeekTwo(): List<Int>
        fun calculateWeekThree(): List<Int>
        fun workoutConfigurationMenuClicked()
        fun retrieveWorkoutMaxes()
    }
}