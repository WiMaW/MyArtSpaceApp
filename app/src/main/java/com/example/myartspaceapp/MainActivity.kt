package com.example.myartspaceapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myartspaceapp.ui.theme.MyArtSpaceAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArtApp()
                }
            }
        }
    }
}

@Composable
fun ComposeArtApp(modifier: Modifier = Modifier) {
    var click by remember {
        mutableStateOf(0)
    }

Column (
    modifier = modifier
        .padding(20.dp)
        .background(Color(204, 200, 170))
        .fillMaxWidth()
        .verticalScroll(rememberScrollState()),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center,

) {
    Text(
        text = stringResource(R.string.app_name),
        modifier = Modifier.padding(bottom = 60.dp),
        fontSize = 22.sp,
        fontWeight = FontWeight.Bold,
        color = Color(125, 124, 124)
    )
    Button(
        onClick = {
            if(click > 0) {
                click--
            } else {
                click = 7
            }}
    )
    {
        Text(text = "PREV")
    }
    ArtAndTitleDisplay(click = click)
    Button(
        onClick = {
            if (click < 7) {
            click++
            } else {
                click = 0
            }
        })
    {
        Text(text = "NEXT")
    }
}
}

@Composable
fun ArtAndTitleDisplay (
    modifier: Modifier = Modifier,
    click: Int
) {
    var artImages: Array<Int> = arrayOf(
        R.drawable.apple,
        R.drawable.ceramics,
        R.drawable.coffepot_box,
        R.drawable.lake,
        R.drawable.leaves,
        R.drawable.starry_night,
        R.drawable.tomato,
        R.drawable.vegetables
    )
    //var artImagesSize: Int = artImages.size
    var artInfo: Array<Int> = arrayOf(
        R.string.apple,
        R.string.ceramics,
        R.string.coffeepot_and_box,
        R.string.lake,
        R.string.leaves,
        R.string.starry_night,
        R.string.tomato,
        R.string.vegetables
    )
    //var artInfoSize: Int = artInfo.size

    Image(
        painter = painterResource(id = artImages[click]),
        contentDescription = null,
        modifier = Modifier.padding(20.dp)
    )
    Text(
        modifier = Modifier.padding(20.dp),
        text = stringResource(id = artInfo[click])
    )
}

@Composable
fun Settings(modifier: Modifier = Modifier) {

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyArtSpaceAppTheme {
        ComposeArtApp()
    }
}