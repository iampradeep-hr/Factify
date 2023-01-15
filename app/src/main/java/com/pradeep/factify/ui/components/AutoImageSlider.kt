package com.pradeep.factify.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.google.accompanist.pager.*


@OptIn(ExperimentalPagerApi::class)
@Composable
fun AutoImageSlider(
    modifier: Modifier = Modifier,
    list: List<AutoImageSliderData>
) {

    val pagerState = rememberPagerState(initialPage = 0)
    val page=pagerState.currentPage

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Box(modifier = Modifier.fillMaxWidth()){
            HorizontalPager(
                state = pagerState, count = list.size
            ) { page ->
                Card(
                    modifier=Modifier.fillMaxWidth().height(150.dp)
                        .border(BorderStroke(1.dp, Color.DarkGray), shape = RoundedCornerShape(4.dp)),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    AsyncImage(
                        model = list[page].imgUrl,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                }
            }

        }
        Text(modifier=Modifier.padding(4.dp),
            text = list[page].text, style = MaterialTheme.typography.h2)

        HorizontalPagerIndicator(
            pagerState = pagerState,
            spacing = 4.dp,
            indicatorWidth = 5.dp,
            activeColor = MaterialTheme.colors.primary,
            inactiveColor = MaterialTheme.colors.primary.copy(alpha = 0.5f)
        )

    }


}


data class AutoImageSliderData(
    val imgUrl: String,
    val text: String,
    val clickUrl: String? = null
)