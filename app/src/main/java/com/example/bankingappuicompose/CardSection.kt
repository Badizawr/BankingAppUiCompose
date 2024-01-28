package com.example.bankingappuicompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bankingappuicompose.data.Card
import com.example.bankingappuicompose.ui.theme.BlueEnd
import com.example.bankingappuicompose.ui.theme.BlueStart
import com.example.bankingappuicompose.ui.theme.GreenEnd
import com.example.bankingappuicompose.ui.theme.GreenStart
import com.example.bankingappuicompose.ui.theme.PurpleEnd
import com.example.bankingappuicompose.ui.theme.PurpleStart
import com.example.bankingappuicompose.ui.theme.RedEnd
import com.example.bankingappuicompose.ui.theme.RedStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "3664 7865 3871 1313",
        cardName = "Businnes",
        balance = 46.137,
        color = getGradient(PurpleStart, PurpleEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "1313 1313 1313 1313",
        cardName = "Savings",
        balance = 6.137,
        color = getGradient(BlueStart, BlueEnd)
    ),
    Card(
        cardType = "VISA",
        cardNumber = "6666 7865 6666 1313",
        cardName = "School",
        balance = 3.137,
        color = getGradient(GreenStart, GreenEnd)
    ),
    Card(
        cardType = "MASTER CARD",
        cardNumber = "666 666 666 666",
        cardName = "Satan",
        balance = 666.13,
        color = getGradient(RedStart, RedEnd)
    )
)
fun getGradient(startColor: Color, endColor: Color): Brush {
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}
@Preview
@Composable
fun CardSection() {
    LazyRow{
        items(cards.size) {index ->
            CardItem(index)
        }
    }
}


@Composable
fun CardItem(index: Int) {
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if (index == cards.size -1) {
        lastItemPaddingEnd = 16.dp
    }
    
    var image = painterResource(id = R.drawable.ic_visa)
    if (card.cardType == "MASTER CARD") {
        image = painterResource(id = R.drawable.ic_mastercard)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ) {
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
                )
        }
    }
}
