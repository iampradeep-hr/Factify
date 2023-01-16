package com.pradeep.factify.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun ScreenBg(
    imageUrl:String,
    blur:Dp
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .blur(blur, BlurredEdgeTreatment.Rectangle)){
        AsyncImage(model = imageUrl, contentDescription = null,
            contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
    }
}