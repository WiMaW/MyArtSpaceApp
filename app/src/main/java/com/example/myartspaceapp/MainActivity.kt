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

data class ArtAndDescription (
    val art: Painter,
    val contentDescription: String,
    val artDescription: String
)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = Color(60, 60, 60)
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
        color = Color(60, 60, 60)
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
    ArtAndDescriptionDisplay(click = click)
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
fun ArtAndDescriptionDisplay (
    modifier: Modifier = Modifier,
    click: Int
) {
    val art1 =
        ArtAndDescription(
            art = painterResource(R.drawable.apple),
            contentDescription = "null",
            artDescription = stringResource(R.string.apple)
        )
    val art2 =
        ArtAndDescription(
            art = painterResource(R.drawable.ceramics),
            contentDescription = "null",
            artDescription = stringResource(R.string.ceramics)
        )
    val art3 =
        ArtAndDescription(
            art = painterResource(R.drawable.coffepot_box),
            contentDescription = "null",
            artDescription = stringResource(R.string.coffeepot_and_box)
        )
    val art4 =
        ArtAndDescription(
            art = painterResource(R.drawable.lake),
            contentDescription = "null",
            artDescription = stringResource(R.string.lake)
        )
    val art5 =
        ArtAndDescription(
            art = painterResource(R.drawable.leaves),
            contentDescription = "null",
            artDescription = stringResource(R.string.leaves)
        )
    val art6 =
        ArtAndDescription(
            art = painterResource(R.drawable.starry_night),
            contentDescription = "null",
            artDescription = stringResource(R.string.starry_night)
        )
    val art7 =
        ArtAndDescription(
            art = painterResource(R.drawable.tomato),
            contentDescription = "null",
            artDescription = stringResource(R.string.tomato)
        )
    val art8 =
        ArtAndDescription(
            art = painterResource(R.drawable.vegetables),
            contentDescription = "null",
            artDescription = stringResource(R.string.vegetables)
        )

    var imageArtAndDescription = mutableListOf<ArtAndDescription>(
        art1, art2, art3, art4, art5, art6, art7, art8
    )

    var imageArtAndDescriptionSize: Int = imageArtAndDescription.size

    Image(
        painter = imageArtAndDescription[click].art,
        contentDescription = imageArtAndDescription[click].contentDescription,
        modifier = Modifier.padding(20.dp)
    )
    Text(
        modifier = Modifier.padding(20.dp),
        text = imageArtAndDescription[click].artDescription,
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