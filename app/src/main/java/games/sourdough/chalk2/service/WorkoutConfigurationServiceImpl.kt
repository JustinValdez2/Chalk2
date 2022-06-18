package games.sourdough.chalk2.service

import games.sourdough.chalk2.entity.WorkoutMax
import games.sourdough.chalk2.persistence.WorkoutConfigurationDao
import javax.inject.Inject

class WorkoutConfigurationServiceImpl @Inject constructor(
    private val workoutConfigurationDao: WorkoutConfigurationDao
) : WorkoutConfigurationService {

    override fun saveWorkoutMaxes(workoutMaxes: MutableList<WorkoutMax>) {
        workoutMaxes.forEach { workoutMax ->
            workoutConfigurationDao.insertAll(workoutMax)
        }
    }

    override fun getAllWorkoutMaxes(): MutableList<WorkoutMax> {
        return workoutConfigurationDao.getAll()
    }
}