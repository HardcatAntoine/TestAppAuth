package com.example.mytest.aeon.view

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mytest.aeon.R
import com.example.mytest.aeon.data.model.Payment

class PaymentsViewHolder(itemView: View) : ViewHolder(itemView) {
    private val id = itemView.findViewById<TextView>(R.id.tv_id)
    private val idText = itemView.findViewById<TextView>(R.id.idText)
    private val title = itemView.findViewById<TextView>(R.id.tv_title)
    private val titleText = itemView.findViewById<TextView>(R.id.titleText)
    private val amount = itemView.findViewById<TextView>(R.id.tv_amount)
    private val amountText = itemView.findViewById<TextView>(R.id.amountText)
    private val created = itemView.findViewById<TextView>(R.id.tv_created)
    private val createdText = itemView.findViewById<TextView>(R.id.createdText)


    fun bind(item: Payment) {
        id.text = item.id.toString()
        title.text = item.title
        if (item.amount == null || item.amount.toString() == "") {
            amountText.visibility = View.GONE
            amount.visibility = View.GONE
        } else {
            amount.text = item.amount.toString()
        }
        if (item.created == null || item.created.toString() == "") {
            createdText.visibility = View.GONE
            created.visibility = View.GONE
        } else {
            created.text = item.created.toString()
        }
    }
}