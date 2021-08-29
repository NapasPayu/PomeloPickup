package com.pomelofashion.pomelopickup.presentation.common.util

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import java.util.concurrent.atomic.AtomicBoolean

class SingleLiveEvent<T> : MutableLiveData<T>() {

    private val mConsumed = AtomicBoolean(false)

    @MainThread
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner) { t ->
            if (mConsumed.compareAndSet(false, true)) {
                observer.onChanged(t)
            }
        }
    }

    @MainThread
    override fun setValue(t: T?) {
        mConsumed.set(false)
        super.setValue(t)
    }

    override fun postValue(value: T?) {
        mConsumed.set(false)
        super.postValue(value)
    }
}