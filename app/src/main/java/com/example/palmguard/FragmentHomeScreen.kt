package com.example.palmguard

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.findViewTreeViewModelStoreOwner

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHomeScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHomeScreen : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        return inflater.inflate(R.layout.fragment_home_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cv_history: CardView = view.findViewById(R.id.cv_history)
        val cv_explanation: CardView = view.findViewById(R.id.cv_explanation)
        val cv_headline: CardView = view.findViewById(R.id.cv_headline)

        cv_history.setOnClickListener {
            Intent(requireContext(), DiagnoseScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        cv_explanation.setOnClickListener {
            Intent(requireContext(), DetailExplanationScreenActivity::class.java).also {
                startActivity(it)
            }
        }

        cv_headline.setOnClickListener {
            Intent(requireContext(), ErrorDetectionScreenActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FragmentHomeScreen.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHomeScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}