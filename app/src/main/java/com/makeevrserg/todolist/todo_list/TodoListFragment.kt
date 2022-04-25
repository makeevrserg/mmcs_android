package com.makeevrserg.todolist.todo_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.makeevrserg.todolist.R
import com.makeevrserg.todolist.databinding.TodolistFragmentBinding

class TodoListFragment : Fragment() {
    private val viewModel: TodoListViewModel by lazy {
        ViewModelProvider(this)[TodoListViewModel::class.java]
    }
    val adapter by lazy {
        TodoListAdapter() { i, item ->
            println("Clicked ${item}")
            findNavController().navigate(
                TodoListFragmentDirections.actionTodolistFragmentToItemDetailFragment(item.text)
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: TodolistFragmentBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.todolist_fragment, container, false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.recyclerView.adapter = adapter
        viewModel.todoItems.observe(this) {
            adapter.submitList(it)
        }
        return binding.root
    }
}