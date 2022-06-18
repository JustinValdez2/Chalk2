package games.sourdough.chalk2.workoutconfiguration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import games.sourdough.chalk2.databinding.ActivityWorkoutConfigurationBinding
import games.sourdough.chalk2.workoutcalculator.WorkoutCalculatorView
import javax.inject.Inject

@AndroidEntryPoint
class WorkoutConfigurationView : AppCompatActivity(), WorkoutConfigurationContract.View {

    private lateinit var binding: ActivityWorkoutConfigurationBinding

    @Inject
    lateinit var presenter: WorkoutConfigurationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutConfigurationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        presenter.setView(this)
        presenter.retrieveWorkoutMaxes()

        binding.btnSave.setOnClickListener { saveButtonClicked() }
        binding.btnCancel.setOnClickListener { cancelButtonClicked() }
    }

    override fun getDeadliftMax(): Int {
        return Integer.parseInt(binding.txtDeadlift.text.toString())
    }

    override fun setDeadliftMax(max: Int) {
        binding.txtDeadlift.setText(max.toString())
    }

    override fun getBenchMax(): Int {
        return Integer.parseInt(binding.txtBench.text.toString())
    }

    override fun setBenchMax(max: Int) {
        binding.txtBench.setText(max.toString())
    }

    override fun getSquatMax(): Int {
        return Integer.parseInt(binding.txtSquat.text.toString())
    }

    override fun setSquatMax(max: Int) {
        binding.txtSquat.setText(max.toString())
    }

    override fun getShoulderPressMax(): Int {
        return Integer.parseInt(binding.txtShoulderPress.text.toString())
    }

    override fun setShoulderPressMax(max: Int) {
        binding.txtShoulderPress.setText(max.toString())
    }

    override fun saveButtonClicked() {
        presenter.saveButtonClicked()
    }

    override fun cancelButtonClicked() {
        presenter.cancelButtonClicked()
    }

    override fun navigateToWorkoutCalculator() {
        val destination = Intent(this,WorkoutCalculatorView::class.java)
        startActivity(destination)
    }
}