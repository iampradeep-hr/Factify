package com.pradeep.factify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.pradeep.factify.ui.components.AutoImageSlider
import com.pradeep.factify.ui.components.AutoImageSliderData
import com.pradeep.factify.ui.theme.FactifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactifyTheme {

                Box(modifier = Modifier.fillMaxWidth().wrapContentHeight()){
                    val list= listOf<AutoImageSliderData>(
                        AutoImageSliderData(
                            "https://live.staticflickr.com/1910/43420152810_24eca2488e_b.jpg",
                            "Man stunned to learn random dog he spotted online is actually related to his own pup",
                        ),
                        AutoImageSliderData(
                            "https://developer.android.com/static/images/jetpack/compose/graphics-sourceimageland.jpg",
                            "sample text 2",
                        ),
                        AutoImageSliderData(
                            "https://cdn.sanity.io/images/rqbxxjr2/production/d0e1439679d3fc1f9adeaae9a27f3cdbf8c07a5e-1080x884.jpg?w=800",
                            "Tate became highly prominent in 2022 by encouraging members of Hustler's University to post large amounts of videos of him to social media platforms in an effort to maximize engagement. As of August 2022, its website had amassed over 100,000 subscribers",
                        ),

                    )
                    AutoImageSlider(list = list)

                }


            }
        }
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedVisibilityExample() {
    Column (modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center){
        val isVisible= remember {
            mutableStateOf(false)
        }
        AnimatedVisibility(
            visible = isVisible.value,
            enter =  slideIn(initialOffset = {IntOffset(-500,-500)}),
            exit = slideOut(targetOffset = {IntOffset(-500,-500)})
        ) {
            Text(text = "Hello World", fontSize = MaterialTheme.typography.h3.fontSize)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(onClick = {isVisible.value=!isVisible.value}) {

        }
    }
}






