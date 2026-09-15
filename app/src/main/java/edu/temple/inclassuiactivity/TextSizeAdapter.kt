package edu.temple.inclassuiactivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class TextSizeAdapter(private val  context: Context, private val numbers: Array<Int>) : BaseAdapter() {

    override fun getCount() = numbers.size

    override fun getItem(position: Int) = numbers[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView = if(convertView == null) {TextView(context)}
        else {convertView as TextView}
        textView.text = numbers[position].toString()
        textView.textSize = 22f
        return textView
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val textView = (getView(position, convertView, parent) as TextView)

        textView.textSize = numbers[position].toFloat()

        return textView
    }
}