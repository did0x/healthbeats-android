package co.saputra.healthbeats.arch.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import co.saputra.healthbeats.R
import co.saputra.healthbeats.arch.adapter.CareTaskAdapter
import co.saputra.healthbeats.arch.model.Task
import co.saputra.healthbeats.base.BaseFragment
import co.saputra.healthbeats.databinding.FragmentCareTaskBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class CareTaskFragment : BaseFragment<FragmentCareTaskBinding>(FragmentCareTaskBinding::inflate) {
    private val adapter by lazy { CareTaskAdapter(layoutInflater, Glide.with(requireContext()), ::itemClickListener) }
    private lateinit var tasks: ArrayList<Task>

    override fun initView(view: View, savedInstaceState: Bundle?) {
        tasks = prepareData()
        adapter.submitList(tasks)

        val formatter = SimpleDateFormat("dd MMM yyyy")
        val currentDate = formatter.format(Date())
        binding.tvDate.text = currentDate

        binding.rvTask.setHasFixedSize(true)
        binding.rvTask.adapter = adapter
        binding.rvTask.layoutManager = object : LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false) {
            override fun checkLayoutParams(params: RecyclerView.LayoutParams): Boolean {
                params.width = width - 160
                return true
            }
        }
    }

    private fun prepareData(): ArrayList<Task> {
        val arrOfTask = arrayListOf<Task>()
        val task0 = Task(name = "Diabetes Plan A",
            title = "Blood Glucose",
            description = "Ensure your iHealth Smart (BG5S) is powered and connected to your mobile device",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_glucometer),
            action = "Measure",
            rule = "Before Breakfast",
            amount = 1)
        val task1 = Task(name = "Heart Plan A",
            title = "Blood Pressure",
            description = "Ensure your iHealth Neo (BP5S) is powered and connected to your mobile device",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_blood_pressure),
            action = "Measure",
            rule = "10.00 - 13.00",
            amount = 1)
        val task2 = Task(name = "BYOD PO Programee A",
            title = "Oxygen Saturation and Heart Rate",
            description = "Please use your own device to take the measurement and tap `Add Result` button below to input your result",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_pulse),
            action = "Add Result", rule = "5 times a day",
            amount = 5)
        val task3 = Task(name = "Weight Programee A",
            title = "Weight and BMI",
            description = "Please use your own device to take the measurement and tap `Add Result` button below to input your result",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_body_scale),
            action = "Add Result",
            rule = "3 times a day",
            amount = 3)
        val task4 = Task(name = "Diabetes Plan B",
            title = "Blood Glucose",
            description = "Ensure your iHealth Lancing Pen is powered and connected to your mobile device",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_lancing_pen),
            action = "Measure",
            rule = "Before Breakfast",
            amount = 1)
        val task5 = Task(name = "BYOD PO Programee B",
            title = "Swim and Sleep Tracker",
            description = "Please use your own device to take the measurement and tap `Add Result` button below to input your result",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_wave),
            action = "Add Result",
            rule = "2 times a day",
            amount = 2)
        val task6 = Task(name = "Fever Plan A",
            title = "Body Temperature",
            description = "Please use your own device to take the measurement and tap `Add Result` button below to input your result",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_thermometer),
            action = "Add Result",
            rule = "3 times a day",
            amount = 3)
        val task7 = Task(name = "Heart Plan B",
            title = "Blood Pressure",
            description = "Ensure your change your cuff for iHealth Track/Ease weekly",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.ihealth_track_ease),
            action = "Change",
            rule = "1 times a day",
            amount = 1)

        arrOfTask.add(task0)
        arrOfTask.add(task1)
        arrOfTask.add(task2)
        arrOfTask.add(task3)
        arrOfTask.add(task4)
        arrOfTask.add(task5)
        arrOfTask.add(task6)
        arrOfTask.add(task7)
        return arrOfTask
    }

    private fun itemClickListener(item: Task) {

    }
}