package ArtSpace_10121075.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.R
import ArtSpace_10121075.example.artspace.ui.theme.ArtSpaceTheme
//import java.util.ListResourceBundle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var currentImage by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        when(currentImage) {
            1 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.cantik,
                    nameResource = R.string.Cantik_Itu_Luka,
                    authorResource = R.string.Eka_Kurniawan,
                    onNextButtonClick = { currentImage = 2 },
                    onPreviousButtonClick = { currentImage = 3 })
            }
            2 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.critical_eleven,
                    nameResource = R.string.Critical_Eleven,
                    authorResource = R.string.Ika_Natassa,
                    onNextButtonClick = { currentImage = 3 },
                    onPreviousButtonClick = { currentImage = 1 })
            }
            3 -> {
                ArtSpaceImage(
                    imageResource = R.drawable.nonversation,
                    nameResource = R.string.NonConversation,
                    authorResource = R.string.Valerie_Patkar,
                    onNextButtonClick = { currentImage = 1 },
                    onPreviousButtonClick = { currentImage = 2 })
            }
        }
    }
}

@Composable
fun ArtSpaceImage(
    imageResource: Int,
    nameResource: Int,
    authorResource: Int,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize().background(color = Color.LightGray)
        ){
            Surface(
                elevation = 16.dp,
                border = BorderStroke(3.dp, color = Color.LightGray)
            ){
                Image(
                    painter = painterResource(imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(5.dp)
                        .width(350.dp)
                        .height(400.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                elevation = 15.dp,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp, 16.dp)
            ) {
                Column {
                    Text(
                        text = stringResource(nameResource),
                        modifier = Modifier
                            .padding(16.dp, 10.dp, 16.dp, 0.dp),
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.allerta))
                    )
                    Text(
                        text = stringResource(authorResource),
                        modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 19.sp,
                        fontFamily = FontFamily(Font(R.font.allerta, weight = FontWeight.ExtraBold)))
                }
            }
        }
        Surface(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(30.dp, 16.dp)

        ) {
            Row(modifier = Modifier.fillMaxWidth().background(color = Color.LightGray),
            horizontalArrangement = Arrangement.SpaceBetween) {
                Button(
                    onClick = { onPreviousButtonClick() },
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red,
                    contentColor = Color.White)
                ) {
                    Text(text = stringResource(R.string.previous))
                }
                Button(
                    onClick = { onNextButtonClick() },
                    modifier = Modifier.padding(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue,
                        contentColor = Color.White)


                ){
                    Text(text = stringResource(R.string.next), Modifier.padding(12.dp,0.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}