package com.avsystemgeo.cameraman.component

import android.graphics.Rect
import android.content.Context
import android.graphics.Canvas
import android.widget.TextView
import android.util.AttributeSet

/**
 * @author Lucas Cota
 * @since 31/07/2019 12:03
 */

class VerticalTextView : TextView {

    private var _width: Int = -1
    private var _height: Int = -1
    private val _bounds = Rect()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        _width = measuredHeight
        _height = measuredWidth
        setMeasuredDimension(_width, _height)
    }

    override fun onDraw(canvas: Canvas?) {
        if (canvas != null) {
            canvas.save()

            canvas.translate(_width.toFloat(), _height.toFloat())
            canvas.rotate(-90f)

            val paint = paint
            paint.color = textColors.defaultColor
            paint.getTextBounds(text.toString(), 0, text.length, _bounds)

            canvas.drawText(
                text.toString(),
                compoundPaddingLeft.toFloat(),
                (_bounds.height().toFloat() - _width.toFloat()) / 2,
                paint
            )

            canvas.restore()
        }
    }
}
