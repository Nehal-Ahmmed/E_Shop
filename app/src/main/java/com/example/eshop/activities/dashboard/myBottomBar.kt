package com.example.eshop.activities.dashboard

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eshop.R

@Composable
@Preview

fun myBottomBar(){
    val BottomMenuItemList= PrepareBottomMenu()
    val context= LocalContext.current
    var selected by remember { mutableStateOf("Home") }

    BottomAppBar(
        modifier=Modifier.wrapContentHeight(),
        backgroundColor = colorResource(R.color.white)
        , elevation =3.dp
    ) {
        BottomMenuItemList.forEach{ bottomMenuItem ->
            BottomNavigationItem(
                selected=(selected==bottomMenuItem.lebel),
                onClick = {
                    selected=bottomMenuItem.lebel
                    Toast.makeText(context,bottomMenuItem.lebel, Toast.LENGTH_SHORT).show()
                }, icon = {
                    Column (
                        horizontalAlignment = Alignment.CenterHorizontally
                    ){
                        Icon(
                            painter = bottomMenuItem.icon,
                            contentDescription = null,
                            tint = colorResource(R.color.darkBrown),
                            modifier = Modifier
                                .padding(top = 8.dp)
                                .size(20.dp)
                            )
                        Text(
                            text = bottomMenuItem.lebel,
                            fontSize = 12.sp,
                            color = colorResource(R.color.darkBrown),
                            modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                }
            )
        }
    }
}

data class BottomMenuItem(
    val lebel: String, val icon: Painter
)

@Composable
fun PrepareBottomMenu(): List<BottomMenuItem>{
val bottomMenuItemList= arrayListOf<BottomMenuItem>()

    bottomMenuItemList.add(BottomMenuItem("Home",icon= painterResource(R.drawable.btn_1)))
    bottomMenuItemList.add(BottomMenuItem("Support",icon= painterResource(R.drawable.btn_2)))
    bottomMenuItemList.add(BottomMenuItem("Wishlist",icon= painterResource(R.drawable.btn_3)))
    bottomMenuItemList.add(BottomMenuItem("Profile",icon= painterResource(R.drawable.btn_4)))

    return bottomMenuItemList
}