package com.example.mytest.aeon.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.mytest.aeon.R
import com.example.mytest.aeon.data.model.Payments

class PaymentsAdapter : Adapter<PaymentsViewHolder>() {
    private var list: List<Payments> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentsViewHolder {
        val holder = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_payments, parent, false)
        return PaymentsViewHolder(holder)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: PaymentsViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    fun setList(list: List<Payments>) {
        this.list = list
    }
}