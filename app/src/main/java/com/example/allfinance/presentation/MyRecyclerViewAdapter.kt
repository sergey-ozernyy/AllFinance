package com.example.allfinance.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.allfinance.R
import com.example.allfinance.data.Bill
import com.example.allfinance.databinding.CardViewBinding

class MyRecyclerViewAdapter(private val billList:List<Bill>): RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = CardViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val bill = billList[position]
        holder.bind(bill)
    }

    override fun getItemCount(): Int {
        return billList.size
    }

    class MyViewHolder(private val itemBinding: CardViewBinding) :RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(bill: Bill){
            itemBinding.code.text = bill.id.toString()
            itemBinding.category.text = bill.category
            itemBinding.isi.text = bill.isi
        }
    }
}