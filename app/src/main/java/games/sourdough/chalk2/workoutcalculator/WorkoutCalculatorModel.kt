package games.sourdough.chalk2.workoutcalculator

import games.sourdough.chalk2.entity.WorkoutMax
import games.sourdough.chalk2.service.WorkoutConfigurationService
import javax.inject.Inject

class WorkoutCalculatorModel @Inject constructor(val service: WorkoutConfigurationService): WorkoutCalculatorContract.Model {

    private var oneRepMax : Int = 0
    private lateinit var workOutMaxes: List<WorkoutMax>

    override fun retrieveWorkoutMaxes() {
        workOutMaxes = service.getAllWorkoutMaxes()
    }

    override fun getOneRepMax(): Int {
        return oneRepMax
    }

    override fun setOneRepMax(oneRepMax: Int) {
        this.oneRepMax = oneRepMax
    }

    override fun getWorkoutMaxes(): List<WorkoutMax> {
        return this.workOutMaxes
    }
}