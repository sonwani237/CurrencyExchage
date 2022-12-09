package com.exchange.view.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.exchange.R
import com.exchange.databinding.ExchangeItemsBinding
import com.exchange.model.ExchangeRete
import com.exchange.viewModel.ExchangeItemViewModel
import java.util.LinkedList

class ExchangeAdapter : RecyclerView.Adapter<ExchangeAdapter.MyViewHolder>() {

    var mDataList: LinkedList<ExchangeRete>? = null

    init {
        mDataList = LinkedList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val dataBinding: ExchangeItemsBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.exchange_items, parent, false)
        return MyViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return mDataList!!.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindList(mDataList!![position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(dataList: LinkedList<ExchangeRete>) {
        mDataList!!.addAll(dataList)
        notifyDataSetChanged()
    }

    class MyViewHolder(itemBinding: ExchangeItemsBinding) : RecyclerView.ViewHolder(itemBinding.item) {
        private var mItemBinding: ExchangeItemsBinding? = itemBinding

        fun bindList(exchangeRete: ExchangeRete) {
            if (mItemBinding!!.itemViewModel == null) {
                mItemBinding!!.itemViewModel = ExchangeItemViewModel(exchangeRete)
            } else {
                mItemBinding!!.itemViewModel!!.setData(exchangeRete)
            }
        }
    }

}