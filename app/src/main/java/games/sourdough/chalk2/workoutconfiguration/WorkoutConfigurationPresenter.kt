package games.sourdough.chalk2.workoutconfiguration

import javax.inject.Inject

class WorkoutConfigurationPresenter @Inject constructor(
    private var model: WorkoutConfigurationContract.Model): WorkoutConfigurationContract.Presenter {

    private lateinit var view: WorkoutConfigurationContract.View

    override fun setView(view: WorkoutConfigurationContract.View) {
        this.view = view
    }

    override fun saveButtonClicked() {
        saveValues()
        view.navigateToWorkoutCalculator()
    }

    override fun cancelButtonClicked() {
        view.navigateToWorkoutCalculator()
    }

    override fun retrieveWorkoutMaxes() {
        model.retrieveWorkoutMaxes()
        view.setDeadliftMax(model.getDeadliftMax())
        view.setBenchMax(model.getBenchMax())
        view.setSquatMax(model.getSquatMax())
        view.setShoulderPressMax(model.getShoulderPressMax())
    }

    private fun saveValues() {
        model.persistWorkoutMaxes(view.getDeadliftMax(), view.getBenchMax(),
            view.getSquatMax(), view.getShoulderPressMax())
    }
}