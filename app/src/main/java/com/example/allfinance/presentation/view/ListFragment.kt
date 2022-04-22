package com.example.allfinance.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.allfinance.R
import com.example.allfinance.data.Bill
import com.example.allfinance.databinding.FragmentListBinding
import com.example.allfinance.presentation.MyRecyclerViewAdapter
import kotlinx.coroutines.flow.combine

class ListFragment : Fragment() {

    private var _binding:FragmentListBinding? = null
    private val binding get() = _binding!!

    private lateinit var _adapter: MyRecyclerViewAdapter
    private lateinit var _layoutManager: LinearLayoutManager

    private var bills = MutableList(10){ Bill(0,"default","what is ISI????")}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _adapter = MyRecyclerViewAdapter(bills)
        _layoutManager = LinearLayoutManager(this.context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.recyclerView.apply {
                adapter = _adapter
                layoutManager = _layoutManager
            }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}