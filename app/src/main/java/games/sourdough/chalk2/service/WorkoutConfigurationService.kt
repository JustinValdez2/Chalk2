package games.sourdough.chalk2.service

import games.sourdough.chalk2.entity.WorkoutMax

interface WorkoutConfigurationService {

    fun saveWorkoutMaxes(workoutMaxes: MutableList<WorkoutMax>)
    fun getAllWorkoutMaxes(): MutableList<WorkoutMax>
}