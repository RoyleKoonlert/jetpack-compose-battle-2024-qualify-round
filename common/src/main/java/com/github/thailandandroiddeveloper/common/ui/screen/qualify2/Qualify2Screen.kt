package com.github.thailandandroiddeveloper.common.ui.screen.qualify2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@Composable
fun Qualify2Screen() {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.onPrimary,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 8.dp,
                        top = 8.dp
                    ),
                horizontalArrangement = Arrangement.End
            ) {
                TextButton(
                    modifier = Modifier
                        .height(40.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Skip")
                }
            }
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.primaryContainer)
                    .fillMaxWidth()
                    .padding(
                        horizontal = 80.dp,
                        vertical = 31.dp
                    )
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Text(text = "Next")
                }
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .padding(
                    horizontal = 32.dp
                ),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 15.dp),
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onSurface,
                text = "Lorem ipsum dolor sit amet",
                textAlign = TextAlign.Center,
            )
            Text(
                modifier = Modifier
                    .padding(top = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center,
//                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec egestas dictum lacinia. Integer arcu neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla",
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing \nelit. Donec egestas dictum lacinia. Integer arcu\n neque, porttitor ac metus quis, iaculis molestie magna. Vivamus molestie justo sed nulla lacinia, \nquis fringilla lorem imperdiet. Proin in quam vel odio \niaculis fringilla",
            )
            ImagePager(
                images = listOf(
                    R.drawable.img_qualify_2_onboard,
                    R.drawable.img_qualify_2_onboard,
                    R.drawable.img_qualify_2_onboard,
                    R.drawable.img_qualify_2_onboard,
                    R.drawable.img_qualify_2_onboard,
                )
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ImagePager(images: List<Int>) {
    val pagerState = rememberPagerState(
        pageCount = {
            images.size
        },
        initialPage = 3
    )

    Column(
        modifier = Modifier
            .padding(
                top = 4.dp
            ),
    ) {
        HorizontalPager(
            state = pagerState,
            pageSpacing = 32.dp,
            modifier = Modifier
                .padding(
                    vertical = 32.dp
                )
        ) { page ->
            Image(
                painter = painterResource(id = images[page]),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp)),
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.primaryContainer

                val modifier = Modifier
                    .padding(
                        horizontal = 4.dp,
                    )

                Box(
                    modifier = if (pagerState.currentPage == iteration) {
                        modifier
                            .clip(RoundedCornerShape(16.dp))
                            .background(color)
                            .size(
                                width = 32.dp,
                                height = 16.dp
                            )
                    } else {
                        modifier
                            .clip(CircleShape)
                            .background(color)
                            .size(16.dp)
                    }
                )
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify2ScreenPreview() = AppTheme {
    Qualify2Screen()
}
// endregion