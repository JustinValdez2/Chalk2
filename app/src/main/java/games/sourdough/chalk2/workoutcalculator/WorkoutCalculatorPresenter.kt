package games.sourdough.chalk2.workoutcalculator

import javax.inject.Inject
import kotlin.math.roundToInt

class WorkoutCalculatorPresenter @Inject constructor(
    private var model: WorkoutCalculatorContract.Model): WorkoutCalculatorContract.Presenter {

    private val BASE_MULTIPLER = .9F
    private val WEEK_ONE_MULTS = floatArrayOf(.65F, .75F, .85F)
    private val WEEK_TWO_MULTS = floatArrayOf(.70F, .80F, .90F)
    private val WEEK_THREE_MULTS = floatArrayOf(.75F, .85F, .95F)
    private lateinit var view : WorkoutCalculatorContract.View

    override fun setView(view: WorkoutCalculatorContract.View) {
        this.view = view
    }

    override fun calculateWeekOne(): List<Int> {
        model.setOneRepMax(model.getWorkoutMaxes()[view.getOneRepMax()].max)
        return calculateWeights(WEEK_ONE_MULTS, model.getOneRepMax())
    }

    override fun calculateWeekTwo(): List<Int> {
        model.setOneRepMax(model.getWorkoutMaxes()[view.getOneRepMax()].max)
        return calculateWeights(WEEK_TWO_MULTS, model.getOneRepMax())
    }

    override fun calculateWeekThree(): List<Int> {
        model.setOneRepMax(model.getWorkoutMaxes()[view.getOneRepMax()].max)
        return calculateWeights(WEEK_THREE_MULTS, model.getOneRepMax())
    }

    override fun workoutConfigurationMenuClicked() {
        view.navigateToWorkoutConfigurations()
    }

    override fun retrieveWorkoutMaxes() {
        model.retrieveWorkoutMaxes()
        view.setWorkoutMaxes(model.getWorkoutMaxes())
    }

    private fun calculateWeights(multipliers: FloatArray, oneRepMax: Int): List<Int> {
        val weights = mutableListOf<Int>()

        multipliers.forEach { mult -> weights.add((5*(((oneRepMax * BASE_MULTIPLER * mult) / 5).roundToInt()))) }

        return weights
    }
}