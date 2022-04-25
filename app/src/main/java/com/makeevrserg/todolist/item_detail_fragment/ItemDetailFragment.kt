package com.makeevrserg.todolist.item_detail_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.makeevrserg.todolist.R
import com.makeevrserg.todolist.databinding.TodolistFragmentBinding

class ItemDetailFragment : Fragment() {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = ItemDetailFragmentArgs.fromBundle(savedInstanceState)
        val text = view.findViewById<TextView>(R.id.tvDetail)
        println(arguments.text)
        text.text = arguments.text

    }
}