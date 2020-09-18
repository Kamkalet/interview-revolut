package com.example.currencieslist.rates

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.currencieslist.App
import com.example.currencieslist.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class RatesActivity : AppCompatActivity(R.layout.activity_main), RatesView {

    @Inject
    lateinit var presenter: RatesPresenter

    @Inject
    lateinit var ratesAdapter: RatesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        (application as App).component!!.inject(this)

        presenter.attach(this)
    }

    override fun initRatesList() {
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        with(recyclerView) {

            layoutManager = linearLayoutManager
            // needed for notifyOnItemChanged to preserve existing ViewHolders when swapping items
            val animator = object : DefaultItemAnimator() {
                override fun canReuseUpdatedViewHolder(viewHolder: RecyclerView.ViewHolder): Boolean {
                    return true
                }
            }
            itemAnimator = animator
            adapter = ratesAdapter
        }
    }

    override fun setErrorVisibility(visible: Boolean) {
        error.setVisibility(visible)
    }

    override fun setProgressVisibility(visible: Boolean) {
        progress.setVisibility(visible)
    }

    override fun setRatesVisibility(visible: Boolean) {
        recyclerView.setVisibility(visible)
    }

    override fun setRatesItemList(rates: List<Rate>) {
        ratesAdapter.setItems(rates)
    }

    override fun onDestroy() {
        presenter.detach()
        super.onDestroy()
    }
}

fun View.setVisibility(visible: Boolean) {
    visibility = when (visible) {
        true -> View.VISIBLE
        false -> View.GONE
    }
}
