package com.example.myartspaceapp

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.InspectableModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myartspaceapp.data.Datasource
import com.example.myartspaceapp.model.Art
import com.example.myartspaceapp.ui.theme.MyArtSpaceAppTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

data class ArtAndDescription (
    val art: Painter,
    val contentDescription: String,
    val artDescription: String,
    val date: String
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
                    color = Color(204, 200, 170)
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
        modifier = modifier.padding(15.dp),
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

    ArtAndDescriptionDisplay(click = click, artList = Datasource().LoadArt())

    Button(
        modifier = modifier.padding(20.dp),
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

//@Composable
//fun ArtList(artList: List<Art>, modifier: Modifier = Modifier) {
//    LazyColumn(modifier = modifier) {
//        items(artList) { art ->
//            ArtAndDescriptionDisplay (
//                art = art,
//                modifier = modifier.padding(8.dp)
//            )
//
//        }
//    }
//}

@Composable
fun ArtAndDescriptionDisplay (
    modifier: Modifier = Modifier,
    artList: List<Art>,
    click: Int
) {
    Card (modifier = modifier) {
        Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
            ){
            Image(
                painter = painterResource(artList[click].art),
                contentDescription = stringResource(artList[click].contentDescription),
                modifier = Modifier
                    .padding(15.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Column (
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top){
                Text(
                    modifier = Modifier.padding(bottom = 10.dp),
                    text = stringResource(artList[click].artDescription),
                    style = MaterialTheme.typography.headlineSmall
                )
                Text(
                    modifier = Modifier.padding(bottom = 0.dp),
                    text = stringResource(artList[click].method),
                )
                Text(
                    modifier = Modifier.padding(bottom = 15.dp),
                    text = stringResource(artList[click].date),
                    fontSize = 12.sp
                )
            }
        }
    }
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