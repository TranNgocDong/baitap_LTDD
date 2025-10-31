package com.example.test1112312312312.ui.menu

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.test1112312312312.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationMenuScreen(onSelect: (String) -> Unit) {
    val demos = listOf(
        "Scale Button",
        "Animated Visibility",
        "Content Size",
        "Color Change",
        "Infinite Loading"
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = "Animation Demos",
                        fontWeight = FontWeight.Bold
                    )
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "App Icon",
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Text(
                text = "Chọn loại animation để xem demo",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 18.sp,
                color = Color.Gray
            )

            demos.forEach { name ->
                Button(
                    onClick = { onSelect(name) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = name)
                }
            }
        }
    }
}
