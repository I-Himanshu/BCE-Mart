package com.bce.mart

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun ProfilePage(){
//    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//        Text("This Page Is Under Maintenance",style= MaterialTheme.typography.h3, textAlign = TextAlign.Center)
//    }
    var BCE_POINTS = remember {mutableStateOf(100)}
    Column(modifier = Modifier.padding(horizontal = 2.dp)){
        Column(modifier = Modifier.padding(horizontal = 80.dp)) {
            Spacer(modifier = Modifier.height(80.dp))
            Text(
                text = "Total BCE Points",
                style = MaterialTheme.typography.h5,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "${BCE_POINTS.value} 🪙",
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(50.dp))
            Button(
                onClick = {}, modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.End)
            ) {
                Row {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Add Bank Account",
                        tint = Color.White
                    )
                    Text(text = "Add Bank Account")
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
        Spacer(modifier = Modifier.height(40.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Refer & Earn",
                    tint = Color.White
                )
                Text(text = "\t\tRefer & Earn", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(160.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Track Order",
                    tint = Color.White
                )
                Text(text = "\t\tTrack Order", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(160.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = "Become A Merchant",
                    tint = Color.White
                )
                Text(text = "\t\tBecome A Merchant", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(160.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.DarkGray),
            contentPadding = PaddingValues(vertical = 20.dp)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add A Product",
                    tint = Color.White
                )
                Text(text = "\t\tAdd A Product", fontWeight = FontWeight.ExtraBold)
                Spacer(modifier = Modifier.width(160.dp))
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
    }
}