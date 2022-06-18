package games.sourdough.chalk2.workoutcalculator

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WorkoutCalculatorModule {

    @Binds
    abstract fun bindWorkoutCalculatorView(
        workoutCalculatorView: WorkoutCalculatorView
    ) : WorkoutCalculatorContract.View

    @Binds
    abstract fun bindWorkoutCalculatorPresenter(
        workoutCalculatorPresenter: WorkoutCalculatorPresenter
    ) : WorkoutCalculatorContract.Presenter

    @Binds
    abstract fun bindWorkoutCalculatorModel(
        workoutCalculatorModel: WorkoutCalculatorModel
    ) : WorkoutCalculatorContract.Model
}