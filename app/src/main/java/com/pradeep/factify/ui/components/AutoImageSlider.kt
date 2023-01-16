package com.pradeep.factify.ui.components

import android.graphics.drawable.shapes.RoundRectShape
import androidx.compose.animation.*
import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState


@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun AutoImageSlider(
    list: List<AutoImageSliderData>
) {

    val pagerState = rememberPagerState(initialPage = 0)
    val page=pagerState.currentPage


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        backgroundColor = Color.Transparent.copy(0.3f),
        border = BorderStroke(2.dp, color = Color.White.copy(0.5f)),
        shape = RoundedCornerShape(4.dp)
    ) {
            Column(modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {
                HorizontalPager(
                    state = pagerState, count = list.size
                ) { page ->
                    Card(
                        modifier= Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                        shape = RoundedCornerShape(4.dp)
                    ) {
                        AsyncImage(
                            model = list[page].imgUrl,
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                }

                AnimatedContent(targetState = page,
                    transitionSpec ={
                        //new value enter trans
                        //old value exit trans
                        slideInVertically { fullHeight -> -fullHeight } + fadeIn(
                            spring(visibilityThreshold = 200f)
                        ) with
                                fadeOut(
                                    spring(visibilityThreshold = 200f)
                                )
                    }
                ) {
                    Text(
                        modifier=Modifier.padding(4.dp),
                        text = list[page].text ,
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary,
                        textAlign = TextAlign.Center
                    )
                }

                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    spacing = 6.dp,
                    indicatorWidth = 7.dp,
                    activeColor = Color.White,
                    inactiveColor = Color.White.copy(alpha = 0.3f)
                )
            }

    }
}

data class AutoImageSliderData(
    val imgUrl: String,
    val text: String,
    val clickUrl: String? = null
)