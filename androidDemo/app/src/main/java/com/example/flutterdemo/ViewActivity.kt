package com.example.flutterdemo

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor


class ViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        findViewById<View>(R.id.show_view).setOnClickListener{
            val flutterView = FlutterView(ViewActivity@this)
            val lp: FrameLayout.LayoutParams = FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            val engine = FlutterEngine(applicationContext)
            engine.dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
            var flutterViewEngine = FlutterViewEngine(engine)
            flutterViewEngine.attachToActivity(this)
            flutterViewEngine.attachFlutterView(flutterView)
            val flContainer: FrameLayout = findViewById(R.id.container_view)
            flContainer.addView(flutterView, lp)

        }
    }
}