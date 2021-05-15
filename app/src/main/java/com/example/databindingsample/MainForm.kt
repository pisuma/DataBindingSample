package com.example.databindingsample

import android.content.Context
import android.widget.Toast
import androidx.databinding.BaseObservable
import androidx.databinding.Observable
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField

class MainForm : BaseObservable() {
    val to = ObservableField<String>("")

    val subject = ObservableField<String>("")

    val message = ObservableField<String>("")

    val errorMessage = ObservableField<String>()

    fun validate(context: Context) {
        val result = !to.get().isNullOrBlank()
        val error = if (result) null else "宛先を必ず指定してください。"
        errorMessage.set(error)

        if (result){
            send(context)
        }
    }

    private fun send(context: Context) {
        Toast.makeText(context, message.get(), Toast.LENGTH_SHORT).show()
    }

    //notifyChange()はBinding先へ値が変更されたことを通知するために呼び出します。
    //Kotlinのsetterで呼び出すと値を入れたタイミングに自動で呼ばれるため、ロジックの中身がシンプルになります。
    //今回自作のvalidate関数にContextを引数としていますが、これはToastを呼ぶためだけに使っています。
    //テストのしやすさを考慮して、Contextへの依存を減らすためにActivityへコールバックするなど
    //アレンジしてもいいでしょう。


}
