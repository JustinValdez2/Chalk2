package games.sourdough.chalk2.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import games.sourdough.chalk2.entity.WorkoutMax

@Database(entities = [WorkoutMax::class], version = 1)
abstract class ChalkDatabase: RoomDatabase() {
    abstract fun workoutMaxDao(): WorkoutConfigurationDao
}