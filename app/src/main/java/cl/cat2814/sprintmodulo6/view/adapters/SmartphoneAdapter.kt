package cl.cat2814.sprintmodulo6.view.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.cat2814.sprintmodulo6.R
import cl.cat2814.sprintmodulo6.databinding.SmartphoneItemLayoutBinding
import cl.cat2814.sprintmodulo6.model.localData.SmartphoneEntity
import coil.load
import coil.transform.RoundedCornersTransformation

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
            binding.tvSmartphonePrice.text = smartphones.price.toString()
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
    }
}
