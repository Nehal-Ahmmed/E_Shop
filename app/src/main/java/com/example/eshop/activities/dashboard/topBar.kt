package com.example.eshop.activities.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.eshop.R

@Preview
@Composable
fun topBar() {
    val horizontalPadding =16.dp
    val verticalPadding= 16.dp

    ConstraintLayout(
        modifier = Modifier.fillMaxWidth().wrapContentHeight()
    ) {
        val(bluebox,title1,title2,profile,building,whiteBox)=createRefs()

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(255.dp)
                .background(color = colorResource(R.color.blue))
                .constrainAs(bluebox){
                    top.linkTo(parent.top)
                }
        )
        Image(
            painter = painterResource(R.drawable.building),
            contentDescription = null,
            modifier = Modifier.constrainAs(building){
                bottom.linkTo(bluebox.bottom)
    }
    )

        Image(
            painter = painterResource(R.drawable.profile),
            contentDescription = null,
            modifier = Modifier
                .padding(horizontal = horizontalPadding, vertical = verticalPadding )
                .constrainAs(profile){
                    top.linkTo(parent.top)
                    end.linkTo(parent.end)
            }
        )

        Text(
            text="Good Morning, Nehal",
            fontSize = 20.sp,
            color= Color.White,
            modifier = Modifier
                .constrainAs(title1){
                    top.linkTo(profile.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )
        Text(
            text="What are you doing , today?",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold ,
            color= Color.White,
            modifier = Modifier
                .constrainAs(title2){
                    top.linkTo(title1.bottom)
                    bottom.linkTo(whiteBox.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        ConstraintLayout(
            modifier = Modifier
                .padding(horizontal = 24.dp)
                .fillMaxWidth()
                .height(110.dp)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .constrainAs(whiteBox){
                    top.linkTo(bluebox.bottom)
                    bottom.linkTo(bluebox.bottom)
                }
                .clip(RoundedCornerShape(10.dp))
        ) {
            val(icon1, icon2, balance, reward, amount, wallet, arrow1, arrow2, arrow3,line1, line2) = createRefs()

            Image(
                painter = painterResource(R.drawable.wallet),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = verticalPadding)
                    .constrainAs(icon1){
                        top.linkTo(parent.top)
                            start.linkTo(parent.start)
                    }
            )

            Text(
                text = "wallet",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(wallet){
                        bottom.linkTo(icon1.bottom)
                        start.linkTo(icon1.end)
                    }
            )

            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier =Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow1){
                        top.linkTo(wallet.top)
                        bottom.linkTo(wallet.bottom)
                        start.linkTo(wallet.end)
                    }
            )
            Image(
                painter = painterResource(R.drawable.medal),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = horizontalPadding, bottom = verticalPadding)
                    .constrainAs(icon2){
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }
            )

            Text(
                text = "reward",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                modifier = Modifier
                    .padding(start = 8.dp)
                    .constrainAs(reward){
                        top.linkTo(icon2.top)
                        start.linkTo(icon2.end)
                    }
            )

            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier =Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow2){
                        top.linkTo(reward.top)
                        bottom.linkTo(reward.bottom)
                        start.linkTo(reward.end)
                    }
            )

            Box(
                modifier = Modifier
                    .width(1.dp)
                    .fillMaxHeight()
                    .padding(vertical = verticalPadding)
                    .background(colorResource(R.color.grey))
                    .constrainAs(line1){
                            centerTo(parent)
                    }
            )
            Box(
                modifier=Modifier
                    .height(1.dp)
                    .width(170.dp)
                    .padding(horizontal = 16.dp)
                    .background(colorResource(R.color.grey))
                    .constrainAs(line2){
                        top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                    }

            )
            Text(
                text = "Balance",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                style = TextStyle(textDecoration = TextDecoration.Underline),
                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 32.dp)
                    .constrainAs(balance){
                        top.linkTo(parent.top)
                        start.linkTo(line1.end)
                    }
            )
            Text(
                text = "150.00 USD",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = horizontalPadding, top = 8.dp)
                    .constrainAs(amount){
                        top.linkTo(balance.bottom)
                        start.linkTo(balance.start)
                    }
            )
            Image(
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                modifier =Modifier
                    .padding(start = horizontalPadding)
                    .constrainAs(arrow3){
                        bottom.linkTo(amount.bottom)
                        start.linkTo(amount.end)
                    }
            )

        }

    }
}
