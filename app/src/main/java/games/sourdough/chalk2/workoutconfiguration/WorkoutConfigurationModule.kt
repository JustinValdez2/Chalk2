package games.sourdough.chalk2.workoutconfiguration

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import games.sourdough.chalk2.service.WorkoutConfigurationService
import games.sourdough.chalk2.service.WorkoutConfigurationServiceImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkoutConfigurationModule {

    @Binds
    abstract fun bindWorkoutConfigurationView(
        workoutConfigurationView: WorkoutConfigurationView
    ) : WorkoutConfigurationContract.View

    @Binds
    abstract fun bindWorkoutConfigurationPresenter(
        workoutConfigurationPresenter: WorkoutConfigurationPresenter
    ) : WorkoutConfigurationContract.Presenter

    @Binds
    abstract fun bindWorkoutConfigurationModel(
        workoutConfigurationModel: WorkoutConfigurationModel
    ) : WorkoutConfigurationContract.Model

    @Binds
    abstract fun bindWorkoutConfigurationService(
        workoutConfigurationService: WorkoutConfigurationServiceImpl
    ): WorkoutConfigurationService
}