package hasan.gurgur.enerjisatask.ui.form

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import hasan.gurgur.enerjisatask.R
import hasan.gurgur.enerjisatask.databinding.FragmentFormBinding


@AndroidEntryPoint
class FormFragment : Fragment() {

    private var _binding: FragmentFormBinding? = null
    private val binding get() = _binding!!
    private var info: Boolean = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFormBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkInfoButtonValue()
        prepareView()
        initListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initListeners(){
        with(binding){

            toolbar.backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            ozel.setOnCheckedChangeListener { p0, p1 ->
                if (p1) {
                    tuzel.isChecked = false
                }
            }

            tuzel.setOnCheckedChangeListener { _, p1 ->
                if (p1) {
                    ozel.isChecked = false
                }
            }

            btnInformationClose.setOnClickListener {
                info = !info
                checkInfoButtonValue()
            }

            infoIcon.setOnClickListener {
                info = !info
                checkInfoButtonValue()
                scroolView.post {
                    scroolView.fullScroll(View.FOCUS_DOWN)
                }

            }

        }
    }

    private fun prepareView(){
        with(binding){
            toolbar.title.text = requireContext().getString(R.string.new_subs)
            val subsType = resources.getStringArray(R.array.abone_tipleri)
            val spinnerAdapter = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                subsType)
            subscriptionSpinner.adapter = spinnerAdapter
        }
    }

    private fun checkInfoButtonValue() {
        if (info) {
             binding.informationMainLayout.visibility = View.VISIBLE
        } else {
             binding.informationMainLayout.visibility = View.GONE
        }
    }
}