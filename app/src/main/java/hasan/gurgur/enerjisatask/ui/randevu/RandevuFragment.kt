package hasan.gurgur.enerjisatask.ui.randevu

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hasan.gurgur.enerjisatask.R
import hasan.gurgur.enerjisatask.databinding.FragmentRandevuBinding
import hasan.gurgur.enerjisatask.model.ResultObject
import hasan.gurgur.enerjisatask.ui.randevu.adepter.MenuListAdapter
import hasan.gurgur.enerjisatask.viewmodel.MenuViewModel

@AndroidEntryPoint
class RandevuFragment : Fragment() {

    private var _binding: FragmentRandevuBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MenuViewModel by viewModels()
    lateinit var menuListAdapter: MenuListAdapter
    var list = arrayListOf<ResultObject>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRandevuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.title.text = requireContext().getString(R.string.appointment)
        viewModel.fetchDataFromRemoteApi()
        initObserver()
        initAdapter()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initObserver() {
        viewModel.upcomingItemModel.observe(viewLifecycleOwner) {
            list.clear()
            list.addAll(it.result.resultObject)
            menuListAdapter.submitList(list)
            menuListAdapter.notifyDataSetChanged()
        }
    }

    private fun initAdapter() {
        menuListAdapter = MenuListAdapter {
            if (it?.key == 1) {
                findNavController().navigate(R.id.action_global_formFragment)
            } else {
                Toast.makeText(requireContext(), it?.value, Toast.LENGTH_SHORT).show()
            }
        }
        binding.menuRec.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.menuRec.adapter = menuListAdapter
    }

}