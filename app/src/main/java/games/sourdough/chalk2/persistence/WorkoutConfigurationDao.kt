package games.sourdough.chalk2.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import games.sourdough.chalk2.entity.WorkoutMax

@Dao
interface WorkoutConfigurationDao {

    @Query("select * from WorkoutMax")
    fun getAll(): MutableList<WorkoutMax>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg workoutMaxes: WorkoutMax)

}