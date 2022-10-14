package com.bce.mart

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun DrawerContent() {
    Column(modifier = Modifier.padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.bce_logo),
                contentDescription = "Bce Bakhtiyarpur Logo",
                modifier = Modifier.height(100.dp)
            )
            Spacer(modifier = Modifier.width(33.dp))
            Text(
                "BCE Mart",
                style = MaterialTheme.typography.h4,
                color = Color.Magenta,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White
                )
                Text(text = " Home")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.White
                )
                Text(text = " Favorite")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Purchase All",
                    tint = Color.White
                )
                Text(text = "Go To Cart")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
                Text(text = " Settings")
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Login",
                    tint = Color.White
                )
                Text(text = " Login")
            }
        }

        Spacer(modifier = Modifier.height(240.dp))

        Button(
            onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End).fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
        ) {
            Row {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    contentDescription = "Exit",
                    tint = Color.White
                )
                Text(text = " Logout")

            }
        }
    }
}
