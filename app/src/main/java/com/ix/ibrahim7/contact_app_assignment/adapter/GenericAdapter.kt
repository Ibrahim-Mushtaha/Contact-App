package com.ix.ibrahim7.contact_app_assignment.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class GenericAdapter<T>(@LayoutRes val layoutId: Int, var type:Int, val itemclick: OnListItemViewClickListener<T>) :
    RecyclerView.Adapter<GenericAdapter.GenericViewHolder<T>>() {

    val data = ArrayList<T>()
    private var inflater: LayoutInflater? = null

    fun addItems(items: List<T>) {
        this.data.clear()
        this.data.addAll(items)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return GenericViewHolder(binding)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: GenericViewHolder<T>, position: Int) {
        val itemViewModel= data[position]
        Log.e("eee data",itemViewModel.toString())
        holder.bind(itemViewModel,type)
        holder.itemView.apply {
            setOnClickListener {
                itemclick.onClickItem(itemViewModel, 1)
            }
        }
    }


    class GenericViewHolder<T>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(itemViewModel: T,F:Int) {
            binding.setVariable(F, itemViewModel)
            binding.executePendingBindings()
        }

    }


    interface OnListItemViewClickListener <T>{
        fun onClickItem(itemViewModel: T, type: Int)
    }

}