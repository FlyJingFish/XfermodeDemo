package com.flyjingfish.xfermodedemo

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
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


    val sourceImage =
        Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)
    val destinationImage =
        Bitmap.createBitmap(150.dp.toInt(), 150.dp.toInt(), Bitmap.Config.ARGB_8888)

    init {
        val canvas = Canvas(destinationImage)
        paint.color = OVAL_COLOR
        //下边起点x是0，是因为我要按照文档的图把圆画到右上角
        canvas.drawOval(0f, 0f, 100.dp, 100.dp, paint)
        canvas.setBitmap(sourceImage)
        paint.color = RECT_COLOR
        //下边起点y是50，是因为我要按照文档的图把正方形画到左下角
        canvas.drawRect(50.dp, 50.dp, 150.dp, 150.dp, paint)
    }

    override fun onDraw(canvas: Canvas) {
        val count = canvas.saveLayer(0f, 0f, 150.dp, 150.dp, null)
        canvas.drawBitmap(destinationImage, 0f, 0f, paint)
        paint.xfermode = xfermode
        canvas.drawBitmap(sourceImage, 0f, 0f, paint)
        paint.xfermode = null
        canvas.restoreToCount(count)
    }
}