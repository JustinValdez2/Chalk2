package games.sourdough.chalk2.workoutconfiguration

import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class WorkoutConfigurationPresenterTest {


    @Test
    fun saveMaxes() {

        val deadliftMax = 300
        val benchMax = 225
        val squatMax = 320
        val shoulderPressMax = 130

        val view: WorkoutConfigurationContract.View = mock(WorkoutConfigurationContract.View::class.java)
        val model = WorkoutConfigurationModel()
        val presenter = WorkoutConfigurationPresenter(model)
        presenter.setView(view)

        `when`(view.getDeadLiftMax()).thenReturn(deadliftMax)
        `when`(view.getBenchMax()).thenReturn(benchMax)
        `when`(view.getSquatMax()).thenReturn(squatMax)
        `when`(view.getShoulderPressMax()).thenReturn(shoulderPressMax)

        presenter.saveValues()


    }

    @Test
    fun loadMaxes() {

    }


}
