package com.example.test1112312312312

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import com.example.test1112312312312.ui.theme.Test1112312312312Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Test1112312312312Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    AnimationNavHost()
                }
            }
        }
    }
}
