package com.example.currencieslist.rates

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import com.example.currencieslist.R
import kotlinx.android.synthetic.main.currency_item.view.*
import javax.inject.Inject
import javax.inject.Provider


class RatesAdapter @Inject constructor(
    private val rateItemItemPresenterProvider: Provider<RateItemPresenter>
) : RecyclerView.Adapter<RatesAdapter.RateViewHolder>() {

    private var list: MutableList<Rate> = mutableListOf()

    fun setItems(model: List<Rate>) {
        if (list.isEmpty()) {
            list.addAll(model)
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.currency_item, parent, false)
        return RateViewHolder(view, rateItemItemPresenterProvider.get())
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        holder.apply {
            unbind()
            bind(list[position]) {
                notifyItemChanged(adapterPosition)
                notifyItemChanged(0)

                list.removeAt(adapterPosition).also {
                    list.add(0, it)
                }
                notifyItemMoved(adapterPosition, 0)
            }
        }

    }

    override fun getItemCount(): Int = list.size

    class RateViewHolder(
        view: View,
        private val presenter: RateItemPresenter
    ) : RecyclerView.ViewHolder(view), RateItemView {

        private val flag: ImageView = view.flag
        private val rateCodeTextView: TextView = view.rateIso
        private val rateDescription: TextView = view.rateDesc
        private val valueEditText: EditText = view.rate

        private var onEditTextClickedCallback = {}

        private val textWatcher = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.onRateInputChanged(s.toString())
            }
        }

        fun bind(rate: Rate, callback: () -> Unit) {
            onEditTextClickedCallback = callback
            presenter.onBind(this, rate, adapterPosition)
        }

        override fun initOnEditTextClickListener() {
            valueEditText.setOnFocusChangeListener { _, focused ->
                if (focused) {
                    presenter.onRateGainedFocus()
                    onEditTextClickedCallback.invoke()
                }
            }
        }

        override fun initTextWatcher() {
            valueEditText.addTextChangedListener(textWatcher)
        }

        override fun setCurrencyCode(code: String) {
            rateCodeTextView.text = code
        }

        override fun setFlag(img: Int) {
            flag.setImageResource(img)
        }

        override fun setRateDescription(@StringRes description: Int) {
            rateDescription.setText(description)
        }

        override fun setRateText(rate: String) {
            if(rate != valueEditText.text.toString()) this.valueEditText.setText(rate)
        }

        fun unbind() {
            presenter.onUnbind()
            onEditTextClickedCallback = {}
            valueEditText.onFocusChangeListener = null
            valueEditText.removeTextChangedListener(textWatcher)
        }
    }
}