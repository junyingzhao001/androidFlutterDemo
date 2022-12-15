package com.example.flutterdemo

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.flutterdemo.comm.FlutterAppActivity
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<View>(R.id.btn_start_ativity).setOnClickListener {
//            var intent =  FlutterActivity.createDefaultIntent(MainActivity@ this)
//            startActivity(intent)
            startActivity(FlutterActivity.withCachedEngine("main").build(MainActivity@ this))
        }
        findViewById<View>(R.id.btn_create_view).setOnClickListener{
            startActivity(Intent(MainActivity@this,ViewActivity::class.java))
        }

        findViewById<View>(R.id.btn_fragmet_view).setOnClickListener{
            startActivity(Intent(MainActivity@this,FlutterFragmentActivity::class.java))
        }


        findViewById<View>(R.id.btn_basic_message_channel).setOnClickListener{
            FlutterAppActivity.start(this@MainActivity, "测试", 1)
        }



        findViewById<View>(R.id.btn_basic_event_channel).setOnClickListener{
            FlutterAppActivity.start(this@MainActivity, "测试", 2)
        }



        findViewById<View>(R.id.btn_basic_method_channel).setOnClickListener{
            FlutterAppActivity.start(this@MainActivity, "测试", 3)
        }


        findViewById<View>(R.id.btn_basic_anim).setOnClickListener{
            FlutterAppActivity.start(this@MainActivity, "测试", 4)
        }






    }
}