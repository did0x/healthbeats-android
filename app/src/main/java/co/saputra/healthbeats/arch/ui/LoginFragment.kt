package co.saputra.healthbeats.arch.ui

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import co.saputra.healthbeats.MainActivity
import co.saputra.healthbeats.R
import co.saputra.healthbeats.base.BaseFragment
import co.saputra.healthbeats.databinding.FragmentLoginBinding
import kotlin.math.sign


class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val items = listOf("+1", "+62", "+65")
    private var numberNotEmpty = false
    private var passwordNotEmpty = false

    override fun initView(view: View, savedInstaceState: Bundle?) {

        binding.apply {
            val adapter = ArrayAdapter(requireContext(), R.layout.item_list, items)
            spinner.adapter = adapter
            spinner.setSelection(2)

            etMobileNumber.addTextChangedListener {
                numberNotEmpty = it.toString().isNotEmpty()
                handleButtonState()
            }
            etPassword.addTextChangedListener {
                passwordNotEmpty = it.toString().isNotEmpty()
                handleButtonState()
            }
            btnAction.setOnClickListener {
                signIn()
            }
        }
    }

    private fun signIn() {
        if (validate()) {
            startActivity(Intent(requireContext(), MainActivity::class.java))
        } else {
            showDialog()
        }
    }

    private fun validate(): Boolean {
        return binding.spinner.selectedItem.toString() == "+65"
                && binding.etMobileNumber.text.toString() == "12345678"
                && binding.etPassword.text.toString() == "HealthBeats123!"
    }

    private fun handleButtonState() {
        if (passwordNotEmpty && numberNotEmpty) {
            binding.btnAction.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_button)
            binding.btnAction.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            binding.btnAction.isEnabled = true
        } else {
            binding.btnAction.background = ContextCompat.getDrawable(requireContext(), R.drawable.background_button_disabled)
            binding.btnAction.setTextColor(ContextCompat.getColor(requireContext(), R.color.white_20))
            binding.btnAction.isEnabled = false
        }
    }

    private fun showDialog() {
        val dialogBuilder = AlertDialog.Builder(requireContext())
        dialogBuilder.setMessage("Your mobile number or password is incorrect. Please double-check and try again.")
            .setCancelable(false)
            .setPositiveButton("Try Again") { dialog, id ->
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Login Failed")
        alert.show()
    }

}