package com.example.databindingsample

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("errorText")
fun EditText.setErrorText(text: String?) {
    error =text
}