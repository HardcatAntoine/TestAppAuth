package com.example.mytest.aeon.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mytest.aeon.R
import com.example.mytest.aeon.data.model.Payments

class PaymentsViewHolder(itemView: View) : ViewHolder(itemView) {
    private val id = itemView.findViewById<TextView>(R.id.tv_id)
    private val idText = itemView.findViewById<TextView>(R.id.idText)
    private val title = itemView.findViewById<TextView>(R.id.tv_title)
    private val titleText = itemView.findViewById<TextView>(R.id.titleText)
    private val amount = itemView.findViewById<TextView>(R.id.tv_amount)
    private val amountText = itemView.findViewById<TextView>(R.id.amountText)
    private val created = itemView.findViewById<TextView>(R.id.tv_created)
    private val createdText = itemView.findViewById<TextView>(R.id.createdText)


    fun bind(item: Payments) {
        if (!item.id.toString().isNullOrEmpty()) {
            id.text = item.id.toString()
        } else {
            id.visibility = View.GONE
            idText.visibility = View.GONE
        }
        if (!item.title.isNullOrEmpty()) {
            title.text = item.title
        } else {
            title.visibility = View.GONE
            titleText.visibility = View.GONE
        }
        if (!item.amount.toString().isNullOrEmpty()) {
            amount.text = item.amount.toString()
        } else {
            amount.visibility = View.GONE
            amountText.visibility = View.GONE
        }
        if (!item.created.toString().isNullOrEmpty()) {
            created.text = item.created.toString()
        } else {
            created.visibility = View.GONE
            createdText.visibility = View.GONE
        }
    }
}