package com.example.databindingsample

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingsample.databinding.ListExampleBinding

class ExampleAdapter(context: Context) : RecyclerView.Adapter<ExampleAdapter.Holder>() {

    var items: List<ListItem> = emptyList()
    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: ListExampleBinding = DataBindingUtil.inflate(inflater, R.layout.list_example, parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.item = items[position]

        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = items.size

    class Holder(val binding: ListExampleBinding): RecyclerView.ViewHolder(binding.root)


}