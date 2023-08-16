package cl.cat2814.sprintmodulo6.view.adapters

import android.icu.text.NumberFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.cat2814.sprintmodulo6.R
import cl.cat2814.sprintmodulo6.databinding.SmartphoneItemLayoutBinding
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import cl.cat2814.sprintmodulo6.viewModel.SmartphoneViewModel
import coil.load
import coil.transform.RoundedCornersTransformation
import java.util.Locale

class SmartphoneAdapter: RecyclerView.Adapter<SmartphoneAdapter.ItemSmartphoneViewHolder>() {

    private lateinit var binding: SmartphoneItemLayoutBinding
    private val smartphonesList = mutableListOf<SmartphoneEntity>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SmartphoneAdapter.ItemSmartphoneViewHolder {
        binding = SmartphoneItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemSmartphoneViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SmartphoneAdapter.ItemSmartphoneViewHolder,
        position: Int
    ) {
        val smartphones = smartphonesList[position]
        holder.bind(smartphones)
    }

    override fun getItemCount(): Int {
        return smartphonesList.size
    }

    fun setData(smartphones: List<SmartphoneEntity>) {
        this.smartphonesList.clear()
        this.smartphonesList.addAll(smartphones)
        notifyDataSetChanged()
    }

    class ItemSmartphoneViewHolder(private val binding: SmartphoneItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(smartphones: SmartphoneEntity) {

            binding.tvSmartphoneName.text = smartphones.name
            binding.tvSmartphonePrice.text = getPriceFormat(smartphones.price)
            binding.ivSmartphoneImage.load(smartphones.image) {
                transformations(RoundedCornersTransformation(20f))
            }
            binding.cvSmartphone.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", smartphones.id)
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_smartphoneListFragment_to_smartphoneDetailFragment, bundle)
            }
        }

        // Función para formatear Int del precio a un String en formato moneda.
        fun getPriceFormat(price: Int): String {
            val currency: NumberFormat = NumberFormat.getCurrencyInstance(Locale("es", "CL"))
            return currency.format(price)
        }
    }
}
