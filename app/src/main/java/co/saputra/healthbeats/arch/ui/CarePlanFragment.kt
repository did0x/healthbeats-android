package co.saputra.healthbeats.arch.ui

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import co.saputra.healthbeats.R
import co.saputra.healthbeats.arch.adapter.CarePlanAdapter
import co.saputra.healthbeats.arch.model.Plan
import co.saputra.healthbeats.base.BaseFragment
import co.saputra.healthbeats.databinding.FragmentCarePlanBinding
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class CarePlanFragment : BaseFragment<FragmentCarePlanBinding>(FragmentCarePlanBinding::inflate) {
    private val adapter by lazy { CarePlanAdapter(layoutInflater, Glide.with(requireContext()), ::itemClickListener) }
    private lateinit var plans: ArrayList<Plan>

    override fun initView(view: View, savedInstaceState: Bundle?) {
        plans = prepareData()
        adapter.submitList(plans)

        val formatter = SimpleDateFormat("dd MMM yyyy")
        val currentDate = formatter.format(Date())
        binding.tvDate.text = currentDate

        binding.rvPlan.setHasFixedSize(true)
        binding.rvPlan.adapter = adapter
    }

    private fun prepareData(): ArrayList<Plan> {
        val arrOfPlan = arrayListOf<Plan>()
        val plan0 = Plan(name = "Diabetes Plan A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan1),
            location = "Hospital 1",
            type = "type-hospital")
        val plan1 = Plan(name = "Heart Plan A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan2),
            location = "Hospital 1",
            type = "type-hospital")
        val plan2 = Plan(name = "BYOD PO Programee A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan3),
            location = "Clinic 1",
            type = "type-clinic")
        val plan3 = Plan(name = "BYOD PO Programee A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan4),
            location = "Clinic 2",
            type = "type-clinic")
        val plan4 = Plan(name = "Weight Programee A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan5),
            location = "Clinic 2",
            type = "type-clinic")
        val plan5 = Plan(name = "Diabetes Plan B",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan6),
            location = "Hospital 2",
            type = "type-hospital")
        val plan6 = Plan(name = "BYOD PO Programee B",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan7),
            location = "Clinic 2",
            type = "type-clinic")
        val plan7 = Plan(name = "Fever Plan A",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan8),
            location = "Clinic 1",
            type = "type-clinic")
        val plan8 = Plan(name = "Heart Plan B",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan9),
            location = "Hospital 1",
            type = "type-hospital")
        val plan9 = Plan(name = "Heart Plan B",
            image = ContextCompat.getDrawable(requireContext(), R.drawable.plan10),
            location = "Hospital 2",
            type = "type-hospital")

        arrOfPlan.add(plan0)
        arrOfPlan.add(plan1)
        arrOfPlan.add(plan2)
        arrOfPlan.add(plan3)
        arrOfPlan.add(plan4)
        arrOfPlan.add(plan5)
        arrOfPlan.add(plan6)
        arrOfPlan.add(plan7)
        arrOfPlan.add(plan8)
        arrOfPlan.add(plan9)
        return arrOfPlan
    }

    private fun itemClickListener(item: Plan) {

    }
}