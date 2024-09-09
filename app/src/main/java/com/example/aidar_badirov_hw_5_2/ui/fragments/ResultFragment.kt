package com.example.aidar_badirov_hw_5_2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aidar_badirov_hw_5_2.R
import com.example.aidar_badirov_hw_5_2.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillData()
    }

    private fun fillData() = with(binding) {
        val firstName = arguments?.getString("firstName")
        val secondName = arguments?.getString("secondName")
        val percentage = arguments?.getString("percentage")

        tvYouResult.text = firstName
        tvMeResult.text = secondName
        tvProcent.text = "$percentage%"

        btnTryAgain.setOnClickListener {
            val loveCalculatorFragment = LoveCalculatorFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, loveCalculatorFragment).addToBackStack(null)
                .commit()
        }
    }
}