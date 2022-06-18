package games.sourdough.chalk2.persistence

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideWorkoutConfigurationDao(chalkDatabase: ChalkDatabase): WorkoutConfigurationDao {
        return chalkDatabase.workoutMaxDao()
    }

    @Provides
    @Singleton
    fun provideChalkDatabase(@ApplicationContext applicationContext: Context): ChalkDatabase {
        return Room.databaseBuilder(applicationContext, ChalkDatabase::class.java, "Chalk").allowMainThreadQueries().build()
    }
}