package com.example.flutterdemo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import io.flutter.embedding.android.FlutterFragment


class FlutterFragmentActivity : AppCompatActivity() {

    private val TAG_FLUTTER_FRAGMENT = "flutter_fragment"

    // Declare a local variable to reference the FlutterFragment so that you
    // can forward calls to it later.
    private var flutterFragment: FlutterFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_fragment)
        findViewById<View>(R.id.show_fragment).setOnClickListener{
            val fragmentManager: FragmentManager = supportFragmentManager
            flutterFragment = fragmentManager.findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?
            if (flutterFragment == null) {
                flutterFragment =  FlutterFragment.withCachedEngine("main").build()
                fragmentManager
                    .beginTransaction()
                    .add(
                        R.id.container_fragment,
                        flutterFragment!!,
                        TAG_FLUTTER_FRAGMENT
                    )
                    .commit()
            }
        }
    }
}