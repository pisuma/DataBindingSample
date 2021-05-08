package com.example.databindingsample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.example.databindingsample.databinding.ListExampleBinding

class MainListAdapter(context: Context): ArrayAdapter<ListItem> (context,0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ListExampleBinding
        if(convertView == null) {
            binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.list_example, parent, false)
            binding.root.tag = binding
        } else {
            binding = convertView.tag as ListExampleBinding
        }

        binding.item = getItem(position)
        return binding.root
    }
}