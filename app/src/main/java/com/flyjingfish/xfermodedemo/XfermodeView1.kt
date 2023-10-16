package com.flyjingfish.xfermodedemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View

//val OVAL_COLOR = Color.argb(255,214,57,100)
//val RECT_COLOR = Color.argb(255,70,150,236)
val OVAL_COLOR = Color.argb(255,247,205,95)
val RECT_COLOR = Color.argb(255,117,169,248)

class XfermodeView1(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var xfermode :PorterDuffXfermode ?= null
        set(value) {
            invalidate()
            field = value
        }
    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(0f,0f,150.dp,150.dp,null)
        paint.color = OVAL_COLOR
        canvas.drawOval(0.dp,0f,100.dp,100.dp,paint)
        paint.xfermode = xfermode
        paint.color = RECT_COLOR
        canvas.drawRect(50.dp,50.dp,150.dp,150.dp,paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}