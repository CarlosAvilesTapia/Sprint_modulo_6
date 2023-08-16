package cl.cat2814.sprintmodulo6.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.cat2814.sprintmodulo6.R
import cl.cat2814.sprintmodulo6.databinding.FragmentSmartphoneListBinding
import cl.cat2814.sprintmodulo6.viewModel.SmartphoneViewModel


class SmartphoneListFragment : Fragment() {

    lateinit var binding: FragmentSmartphoneListBinding
    private val smartphoneViewModel: SmartphoneViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSmartphoneListBinding.inflate(layoutInflater, container, false)

      //  initAdapter()

        smartphoneViewModel.getAllSmartphones()

        return binding.root
    }

  /*  private fun initAdapter() {
        val adapter = DogBreedsAdapter()
        binding.rvDogBreedsList.adapter = adapter
        dogBreedsViewModel.liveDataDogBreeds().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }*/
}
