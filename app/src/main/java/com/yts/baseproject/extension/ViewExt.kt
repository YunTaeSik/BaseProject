package com.yts.baseproject.extension

import android.view.View

fun View.visible(error: Boolean) {
    if (error) {
        this.visibility = View.VISIBLE
    } else {
        this.visibility = View.GONE
    }
}
