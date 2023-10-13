package com.flyjingfish.xfermodedemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View


class XfermodeView2(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var xfermode :PorterDuffXfermode ?= null
        set(value) {
            invalidate()
            field = value
        }


    val rectBitmap =
        Bitmap.createBitmap(150f.dp().toInt(), 150f.dp().toInt(), Bitmap.Config.ARGB_8888)
    val ovalBitmap =
        Bitmap.createBitmap(150f.dp().toInt(), 150f.dp().toInt(), Bitmap.Config.ARGB_8888)

    init {

        val canvas = Canvas(ovalBitmap)
        paint.color = OVAL_COLOR
        canvas.drawOval(50f.dp(), 0f, 150f.dp(), 100f.dp(), paint)
        canvas.setBitmap(rectBitmap)
        paint.color = RECT_COLOR
        canvas.drawRect(0f.dp(), 50f.dp(), 100f.dp(), 150f.dp(), paint)

    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(100f.dp(), 0f.dp(), 250f.dp(), 150f.dp(), null)
        canvas.drawBitmap(ovalBitmap, 100f.dp(), 0f.dp(), paint)
        paint.xfermode = xfermode
        canvas.drawBitmap(rectBitmap, 100f.dp(), 0f.dp(), paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}