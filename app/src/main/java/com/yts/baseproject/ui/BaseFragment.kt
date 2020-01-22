package  com.yts.baseproject.ui

import android.app.Dialog
import android.graphics.Color.TRANSPARENT
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.keyIterator
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import com.yts.baseproject.extension.hideKeyboard
import java.lang.Exception

abstract class BaseFragment<B : ViewDataBinding> : DialogFragment() {
    abstract fun onLayoutId(): Int
    abstract fun setupViewModel(): SparseArray<ViewModel>
    abstract fun observer()

    lateinit var binding: B


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, onLayoutId(), container, false)
        if (::binding.isInitialized) {
            for (variableId in setupViewModel().keyIterator()) {
                binding.setVariable(variableId, setupViewModel()[variableId])
            }
            binding.lifecycleOwner = this
            observer()
        }

        return binding.root
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.setBackgroundDrawable(ColorDrawable(TRANSPARENT))

        return dialog
    }

    override fun onDestroy() {
        super.onDestroy()
    }


    override fun dismiss() {
        try {
            activity?.hideKeyboard()
            if (activity != null) {
                activity?.supportFragmentManager?.beginTransaction()?.remove(this)?.commit()
            } else {
                super.dismiss()
            }
        } catch (e: Exception) {
            super.dismiss()
        }
    }

}