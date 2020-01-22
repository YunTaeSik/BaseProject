package com.yts.baseproject.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.realm.Realm

open class BaseViewModel(application: Application) : AndroidViewModel(application) {
    protected val realm = Realm.getDefaultInstance()
    protected val context: Context = application.applicationContext
    protected val compositeDisposable = CompositeDisposable()

    protected var _isLoading = MutableLiveData<Boolean>()
    protected var _toastMessage = MutableLiveData<String>()

    val isLoading: LiveData<Boolean> get() = _isLoading
    val toastMessage: LiveData<String> get() = _toastMessage

    fun addDisposable(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        realm?.close()
        compositeDisposable.clear()
        super.onCleared()
    }

    fun setToastMessage(text: String) {
        _toastMessage.postValue(text)
    }

}