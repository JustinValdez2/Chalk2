package games.sourdough.chalk2.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WorkoutMax(@PrimaryKey(autoGenerate = true) var id: Int?,
                      @ColumnInfo(name="workout") val workout: String,
                      @ColumnInfo(name = "max") var max: Int) {

    override fun toString(): String {
        return workout
    }
}