package com.example.githubpro

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import javax.security.auth.callback.Callback

fun EditText.onTextChanged(callback: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(text: CharSequence?, start: Int, before: Int, count: Int) {

            text?.let {
                callback.invoke(text.toString())
            }

        }

    })
}