package com.example.palmguard.ui.history

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.palmguard.R
import com.example.palmguard.ui.diagnose.DiagnoseScreenActivity

/**
 * A simple [Fragment] subclass.
 * Use the [FragmentHistoryScreen.newInstance] factory method to
 * create an instance of this fragment.
 */
class FragmentHistoryScreen : Fragment() {
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
        return inflater.inflate(R.layout.fragment_history_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cv_history: CardView = view.findViewById(R.id.cv_history)
        cv_history.setOnClickListener {
            Intent(requireContext(), DiagnoseScreenActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    companion object {
        // Deklarasi ARG_PARAM1 dan ARG_PARAM2
        private const val ARG_PARAM1 = "param1"
        private const val ARG_PARAM2 = "param2"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FragmentHistoryScreen().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}