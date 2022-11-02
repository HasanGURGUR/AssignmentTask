package hasan.gurgur.enerjisatask.ui.randevu.adepter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.enerjisatask.base.BaseListAdapter
import hasan.gurgur.enerjisatask.model.ResultObject

class MenuListAdapter(
    private val characterClickCallback: ((ResultObject?) -> Unit)?,

    ) : BaseListAdapter<ResultObject>(
    itemsSame = { old, new -> old.value == new.value },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is MenuItemHolder -> {
                holder.bind(
                    name = getItem(position),
                    characterClickCallback = characterClickCallback,

                    )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return MenuItemHolder(parent, inflater)
    }

}