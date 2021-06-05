package com.example.databindingsample

import android.content.Context
import android.os.Handler
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData

class MainForm : BaseObservable() {
    val to = ObservableField<String>("")

    val subject = ObservableField<String>("")

    val message = ObservableField<String>("")

    val valid = ObservableBoolean(true)

    val requesting = ObservableBoolean()

    val onComplete = MutableLiveData<Boolean>()

    val errorMessage = ObservableField<String>()

    fun validate() {
        val result = !to.get().isNullOrBlank()
        valid.set(result)
        if (result) {
            requesting.set(true)
            send()
        }
    }


    private fun send() {
        Handler().postDelayed({
            onComplete.postValue(true)
        }, 3000)
    }

    //notifyChange()はBinding先へ値が変更されたことを通知するために呼び出します。
    //Kotlinのsetterで呼び出すと値を入れたタイミングに自動で呼ばれるため、ロジックの中身がシンプルになります。
    //今回自作のvalidate関数にContextを引数としていますが、これはToastを呼ぶためだけに使っています。
    //テストのしやすさを考慮して、Contextへの依存を減らすためにActivityへコールバックするなど
    //アレンジしてもいいでしょう。


}
