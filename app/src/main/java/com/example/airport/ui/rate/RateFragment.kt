package com.example.airport.ui.rate

import com.example.airport.R
import com.example.airport.BR
import com.example.airport.base.BaseFragment
import com.example.airport.databinding.FragmentRateBinding

class RateFragment: BaseFragment<FragmentRateBinding, RateViewModel>() {
    override fun getLayoutId() = R.layout.fragment_rate
    override fun getViewModelId() = BR.rateVm
    override fun initView() {
    }
}