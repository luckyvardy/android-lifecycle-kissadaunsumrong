package com.example.android_lifecycle

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        Log.i("ShowLog","OnCreate")

        bottonwellcome.setOnClickListener{View ->
            Snackbar.make( View, "Pracharat", Snackbar.LENGTH_LONG)
                .setAction("ac", null).show()
            var wc = Intent(this,WelcomeActivity::class.java)
            startActivity(wc)

        }

        fab.setOnClickListener { view ->
 //           Snackbar.make(view, "Show Snackbar", Snackbar.LENGTH_LONG)
   //            .setAction("Action", null).show()
            Toast.makeText(this, "Show Toast", Toast.LENGTH_LONG).show()

        }
    }


    override fun onStart(){
        super.onStart()
        Log.i("ShowLog","OnStart")
    }



    override fun onResume(){
        super.onResume()
        Log.i("ShowLog","resume")
    }

    override fun  onPause(){
        super. onPause()
        Log.i("ShowLog","onPause")
    }

    override fun  onStop(){
        super. onStop()
        Log.i("ShowLog","onStop")
    }
    override fun  onDestroy(){
        super. onDestroy()
        Log.i("ShowLog","onDestroy")
    }
    override fun  onRestart(){
        super. onRestart()
        Log.i("ShowLog","onRestart")
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings ->{
                var sc = Intent(this,SettingActivity::class.java)
                startActivity(sc)
                return true
            }
            else -> super.onOptionsItemSelected(item)

        }
    }
}
