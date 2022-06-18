package games.sourdough.chalk2.workoutconfiguration

import games.sourdough.chalk2.entity.WorkoutMax
import games.sourdough.chalk2.service.WorkoutConfigurationService
import javax.inject.Inject

class WorkoutConfigurationModel @Inject constructor(val service: WorkoutConfigurationService): WorkoutConfigurationContract.Model {

    private var deadLiftMax: WorkoutMax = WorkoutMax(null,"DEADLIFT",0)
    private var benchMax: WorkoutMax = WorkoutMax(null,"BENCH", 0)
    private var squatMax: WorkoutMax = WorkoutMax(null,"SQUAT", 0)
    private var shoulderPressMax: WorkoutMax = WorkoutMax(null,"SHOULDERPRESS", 0)

    private lateinit var workoutMaxes: MutableList<WorkoutMax>


    override fun retrieveWorkoutMaxes() {
        workoutMaxes = service.getAllWorkoutMaxes()

        if(workoutMaxes.isEmpty()){
            workoutMaxes.add(deadLiftMax)
            workoutMaxes.add(benchMax)
            workoutMaxes.add(squatMax)
            workoutMaxes.add(shoulderPressMax)
        } else {
            workoutMaxes.forEach { max ->
                when(max.workout){
                    "DEADLIFT" -> deadLiftMax = max
                    "BENCH" -> benchMax = max
                    "SQUAT" -> squatMax = max
                    "SHOULDERPRESS" -> shoulderPressMax = max
                }
            }
        }
    }

    override fun persistWorkoutMaxes(deadliftMax: Int, benchMax: Int, squatMax: Int, shoulderPressMax: Int) {

        this.deadLiftMax.max = deadliftMax
        this.benchMax.max = benchMax
        this.squatMax.max = squatMax
        this.shoulderPressMax.max = shoulderPressMax

        service.saveWorkoutMaxes(workoutMaxes)
    }

    override fun getDeadliftMax(): Int {
        return this.deadLiftMax.max
    }

    override fun getBenchMax(): Int {
        return this.benchMax.max
    }

    override fun getSquatMax(): Int {
        return this.squatMax.max
    }

    override fun getShoulderPressMax(): Int {
        return this.shoulderPressMax.max
    }
}
