package com.io.alertdialog

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        alertDialog()
    }

    private fun alertDialog() {
        val displayRectangle = Rect()
        val window: Window = this@MainActivity.window
        val builder =
            AlertDialog.Builder(
                this@MainActivity
            ).setCancelable(false)
        val viewGroup = findViewById<ViewGroup>(R.id.content)

        button1.setOnClickListener {
            window.decorView.getWindowVisibleDisplayFrame(displayRectangle)
            val dialogView: View =
                LayoutInflater.from(it.context).inflate(R.layout.customviews, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            val buttonOk: Button = dialogView.findViewById(R.id.buttonOkS)
            buttonOk.setOnClickListener { alertDialog.dismiss() }
            alertDialog.show()
        }

        button2.setOnClickListener {
            window.decorView.getWindowVisibleDisplayFrame(displayRectangle)
            val dialogView: View =
                LayoutInflater.from(it.context).inflate(R.layout.customview, viewGroup, false)
            builder.setView(dialogView)
            val alertDialog = builder.create()
            val buttonOk: Button = dialogView.findViewById(R.id.buttonOk)
            buttonOk.setOnClickListener { alertDialog.dismiss() }
            alertDialog.show()

        }
    }
}

