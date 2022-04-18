package co.saputra.healthbeats.arch.ui

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import co.saputra.healthbeats.R
import co.saputra.healthbeats.base.BaseFragment
import co.saputra.healthbeats.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    override fun initView(view: View, savedInstaceState: Bundle?) {
        lifecycleScope.launch {
            delay(1500)
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }
    }

}