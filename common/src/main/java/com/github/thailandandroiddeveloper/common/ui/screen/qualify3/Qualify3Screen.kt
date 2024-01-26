package com.github.thailandandroiddeveloper.common.ui.screen.qualify3

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.github.thailandandroiddeveloper.common.R
import com.github.thailandandroiddeveloper.common.ui.preview.Pixel7
import com.github.thailandandroiddeveloper.common.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Qualify3Screen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onPrimary)
    ) {
        TopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
            ),
            title = {
                Text(
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    text = "John Doe"
                )
            },
            navigationIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_back),
                    contentDescription = "Back",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            },
            actions = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_copy),
                    contentDescription = "Copy",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_calendar),
                    contentDescription = "Calendar",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
                Icon(
                    painter = painterResource(id = R.drawable.ic_qualify_3_menu),
                    contentDescription = "Menu",
                    tint = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        )

        ImagePager(
            images = listOf(
                R.drawable.img_qualify_3_photo_1,
                R.drawable.img_qualify_3_photo_2,
                R.drawable.img_qualify_3_photo_3,
            )
        )

        var tagSelectedPosition by remember {
            mutableIntStateOf(0)
        }

        LazyRow(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                )
        ) {
            items(4) { index ->
                val color = if (index == tagSelectedPosition) {
                    MaterialTheme.colorScheme.primary
                } else {
                    MaterialTheme.colorScheme.outline
                }
                AssistChip(
                    modifier = Modifier
                        .width(68.dp),
                    colors = AssistChipDefaults.assistChipColors(
                        labelColor = color,
                    ),
                    border = AssistChipDefaults.assistChipBorder(
                        borderColor = color,
                    ),
                    onClick = {
                        tagSelectedPosition = index
                    },
                    label = {
                        Text(
                            text = "Tag ${index + 1}",
                        )
                    })
                Spacer(modifier = Modifier.width(8.dp))
            }
        }

        val messageList = listOf(
            MessageItem(
                name = "Lorem Ipsum",
                message = "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo consectetur. Sed congue blandit nibh.",
                image = R.drawable.img_qualify_3_sender,
            ),
            MessageItem(
                name = "Lorem Ipsum",
                message = "Morbi sed sagittis justo, at pulvinar ipsum. Praesent massa metus, interdum at suscipit a, interdum vel orci. Pellentesque in sapien. Integer faucibus mauris ac luctus aliquam accumsan.",
                image = R.drawable.img_qualify_3_sender,
            ),
            MessageItem(
                name = "Lorem Ipsum",
                message = "Duis dignissim pulvinar lectus imperdiet tempus. Curabitur fringilla commodo.",
                image = R.drawable.img_qualify_3_sender,
            ),
            MessageItem(
                name = "Lorem Ipsum",
                message = "Ut hendrerit neque nec accumsan hendrerit. Fusce lobortis rhoncus erat, a blandit nibh molestie vel. Cras commodo ligula ex, vitae venenatis lacus facilisis eget.",
                image = R.drawable.img_qualify_3_sender,
            ),
        )

        LazyColumn {
            items(messageList.size) { index ->
                MessageCardView(
                    messageList[index]
                )
            }
        }
    }
}

data class MessageItem(
    val name: String,
    val message: String,
    @DrawableRes
    val image: Int,
)

@Composable
fun MessageCardView(item: MessageItem) {
    Card(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp,
            )
            .height(96.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(size = 16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
        ),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .clip(CircleShape)
                    .width(48.dp),
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 8.dp,
                    )
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Text(
                    text = item.message
                    ,style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                )
            }
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
    )

    HorizontalPager(
        pageSize = PageSize.Fixed(160.dp),
        state = pagerState,
        pageSpacing = 16.dp,
        contentPadding = PaddingValues(
            start = 16.dp,
            end = 16.dp,
            top = 16.dp,
            bottom = 8.dp
        ),
    ) { page ->

        val borderColor = if (pagerState.currentPage == page) {
            MaterialTheme.colorScheme.primary
        } else {
            MaterialTheme.colorScheme.primaryContainer
        }

        val shape = RoundedCornerShape(size = 16.dp)
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            modifier = Modifier
                .border(
                    width = 2.dp,
                    color = borderColor,
                    shape = shape
                )
                .clip(shape),
        )
    }
}

// region Read-only because we use this to process your score.
@Composable
@Preview(group = Pixel7.name, device = Pixel7.spec, showBackground = true)
fun Qualify3ScreenPreview() = AppTheme {
    Qualify3Screen()
}
// endregion