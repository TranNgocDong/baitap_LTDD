package com.example.test1112312312312.ui.demo

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfiniteLoadingDemo(onBack: () -> Unit) {
    Scaffold(
        //Thanh Tiêu Đề cùng nút quay lại
        topBar = {
            TopAppBar(
                title = { Text("Infinite Loading Animation") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentAlignment = Alignment.Center
        ) {
            // 3 chấm nhảy liên tục (hiệu ứng loading)
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val circleColors = listOf(
                    Color(0xFF2196F3), // xanh dương
                    Color(0xFFFF9800), // cam
                    Color(0xFF4CAF50)  // xanh lá
                )
                val delays = listOf(0, 200, 400)

                //Phần chính của code
                /* rememberInfiniteTransition() là hàm trong compose dùng để tạo và quản lí
                hiệu ứng động cho nó chạy liên tục, kết hợp với animateFloat(.....) để cho giá trị
                thay đổi liên tục */
                circleColors.forEachIndexed { index, color ->
                    val infiniteTransition = rememberInfiniteTransition()
                    val scale by infiniteTransition.animateFloat(
                        initialValue = 0.5f,
                        targetValue = 1.2f,
                        //infiniteRepeatable() Giúp animation chạy mãi mãi
                        animationSpec = infiniteRepeatable(
                            // tween () Định nghĩa thời gian, tốc độ, kiểu chuyển động.
                            animation = tween(
                                durationMillis = 600,
                                delayMillis = delays[index],
                                easing = FastOutSlowInEasing
                            ),
                            //RepeatMode.Reverse giúp đảo chiều mượt.
                            repeatMode = RepeatMode.Reverse
                        )
                    )

                    Box(
                        modifier = Modifier
                            .size(24.dp * scale)
                            .background(color, CircleShape)
                    )
                }
            }
        }
    }
}
