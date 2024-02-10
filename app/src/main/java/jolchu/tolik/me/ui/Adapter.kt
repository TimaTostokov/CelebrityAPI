package jolchu.tolik.me.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jolchu.tolik.me.databinding.ItemBinding
import jolchu.tolik.me.remote.model.InfoModelItem

class Adapter : RecyclerView.Adapter<Adapter.ItemViewHolder>() {
    var list = arrayListOf<InfoModelItem>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class ItemViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(item: InfoModelItem) {
            with(binding) {
                tvName.text = item.name
                tvAge.text = item.age.toString()
                tvAlive.text = item.isAlive.toString()
                tvBirthday.text = item.birthday
                tvGender.text = item.gender
                tvHeight.text = item.height.toString()
                tvNationality.text = item.nationality
                val occupation = item.occupation
                val result = java.lang.StringBuilder()
                for (element in occupation!!) {
                    result.append("$element\n")
                }
                tvOccupation.text = result.toString()
            }
        }
    }

}