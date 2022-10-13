package com.bce.mart


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.bce.mart.ui.theme.BCEMartTheme
import kotlinx.coroutines.launch

data class Laptop(
    val name: String,
    val price: Int,
    @DrawableRes val Img: Int,
    val desc: String,
    var isFav: Boolean = false
)
val LaptopArray: List < Laptop > = listOf(
    Laptop(
        name = "HP 15S-EQ2144AU AMD Ryzen 5 5500U",
        price = 46500,
        Img = R.drawable.eq2144au,
        desc = "Memory and storage: 8GB and 512GB SSD HDD capacity\n" +
                "Processor: AMD Ryzen 5 5500U\n" +
                "Operating System: Pre-loaded Windows 11\n" +
                "Display: 14 Inches screen with 1920 x 1080 Pixels resolution\n" +
                "Weight: 1.69 Kg\n" +
                "Warranty: 1 Year from the manufacturer from the date of purchase"
    ),
    Laptop(
        name = "Acer Aspire Vero (AV15-51)",
        price = 49990,
        Img = R.drawable.acer_aspire_vero,
        desc = "Display size:\t15.60-inch\n" +
                "Display resolution:\t1920x1080 pixels\n" +
                "Processor:\tCore i5\n" +
                "RAM:\t8GB\n" +
                "OS:\tWindows 11\n" +
                "SSD:\t512GB\n" +
                "Graphics:\tIntel IRIS Graphics\n" +
                "Weight:\t1.80 kg"
    ),
    Laptop(
        name = "Lenovo ThinkPad E480",
        price = 46990,
        Img = R.drawable.lenovo_thinkpad_e480,
        desc = "Display size:\t14.00-inch\n" +
                "Display resolution:\t1920x1080 pixels\n" +
                "Processor:\tCore i7\n" +
                "RAM:\t16GB\n" +
                "OS:\tWindows 10\n" +
                "Hard disk:\t500GB\n" +
                "SSD:\tNo\n" +
                "Weight:\t1.75 kg"
    ),
    Laptop(
        name = "Samsung ChromeBook Plus XE521QAB-K01US",
        price = 46253,
        Img = R.drawable.samsung_chromebook_plus_xe521qab_k01us,
        desc = "Display size:\t12.50-inch\n" +
                "Display resolution:\t1366x768 pixels\n" +
                "Processor:\tCeleron Dual Core\n" +
                "RAM:\t4GB\n" +
                "OS:\tChrome OS\n" +
                "Hard disk:\tNo\n" +
                "SSD:\t32GB\n" +
                "Weight:\t1.32 kg"
    ),
    Laptop(
        name = "Acer Aspire 7 (2021)",
        price = 45890,
        Img = R.drawable.acer_aspire_7_db,
        desc = "Display size:\t15.60-inch\n" +
                "Display resolution:\t1920x1080 pixels\n" +
                "Touchscreen:\tNo\n" +
                "Processor:\tRyzen 5000 Series\n" +
                "RAM:\t8GB\n" +
                "OS:\tWindows 10 Home\n" +
                "Hard disk:\tNo\n" +
                "SSD:\t512GB\n" +
                "Graphics:\tNvidia GeForce GTX 1650\n" +
                "Weight:\t2.15 kg"
    )
)


class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle ? ) {
        super.onCreate(savedInstanceState)
        setContent {
            BCEMartTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Main()
                }
            }
        }
    }
}

@Composable
fun Main() {
    val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))
    val coroutineScope = rememberCoroutineScope()
    val selectedIndex = remember {
        mutableStateOf(0)
    }
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.app_name), color = Color.White)
                },
                backgroundColor = MaterialTheme.colors.primary,
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = "Menu",
                        modifier = Modifier.clickable(onClick = {
                            coroutineScope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }),
                        tint = Color.White
                    )
                }
            )
        },
        content = {
            Spacer(modifier = Modifier.height(40. dp))
            if (selectedIndex.value == 0) {
                ShowAllLaptop()
            } else if (selectedIndex.value == 1) {
                ShowFavoriteLaptops()
            } else {
//                ShowFavoriteLaptops()
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Text("This Page Is Under Maintenance",style=MaterialTheme.typography.h3, textAlign = TextAlign.Center)
                }
            }
        },
        bottomBar = {
            BottomBar(selectedIndex)
        },
        drawerContent = {
            DrawerContent()
        }
    )
}

@Composable
fun DrawerContent() {
    Column( modifier = Modifier.padding(10.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.bce_logo), contentDescription = "Bce Bakhtiyarpur Logo", modifier = Modifier.height(100.dp))
            Spacer(modifier = Modifier.width(33.dp))
            Text("BCE Mart", style = MaterialTheme.typography.h4, color = Color.Magenta, fontWeight = FontWeight.ExtraBold)
        }

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End)) {
            Row {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home",
                    tint = Color.White
                )
                Text(text = " Home")
            }
        }

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End)) {
            Row {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "Favorite",
                    tint = Color.White
                )
                Text(text = " Favorite")
            }
        }

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End)) {
            Row {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Purchase All",
                    tint = Color.White
                )
                Text(text = "Go To Cart")
            }
        }

        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End)) {
            Row {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Login",
                    tint = Color.White
                )
                Text(text = " Login")
            }
        }
        Button(onClick = {}, modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.End)) {
            Row {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.White
                )
                Text(text = " Settings")
            }
        }
    }
}


@Composable
fun ShowAllLaptop() {
    Column(modifier = Modifier
        .padding(horizontal = 10.dp)
        .verticalScroll(rememberScrollState())) {
        for (laptop in LaptopArray) {
            LaptopUI(laptop = laptop)
        }
        Spacer(modifier = Modifier.height(40. dp))
    }
}


@Composable
fun ShowFavoriteLaptops() {
    var totalPrice:Int = 0
    Column(modifier = Modifier
        .padding(horizontal = 10.dp)
        .verticalScroll(rememberScrollState())) {
        for (laptop in LaptopArray) {
            if (laptop.isFav){
                LaptopUI(laptop = laptop)
                totalPrice += laptop.price
            }
        }
        if(totalPrice>0){
            Text("Total Price: ${totalPrice}", style = MaterialTheme.typography.h4, color = Color.DarkGray)

            Button(onClick = {}, modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End)) {
                Row {
                    Icon(
                        imageVector = Icons.Default.ShoppingCart,
                        contentDescription = "Purchase All",
                        tint = Color.White
                    )
                    Text(text = "Purchase All")
                }
            }
        }else{
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text("Your favorite list is empty",style=MaterialTheme.typography.h3, textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier.height(80. dp))
    }
}

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


@Composable
fun BottomBar(selectedIndex: MutableState < Int > ) {

    BottomNavigation(elevation = 10. dp) {

        BottomNavigationItem(icon = {
            Icon(imageVector = Icons.Default.Home, "")
        },
            label = {
                Text(text = "Home")
            },
            alwaysShowLabel = false,
            selected = (selectedIndex.value == 0),
            onClick = {
                selectedIndex.value = 0
            })

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Favorite, "")
            },
            label = {
                Text(text = "Favorite")
            },
            alwaysShowLabel = false,
            selected = (selectedIndex.value == 1),
            onClick = {
                selectedIndex.value = 1
            })

        BottomNavigationItem(
            icon = {
                Icon(imageVector = Icons.Default.Person, "")
            },
            label = {
                Text(text = "Profile")
            },
            alwaysShowLabel = false,
            selected = (selectedIndex.value == 2),
            selectedContentColor = Color.White,
            onClick = {
                selectedIndex.value = 2

            }
        )
    }
}