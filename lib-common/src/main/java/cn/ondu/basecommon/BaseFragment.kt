package cn.ondu.basecommon

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<T : ViewBinding> : Fragment() {

    protected lateinit var mViewBinding: T

    protected open var mActivity: Activity? = null
    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as BaseActivity<T>
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mViewBinding = viewBinding()
        return mViewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(savedInstanceState)
        initView()
        registerViewClick()
        viewModelListener()
    }

    protected open fun initView() {}
    protected open fun initData(savedInstanceState: Bundle?) {}
    protected open fun registerViewClick() {}
    protected open fun viewModelListener() {}
    protected abstract fun viewBinding(): T
}