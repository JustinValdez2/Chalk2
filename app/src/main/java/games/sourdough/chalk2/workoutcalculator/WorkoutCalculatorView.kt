package games.sourdough.chalk2.workoutcalculator

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import games.sourdough.chalk2.R
import games.sourdough.chalk2.databinding.ActivityWorkoutCalculatorBinding
import games.sourdough.chalk2.entity.WorkoutMax
import games.sourdough.chalk2.workoutconfiguration.WorkoutConfigurationView
import javax.inject.Inject

@AndroidEntryPoint
class WorkoutCalculatorView : AppCompatActivity(), WorkoutCalculatorContract.View {

    private lateinit var binding: ActivityWorkoutCalculatorBinding

    @Inject
    lateinit var presenter: WorkoutCalculatorContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityWorkoutCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter.setView(this)
        presenter.retrieveWorkoutMaxes()

        binding.btnWeekOne.setOnClickListener { onClickBtnWeekOne() }
        binding.btnWeekTwo.setOnClickListener { onClickBtnWeekTwo() }
        binding.btnWeekThree.setOnClickListener { onClickBtnWeekThree() }
    }

    fun onClickBtnWeekOne() {
        setWeightTexts(presenter.calculateWeekOne())
    }

    fun onClickBtnWeekTwo() {
        setWeightTexts(presenter.calculateWeekTwo())
    }

    fun onClickBtnWeekThree() {
        setWeightTexts(presenter.calculateWeekThree())
    }

    override fun getOneRepMax(): Int {
        return binding.lstMaxes.selectedItemPosition
    }

    override fun setWeightTexts(weights: List<Int>) {

        binding.txtSetOne.setText(weights[0].toString())
        binding.txtSetTwo.setText(weights[1].toString())
        binding.txtSetThree.setText(weights[2].toString())
    }

    override fun navigateToWorkoutConfigurations() {
        val destination = Intent(this,WorkoutConfigurationView::class.java)
        startActivity(destination)
    }

    override fun setWorkoutMaxes(maxes: List<WorkoutMax>) {
        val arrayAdapter = ArrayAdapter(this, R.layout.workout_maxes_list_item, maxes)
        binding.lstMaxes.adapter = arrayAdapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.configure_maxes -> {
                presenter.workoutConfigurationMenuClicked()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}