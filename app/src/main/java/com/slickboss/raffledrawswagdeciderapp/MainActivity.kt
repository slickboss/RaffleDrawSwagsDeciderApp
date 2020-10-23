package com.slickboss.raffledrawswagdeciderapp

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    val nameList = arrayListOf(" ", " ", " ", " ", "Kotlin")
    private val changeColor = arrayListOf("#39add1", "#e15258", "#f9845b", "#7d669e", "#838cc7")







    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        decideButton.setOnClickListener{
            val random = Random()
            val randomName = random.nextInt(nameList.count())

            val randomColor = random.nextInt(changeColor.count())
            val color:String = changeColor[randomColor]
            val colorSet:Int = Color.parseColor(color)

            //  winnerText.text="You just won yourself a swag"
            winnerText.text="You just won yourself a swag"  + " - "  + nameList[randomName]
            decideButton.setTextColor(colorSet)
            //    println("it is working")

        }
        ;
        addButton.setOnClickListener{
            val newName = addName.text.toString()
            nameList.add(newName)
            addName.text.clear()


        }










        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
