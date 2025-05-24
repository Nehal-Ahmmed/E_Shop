package com.example.eshop.activities.Results

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.example.eshop.R
import com.example.eshop.activities.Map.MapActivity
import com.example.eshop.domain.StoreModel

@Composable
fun PopularSection(list: SnapshotStateList<StoreModel>, showPopularLoading: Boolean) {
    Row(
        Modifier
            .padding(horizontal = 16.dp)
            .padding(top = 16.dp)
    ) {
        Text(
            text ="Popular Stores",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.weight(1f)
        )
        Text(
            text ="See all",
            color = Color.Black,
            fontSize = 16.sp,
            style = TextStyle(textDecoration = TextDecoration.Underline)
        )
    }

    if (showPopularLoading){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }
    }else{

        LazyRow(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp)
        ) {
            items(list.size){index->
                ItemsPopular(item=list[index])
            }
        }
    }
}

@Composable
fun ItemsPopular(item: StoreModel) {
    val context= LocalContext.current
    Column (
        modifier = Modifier
            .padding(vertical = 8.dp)
            .wrapContentSize()
            .background(Color.White, shape = RoundedCornerShape(10.dp))
            .padding(8.dp)
            .clickable{
                val intent = Intent(context, MapActivity::class.java).apply {
                    putExtra("object",item)
                }
                startActivity(context,intent,null)
            }
    ){
        AsyncImage(
            model = item.ImagePath,
            contentDescription = null,
            modifier =  Modifier
                .size(135.dp,90.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(colorResource(R.color.grey), shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.Crop
        )
        Text(
            text=item.Title,
            color=Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier =Modifier.padding(top = 8.dp)
        )
        Row (
            Modifier.padding(top = 8.dp)
        ){
            Image(painter = painterResource(R.drawable.location), contentDescription = null)
            Text(
                text= item.ShortAddress,
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                maxLines = 1,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}
