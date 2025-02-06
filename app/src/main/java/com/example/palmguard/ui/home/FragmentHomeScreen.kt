package com.example.palmguard.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.palmguard.ui.diseaseDetail.DetailExplanationScreenActivity
import com.example.palmguard.R
import com.example.palmguard.databinding.FragmentHomeScreenBinding
import com.example.palmguard.ui.diagnose.DiagnoseScreenActivity
import com.example.palmguard.ui.diagnose.RecommendationFragment
import com.example.palmguard.ui.errorDetection.ErrorDetectionScreenActivity

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHomeScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHomeScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _bindingHome: FragmentHomeScreenBinding? = null
    private val binding get() = _bindingHome!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _bindingHome = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvHistory.setOnClickListener {
            Intent(requireContext(), DiagnoseScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.cvExplanation.setOnClickListener {
            Intent(requireContext(), DetailExplanationScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        binding.cvHeadline.setOnClickListener {
            Intent(requireContext(), ErrorDetectionScreenActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _bindingHome = null
    }

    companion object {
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RecommendationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}