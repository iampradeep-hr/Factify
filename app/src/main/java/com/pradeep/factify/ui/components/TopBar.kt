package com.pradeep.factify.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeTopBar() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(50.dp)
        .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
        .background(Color.Transparent.copy(0.5f))
    ) {


    }


}