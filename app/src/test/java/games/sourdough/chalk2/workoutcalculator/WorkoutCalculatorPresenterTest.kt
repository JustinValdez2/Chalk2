package games.sourdough.chalk2.workoutcalculator

import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock


class WorkoutCalculatorPresenterTest {

    @Test
    fun calculateWeekOne() {
        val oneRepMax = 200
        val view = mock(WorkoutCalculatorContract.View::class.java)
        `when`(view.getOneRepMax()).thenReturn(oneRepMax)
        val model: WorkoutCalculatorContract.Model = WorkoutCalculatorModel()
        val presenter: WorkoutCalculatorContract.Presenter = WorkoutCalculatorPresenter(model)
        presenter.setView(view)

        val weights: List<Int> = presenter.calculateWeekOne()

        assertEquals("List did not contain three values", 3, weights.size)
        assertEquals("First set weight should be 115", 115, weights[0])
        assertEquals("Second set weight should be 135", 135, weights[1])
        assertEquals("Third set weight should be 155", 155, weights[2])

    }

    @Test
    fun calculateWeekTwo() {
        val oneRepMax = 200
        val view = mock(WorkoutCalculatorContract.View::class.java)
        `when`(view.getOneRepMax()).thenReturn(oneRepMax)
        val model: WorkoutCalculatorContract.Model = WorkoutCalculatorModel()
        val presenter: WorkoutCalculatorContract.Presenter = WorkoutCalculatorPresenter(model)
        presenter.setView(view)

        val weights: List<Int> = presenter.calculateWeekTwo()

        assertEquals("List did not contain three values", 3, weights.size)
        assertEquals("First set weight should be 115", 125, weights[0])
        assertEquals("Second set weight should be 135", 145, weights[1])
        assertEquals("Third set weight should be 155", 160, weights[2])
    }

    @Test
    fun calculateWeekThree() {

        val oneRepMax = 200
        val view = mock(WorkoutCalculatorContract.View::class.java)
        `when`(view.getOneRepMax()).thenReturn(oneRepMax)
        val model: WorkoutCalculatorContract.Model = WorkoutCalculatorModel()
        val presenter: WorkoutCalculatorContract.Presenter = WorkoutCalculatorPresenter(model)
        presenter.setView(view)

        val weights: List<Int> = presenter.calculateWeekThree()

        assertEquals("List did not contain three values", 3, weights.size)
        assertEquals("First set weight should be 115", 135, weights[0])
        assertEquals("Second set weight should be 135", 155, weights[1])
        assertEquals("Third set weight should be 155", 170, weights[2])
    }
}


