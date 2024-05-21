package com.lee_idle.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lee_idle.modifierdemo.ui.theme.ModifierDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModifierDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen(){
    // 모디파이어 연결 순서도 결과에 영향을 미친다.
    val modifier = Modifier
        .padding(all = 10.dp)
        .border(width = 2.dp, color = Color.Black)

    val secondModifier = Modifier.height(100.dp)

    Column(
        modifier = Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Hello Compose",
            fontSize = 40.sp,
            modifier = modifier.then(secondModifier), // 여러 모디파이어 동시에 적용하기
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        // 똥개가 귀엽다
        CustomImage(
            image = R.drawable.dog,
            Modifier.padding(16.dp)
                .width(270.dp)
                .clip(shape = RoundedCornerShape(30.dp)))
    }
}

@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier){
    Image(
        painter = painterResource(id = image),
        contentDescription = null,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview(){
    ModifierDemoTheme {
        DemoScreen()
    }
}
