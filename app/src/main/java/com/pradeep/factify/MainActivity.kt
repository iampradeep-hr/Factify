package com.pradeep.factify

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.pradeep.factify.demo.Animations1
import com.pradeep.factify.ui.components.AutoImageSlider
import com.pradeep.factify.ui.components.AutoImageSliderData
import com.pradeep.factify.ui.components.HomeTopBar
import com.pradeep.factify.ui.components.ScreenBg
import com.pradeep.factify.ui.theme.FactifyTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FactifyTheme {


                val scrollState = rememberScrollState()
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {



                    ScreenBg(
                        imageUrl = "https://cdn.pixabay.com/photo/2017/03/25/03/18/white-2172682_960_720.jpg",
                        blur = 5.dp
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .scrollable(scrollState, Orientation.Vertical)
                            .background(Color.Transparent.copy(0.5f))
                    ) {

                        HomeTopBar()

                        Text(
                            text = "Todays",
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onPrimary,
                            modifier = Modifier.padding(8.dp)
                        )


                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            val list = listOf<AutoImageSliderData>(
                                AutoImageSliderData(
                                    "https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/02/a0002031/img/basic/a0002031_main.jpg?20201014175156",
                                    "THINGS THAT MAKE JAPAN DIFFERENT THAN REST OF THE WORLD!",
                                ),
                                AutoImageSliderData(
                                    "https://images.arigatotravel.com/wp-content/uploads/2019/07/27234538/shutterstock_561957529.jpg",
                                    "Fake, plastic menu items in front of restaurants that looks just like real food.",
                                ),
                                AutoImageSliderData(
                                    "https://i.pinimg.com/736x/e9/8d/5a/e98d5a5788893b9846455e946e058936.jpg",
                                    "Most streets in Japan have no name."
                                ),
                                AutoImageSliderData(
                                    "https://i0.wp.com/post.medicalnewstoday.com/wp-content/uploads/sites/3/2022/06/left_sided_colitis_bag_walking_1296x728_header-1024x575.jpg?w=1155&h=1528",
                                    "If you lose your wallet or shopping bag, the probability for getting back again is 90%!"
                                ),
                                AutoImageSliderData(
                                    "https://vinepair.com/wp-content/uploads/2016/07/braille-beer-social.jpg",
                                    "Blind people now can know what's inside drinking cans by braille written on top of can."
                                ),
                                AutoImageSliderData(
                                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQQFaVIfCPgUYKtEWSFfyIggCbCOlSJ4p1bNQ&usqp=CAU",
                                    "Drainage Canals in Japan are so clean they even have Koi Fish in it."
                                ),

                                )
                            AutoImageSlider(list = list)

                        }


                    }

                }


            }
        }
    }
}









