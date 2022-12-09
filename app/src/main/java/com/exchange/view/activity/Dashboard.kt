package com.exchange.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exchange.R
import com.exchange.base.BaseActivity
import com.exchange.databinding.DashboardBinding
import com.exchange.model.ExchangeRete
import com.exchange.view.adapter.ExchangeAdapter
import com.exchange.viewModel.DashboardViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.LinkedList


class Dashboard : BaseActivity<DashboardBinding>() {

    private val dashboardViewModel by viewModel<DashboardViewModel>()

    lateinit var mAdapter: ExchangeAdapter

    override val layoutRes: Int
        get() = R.layout.dashboard

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding.viewModel = dashboardViewModel

        dashboardViewModel.getExchangeRate()
        dashboardViewModel.mLoading.observe(this) {
            showLoading(it)
        }

        dashboardViewModel.mError.observe(this) {
            Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
        }

        dashboardViewModel.currencyResponse.observe(this) {
            val obj = it.aud.asJsonObject
            val iterator: Iterator<*> = obj.keySet().iterator()
            val mList = LinkedList<ExchangeRete>()
            while (iterator.hasNext()) {
                val key = iterator.next() as String
                mList.add(ExchangeRete(key, obj.get(key).asDouble))
            }
            for (i in 0 until mList.size) {
                for (j in i until mList.size) {
                    if (mList[i].exchangeVal < mList[j].exchangeVal) {
                        val temp = mList[i]
                        mList[i] = mList[j]
                        mList[j] = temp
                    }
                }
            }
            setRecyclerViewData(dataBinding.recycler, mList)
        }
    }

    private fun setRecyclerViewData(recycler: RecyclerView, mList: LinkedList<ExchangeRete>) {
        mAdapter = ExchangeAdapter()
        recycler.adapter = mAdapter
        recycler.layoutManager = LinearLayoutManager(this)
        mAdapter.setList(mList)
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Done...", Toast.LENGTH_LONG).show()
        }
    }

}