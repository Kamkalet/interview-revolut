package com.example.currencieslist.rates

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.currencieslist.R
import com.example.currencieslist.rates.RateResource.PLN
import javax.inject.Inject

class ImageResolver @Inject constructor() {

    fun resolve(code: String): RateResource {
        return when (code) {
            "AUD" -> RateResource.AUD
            "BGN" -> RateResource.BGN
            "BRL" -> RateResource.BRL
            "CAD" -> RateResource.CAD
            "CHF" -> RateResource.CHF
            "CNY" -> RateResource.CNY
            "CZK" -> RateResource.CZK
            "DKK" -> RateResource.DKK
            "EUR" -> RateResource.EUR
            "GBP" -> RateResource.GBP
            "HKD" -> RateResource.HKD
            "HRK" -> RateResource.HRK
            "HUF" -> RateResource.HUF
            "IDR" -> RateResource.IDR
            "ILS" -> RateResource.ILS
            "INR" -> RateResource.INR
            "ISK" -> RateResource.ISK
            "JPY" -> RateResource.JPY
            "KRW" -> RateResource.KRW
            "MXN" -> RateResource.MXN
            "MYR" -> RateResource.MYR
            "NOK" -> RateResource.NOK
            "NZD" -> RateResource.NZD
            "PHP" -> RateResource.PHP
            "PLN" -> PLN
            "RON" -> RateResource.RON
            "RUB" -> RateResource.RUB
            "SEK" -> RateResource.SEK
            "SGD" -> RateResource.SGD
            "THB" -> RateResource.THB
            "USD" -> RateResource.USD
            "ZAR" -> RateResource.ZAR
            else -> RateResource.EUR
        }
    }
}

enum class RateResource(
    @DrawableRes val imageSrc: Int,
    @StringRes val description: Int
) {
    AUD(R.drawable.ic_aud, R.string.aud_desc),
    BGN(R.drawable.ic_bgn, R.string.bgn_desc)          ,
    BRL(R.drawable.ic_brl, R.string.brl_desc),
    CAD(R.drawable.ic_cad, R.string.cad_desc),
    CHF(R.drawable.ic_chf, R.string.chf_desc),
    CNY(R.drawable.ic_cny, R.string.cny_desc),
    CZK(R.drawable.ic_czk, R.string.czk_desc),
    DKK(R.drawable.ic_dkk, R.string.dkk_desc),
    EUR(R.drawable.ic_eur, R.string.eur_desc),
    GBP(R.drawable.ic_gbp, R.string.gbp_desc),
    HKD(R.drawable.ic_hkd, R.string.hkd_desc),
    HRK(R.drawable.ic_hrk, R.string.hrk_desc),
    HUF(R.drawable.ic_huf, R.string.huf_desc),
    IDR(R.drawable.ic_idr, R.string.idr_desc),
    ILS(R.drawable.ic_ils, R.string.ils_desc),
    INR(R.drawable.ic_inr, R.string.inr_desc),
    ISK(R.drawable.ic_isk, R.string.isk_desc),
    JPY(R.drawable.ic_jpy, R.string.jpy_desc),
    KRW(R.drawable.ic_krw, R.string.krw_desc),
    MXN(R.drawable.ic_mxn, R.string.mxn_desc),
    MYR(R.drawable.ic_myr, R.string.myr_desc),
    NOK(R.drawable.ic_nok, R.string.nok_desc),
    NZD(R.drawable.ic_nzd, R.string.nzd_desc),
    PHP(R.drawable.ic_php, R.string.php_desc),
    PLN(R.drawable.ic_pln, R.string.pln_desc),
    RON(R.drawable.ic_ron, R.string.ron_desc),
    RUB(R.drawable.ic_rub, R.string.rub_desc),
    SEK(R.drawable.ic_sek, R.string.sek_desc),
    SGD(R.drawable.ic_sgd, R.string.sgd_desc),
    THB(R.drawable.ic_thb, R.string.thb_desc),
    USD(R.drawable.ic_usd, R.string.usd_desc),
    ZAR(R.drawable.ic_zar, R.string.zar_desc)
}
