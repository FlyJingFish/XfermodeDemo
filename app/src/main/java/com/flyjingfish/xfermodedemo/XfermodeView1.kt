package com.flyjingfish.xfermodedemo

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.view.View

val OVAL_COLOR = Color.YELLOW
val RECT_COLOR = Color.BLUE

class XfermodeView1(context: Context, attrs: AttributeSet?) : View(context, attrs) {
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
//    var xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    var xfermode :PorterDuffXfermode ?= null
        set(value) {
            invalidate()
            field = value
        }
    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(100f.dp(),0f.dp(),250f.dp(),150f.dp(),null)
        paint.color = OVAL_COLOR
        canvas.drawOval(150f.dp(),0f,250f.dp(),100f.dp(),paint)
        paint.xfermode = xfermode
        paint.color = RECT_COLOR
        canvas.drawRect(100f.dp(),50f.dp(),200f.dp(),150f.dp(),paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}