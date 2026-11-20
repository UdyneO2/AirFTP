package com.udyneos.airftp

import android.app.AlertDialog
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView

fun AlertDialog.Builder.showGlass(dark: Boolean): AlertDialog {
    val dlg = create()
    dlg.setOnShowListener { Glass.style(dlg, dark) }
    dlg.show()
    return dlg
}

object Glass {
    private const val BLUR_BEHIND = 36
    private const val BLUR_WINDOW = 72

    fun style(dlg: AlertDialog, dark: Boolean) {
        val w = dlg.window ?: return
        val res = dlg.context.resources
        val d = res.displayMetrics.density
        val text = if (dark) 0xFFFFFFFF.toInt() else 0xFF000000.toInt()
        val dim = if (dark) 0xFF98989F.toInt() else 0xFF6E6E73.toInt()
        val accent = if (dark) 0xFF0A84FF.toInt() else 0xFF007AFF.toInt()
        val blurOn = Build.VERSION.SDK_INT >= 31

        val bg = GradientDrawable().apply {
            cornerRadius = 24f * d
            setColor(if (dark) (if (blurOn) 0x9E1C1C1E.toInt() else 0xF21C1C1E.toInt()) else (if (blurOn) 0xA6FFFFFF.toInt() else 0xF2FFFFFF.toInt()))
            setStroke(maxOf(1, d.toInt()), if (dark) 0x26FFFFFF else 0xB3FFFFFF.toInt())
        }
        w.setBackgroundDrawable(bg)
        w.setDimAmount(if (dark) 0.35f else 0.2f)
        w.setLayout((res.displayMetrics.widthPixels * 0.86f).toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
        if (blurOn) {
            w.addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND)
            w.attributes = w.attributes.apply { blurBehindRadius = BLUR_BEHIND }
            w.setBackgroundBlurRadius(BLUR_WINDOW)
        }

        val titleId = res.getIdentifier("alertTitle", "id", "android")
        if (titleId != 0) dlg.findViewById<TextView>(titleId)?.setTextColor(text)
        dlg.findViewById<TextView>(android.R.id.message)?.setTextColor(if (dark) 0xFFE5E5EA.toInt() else 0xFF1C1C1E.toInt())
        listOf(AlertDialog.BUTTON_POSITIVE, AlertDialog.BUTTON_NEGATIVE, AlertDialog.BUTTON_NEUTRAL).forEach {
            dlg.getButton(it)?.apply { setTextColor(accent); isAllCaps = false; setBackgroundColor(0) }
        }
        (dlg.window?.decorView as? ViewGroup)?.let { tint(it, text, dim) }
    }

    private fun tint(v: ViewGroup, text: Int, dim: Int) {
        for (i in 0 until v.childCount) {
            val c = v.getChildAt(i)
            if (c is EditText) { c.setTextColor(text); c.setHintTextColor(dim) }
            else if (c is ViewGroup) tint(c, text, dim)
        }
    }
}
