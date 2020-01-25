package com.yts.baseproject

import android.os.Bundle
import android.util.SparseArray
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yts.baseproject.databinding.MainViewBinding
import com.yts.baseproject.ui.BackDoubleClickFinishActivity
import com.yts.baseproject.viewmodel.BaseViewModel

class MainActivity : BackDoubleClickFinishActivity<MainViewBinding>() {
    override fun onLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun setupViewModel(): SparseArray<ViewModel> {
        val setupViewModel = SparseArray<ViewModel>()
        setupViewModel.put(BR.model, ViewModelProvider(this).get(BaseViewModel::class.java))
        return setupViewModel
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun observer() {
    }
}
