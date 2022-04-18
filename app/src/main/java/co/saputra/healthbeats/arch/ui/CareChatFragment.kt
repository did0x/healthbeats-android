package co.saputra.healthbeats.arch.ui

import android.os.Bundle
import android.view.View
import co.saputra.healthbeats.base.BaseFragment
import co.saputra.healthbeats.databinding.FragmentVitalBinding
import java.text.SimpleDateFormat
import java.util.*

class CareChatFragment : BaseFragment<FragmentVitalBinding>(FragmentVitalBinding::inflate) {
    override fun initView(view: View, savedInstaceState: Bundle?) {
        val formatter = SimpleDateFormat("dd MMM yyyy")
        val currentDate = formatter.format(Date())
        binding.tvDate.text = currentDate
    }
}