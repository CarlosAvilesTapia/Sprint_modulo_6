package cl.cat2814.sprintmodulo6.view.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.cat2814.sprintmodulo6.R
import cl.cat2814.sprintmodulo6.databinding.FragmentSmartphoneDetailBinding
import cl.cat2814.sprintmodulo6.viewModel.SmartphoneViewModel
import coil.load
import coil.transform.RoundedCornersTransformation

private const val ARG_SMARTPHONE_ID = "id"

class SmartphoneDetailFragment : Fragment() {

    private var smartphoneId: Int = 0
    private lateinit var binding: FragmentSmartphoneDetailBinding
    private val smartphoneViewModel: SmartphoneViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            smartphoneId = it.getInt(ARG_SMARTPHONE_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSmartphoneDetailBinding.inflate(layoutInflater, container, false)





       initViewModel()

        initListener()

        return binding.root
    }

    private fun initListener() {
        binding.fabEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            val name = binding.tvSmartphoneDetailName.text
            val id = smartphoneId
            intent.data = Uri.parse("mailto:")
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("info@novaera.cl"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Consulta: $name id: $id")
            intent.putExtra(Intent.EXTRA_TEXT, "Hola\n" +
                    "Vi la propiedad {PRODUCT_NAME} de código {PRODUCT_ID} y me gustaría\n" +
                    "que me contactaran a este correo o al siguiente número\n" +
                    "Quedo atento.")

            startActivity(Intent.createChooser(intent, "Enviar correo"))
        }
    }

    private fun initViewModel() {
        smartphoneViewModel.getSmartphoneDetailFromRepository(smartphoneId)
        smartphoneViewModel.liveDataSmartphoneDetailFromRepository(smartphoneId)
            .observe(viewLifecycleOwner) {
                if (it != null) {
                    binding.tvSmartphoneDetailName.text = it.name
                    binding.tvSmartphoneDetailLastPrice.text = smartphoneViewModel.getPriceFormat(it.lastPrice)
                    binding.tvSmartphoneDetailPrice.text = smartphoneViewModel.getPriceFormat(it.price)
                    binding.tvSmartphoneDetailDescription.text = it.description
                    binding.ivSmartphoneDetail.load(it.image) {
                        transformations(RoundedCornersTransformation(20f))
                    }
                    if (it.credit) {
                        binding.tvSmartphoneDetailCredit.text = getString(R.string.acepta_credito)
                    } else {
                        binding.tvSmartphoneDetailCredit.text = getString(R.string.solo_efectivo)
                    }

                }



            }

    }
}
