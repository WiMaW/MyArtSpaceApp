package com.example.myartspaceapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myartspaceapp.ui.theme.MyArtSpaceAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
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
Column (
    modifier = modifier.padding(20.dp),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.SpaceEvenly
) {
    ButtonsNextPrev(text = "PREV")
    ArtAndTitleDisplay()
    ButtonsNextPrev(text = "NEXT")
}
}

@Composable
fun ButtonsNextPrev (
    modifier: Modifier = Modifier,
    text: String
) {
    Button(
        modifier = Modifier.padding(15.dp),
        onClick = { /*TODO*/ }) {
        Text(text = text)
    }
}

@Composable
fun ArtAndTitleDisplay (
    modifier: Modifier = Modifier
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

    Image(painter = painterResource(id = artImages[0]), contentDescription = null)
    Text(text = stringResource(id = artInfo[0]))
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