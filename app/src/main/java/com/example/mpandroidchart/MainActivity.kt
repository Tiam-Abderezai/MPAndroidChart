package com.example.mpandroidchart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.github.mikephil.charting.charts.Chart
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    lateinit var lineList : ArrayList<Entry>
    lateinit var lineDataSet: LineDataSet
    lateinit var lineData : LineData
    lateinit var chart : LineChart
    private lateinit var button: Button

    val x = mutableListOf(0f, 10f, 20f, 30f, 40f, 50f, 60f, 70f, 80f, 90f, 100f)
    val y = mutableListOf(0f, 10f, 20f, 30f, 40f, 50f, 60f, 70f, 80f, 90f, 100f)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chart = findViewById(R.id.chart)
        button = findViewById(R.id.button)

        lineList = ArrayList()
        makeChart()
        button.setOnClickListener {
            makeChart()
        }
    }

    fun makeChart() {
        lineList = ArrayList()
        for (i in 0..x.size - 1) {
            lineList.add(
                Entry(
                    x[i],
                    y.shuffled()[i]
                )
            )
        }

        lineDataSet = LineDataSet(lineList, "Count")
        lineData = LineData(lineDataSet)
        chart.data =lineData
        chart.invalidate()
        chart.description.text = "Made by Tiam Abderezai"
//        lineDataSet.color = Color.BLACK
        lineDataSet.setColors(*ColorTemplate.JOYFUL_COLORS)
        lineDataSet!!.valueTextColor = Color.BLUE
        lineDataSet!!.valueTextSize=13f
        lineDataSet.setDrawFilled(true)

    }
}