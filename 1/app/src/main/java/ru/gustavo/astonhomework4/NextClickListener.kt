package ru.gustavo.astonhomework4

import android.os.Bundle

interface NextClickListener {
    fun onNextClicked(
        target: String,
        clearBackStack: Boolean = false,
        isFirsFragment: Boolean = false,
        bundle: Bundle? = null
    )
}