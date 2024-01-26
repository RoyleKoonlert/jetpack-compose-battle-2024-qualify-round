package com.github.thailandandroiddeveloper.common.ui.screen.qualify1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify1Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        TopAppBar(
            title = {},
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_menu),
                    contentDescription = "Menu",
                    tint = Color.Unspecified
                )
            },
            actions = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_1_profile),
                    contentDescription = "Account",
                    tint = Color.Unspecified
                )
            }
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 16.dp,
                    bottom = 48.dp
                )
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        bottom = 24.dp
                    )
                    .clip(RoundedCornerShape(16.dp)),
                painter = painterResource(id = R.drawable.img_qualify_1_profile),
                contentDescription = "image description",
            )
            Box(
                modifier = Modifier
                    .padding(
                        bottom = 24.dp
                    )
                    .align(Alignment.BottomCenter)
                    .clip(
                        RoundedCornerShape(
                            bottomStart = 16.dp,
                            bottomEnd = 16.dp
                        )
                    )
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.75f)
                    ),
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            start = 20.dp,
                            end = 20.dp,
                            top = 20.dp,
                            bottom = 40.dp
                        )
                ) {
                    Text(
                        style = MaterialTheme.typography.headlineMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        text = "John Doe"
                    )
                    Spacer(modifier = Modifier.padding(bottom = 8.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_qualify_1_gender_male),
                            contentDescription = "Gender Male",
                            tint = Color.Unspecified
                        )
                        Text(
                            modifier = Modifier.padding(start = 8.dp),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onPrimary,
                            text = "Male",
                        )
                    }
                    Spacer(modifier = Modifier.padding(bottom = 8.dp))
                    Text(
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary,
                        text = "Lorem ipsum dolor sit amet, cd nulla lacinia, quis fringilla lorem imperdiet. Proin in quam vel odio iaculis fringilla.",
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.Center
//                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    modifier = Modifier
                        .size(width = 120.dp, height = 48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.errorContainer,
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_1_thumb_down),
                        contentDescription = "Gender Male",
                        tint = Color.Unspecified
                    )
                }
                Spacer(modifier = Modifier.size(43.dp))
                Button(
                    modifier = Modifier
                        .size(width = 120.dp, height = 48.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                    ),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_qualify_1_thumb_up),
                        contentDescription = "Gender Male",
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify1ScreenPreview() = AppTheme {
    Qualify1Screen()
}
// endregion