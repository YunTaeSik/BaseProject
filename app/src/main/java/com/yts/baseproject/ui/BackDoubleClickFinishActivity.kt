package com.yts.baseproject.ui

import androidx.databinding.ViewDataBinding
import com.yts.baseproject.R
import com.yts.baseproject.extension.hideKeyboard
import com.yts.baseproject.extension.makeToast

abstract class BackDoubleClickFinishActivity<B : ViewDataBinding> : BaseActivity<B>() {
    private val TIME_INTERVAL = 2000
    private var mBackPressed: Long = 0


    //두번클릭시 종료
    override fun onBackPressed() {
        hideKeyboard()
        val childFragmentSize = supportFragmentManager.fragments.size
        if (childFragmentSize > 0) {
            super.onBackPressed()
        } else {
            if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) {
                super.onBackPressed()
                return
            } else {
                this.makeToast(R.string.msg_quit)
            }
            mBackPressed = System.currentTimeMillis()
        }
    }
}