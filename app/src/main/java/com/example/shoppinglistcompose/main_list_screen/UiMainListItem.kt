package com.example.shoppinglistcompose.main_list_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.shoppinglistcompose.R
import com.example.shoppinglistcompose.ui.theme.MyGreen
import com.example.shoppinglistcompose.ui.theme.MyRed

@Composable
fun UiMainListItem() {
    ConstraintLayout(
        modifier = Modifier.padding(
            start = 4.dp, top = 16.dp, end = 4.dp
        )
    ) {
        val (card, deleteButton, editButton, progressCounter) = createRefs()
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(card) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "Title",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                )
                Text(
                    text = "12/12/2023 13:00",
                    style = TextStyle(
                        color = Color.DarkGray,
                        fontSize = 12.sp
                    )
                )
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 5.dp)
                )
            }
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(deleteButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.top)
                    end.linkTo(card.end)
                }
                .padding(end = 10.dp)
                .size(32.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.delete_icon),
                contentDescription = "delete icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MyRed)
                    .padding(5.dp),
                tint = Color.White
            )
        }

        IconButton(
            onClick = {},
            modifier = Modifier
                .constrainAs(editButton) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.top)
                    end.linkTo(deleteButton.start)
                }
                .padding(end = 5.dp)
                .size(32.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.edit_icon),
                contentDescription = "edit icon",
                modifier = Modifier
                    .clip(CircleShape)
                    .background(MyGreen)
                    .padding(5.dp),
                tint = Color.White
            )
        }

        Card(
            shape = RoundedCornerShape(5.dp),
            modifier = Modifier
                .constrainAs(progressCounter) {
                    top.linkTo(card.top)
                    bottom.linkTo(card.top)
                    end.linkTo(editButton.start)
                }
                .padding(end = 5.dp)
        ) {
            Text(
                text = "3/4",
                modifier = Modifier
                    .background(MyRed)
                    .padding(
                        start = 5.dp,
                        end = 5.dp,
                        top = 4.dp,
                        bottom = 4.dp
                    ),
                color = Color.White
            )
        }

    }
}