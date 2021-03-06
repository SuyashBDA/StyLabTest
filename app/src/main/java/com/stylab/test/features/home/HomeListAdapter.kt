package com.stylab.test.features.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.stylab.test.R
import com.stylab.test.data.list.model.ListModel
import com.stylab.test.databinding.GridListItemBinding
import kotlinx.android.synthetic.main.grid_list_item.view.*

class HomeListAdapter(private val context: Context) : RecyclerView.Adapter<HomeListAdapter.ViewHolder>() {

    /**
     * The list of model for the adapter
     */
    private var modelList: List<ListModel> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding: GridListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.grid_list_item, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return modelList.size
    }

    override fun onBindViewHolder(holder: HomeListAdapter.ViewHolder, position: Int) {
        val aspectRatio = 300 floatDiv 200
        holder.itemView.image.setAspectRatio(aspectRatio)
        holder.bind(modelList[position])
    }

    /**
     * Updates the list of git repository of the adapter
     * @param modelList the new list for adapter
     */
    fun updateList(modelList: List<ListModel>) {
        this.modelList = modelList
        notifyItemRangeChanged(0, modelList.size)
    }

    /**
     * The ViewHolder of the adapter
     * @property binding the DataBinging object for list item
     */
    class ViewHolder(private val binding: GridListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ListModel) {
            binding.apply {
                listItem = item
                executePendingBindings()
            }
        }
    }
}

infix fun Int.floatDiv(i: Int): Float = this / i.toFloat()

