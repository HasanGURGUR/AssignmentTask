package hasan.gurgur.enerjisatask.ui.randevu.adepter

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.enerjisatask.base.BaseViewHolder
import hasan.gurgur.enerjisatask.databinding.ItemMenuListBinding
import hasan.gurgur.enerjisatask.model.ResultObject

class MenuItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemMenuListBinding>(
    binding = ItemMenuListBinding.inflate(inflater, parent, false)
) {

    fun bind(
        name: ResultObject,
        characterClickCallback: ((ResultObject) -> Unit)? = null,

        ) {
        with(binding) {
            binding.menuItem = name
            binding.mainLayout.setOnClickListener {
                characterClickCallback?.invoke(name)
            }

            executePendingBindings()
        }
    }


}
