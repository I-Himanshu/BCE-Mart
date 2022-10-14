package com.bce.mart

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun LaptopUI(laptop: Laptop) {
    var isExpended by remember {
        mutableStateOf(false)
    }
    var isFavorite by remember {
        mutableStateOf(laptop.isFav)
    }

    Spacer(modifier = Modifier.height(10. dp))
    Card(modifier = Modifier
        .padding(all = 20. dp), elevation = 18. dp) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp, horizontal = 20.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Box(contentAlignment = Alignment.TopEnd) {
                Image(
                    painter = painterResource(id = laptop.Img), contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                )

                IconToggleButton(
                    checked = isFavorite,
                    onCheckedChange = {
                        isFavorite = !isFavorite
                        laptop.isFav = isFavorite
                    }
                ) {
                    Icon(
                        tint = Color.Red,
                        imageVector =
                        if (isFavorite) Icons.Filled.Favorite
                        else Icons.Default.FavoriteBorder,
                        contentDescription = null
                    )
                }
            }

            Text(laptop.name, style = MaterialTheme.typography.h5, textAlign = TextAlign.Center)
            Text("₹${laptop.price}", style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.secondary)
            Spacer(modifier = Modifier.height(20. dp))

            if (isExpended) {
                Text(laptop.desc, style = MaterialTheme.typography.body2)
                Button(onClick = {
                    isExpended = !isExpended
                }, colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)) {
                    Text("Show Less")
                }
            } else {
                Button(onClick = {
                    isExpended = !isExpended
                }) {
                    Text("View More")
                }
            }
        }
    }
}
