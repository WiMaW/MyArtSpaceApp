package com.example.myartspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myartspaceapp.data.Datasource
import com.example.myartspaceapp.model.Art
import com.example.myartspaceapp.ui.theme.MyArtSpaceAppTheme
import androidx.compose.foundation.shape.RoundedCornerShape

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    ComposeArtApp(artList = Datasource().LoadArt())
                }
            }
        }
    }
}

@Composable
fun ComposeArtApp(
    modifier: Modifier = Modifier,
    artList: List<Art>,
    ) {
    var click by remember {
        mutableStateOf(0)
    }
    var clickLimit: Int = artList.size - 1

    Column (
        modifier = modifier
            .padding(20.dp)
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

    ) {
        DisplayAppNameAndIcon()
        Button(
            modifier = modifier
                .padding(15.dp),
            onClick = {
                if(click > 0) {
                    click--
                } else {
                    click = clickLimit
                }}
        )
        {
            Text(text = "PREV")
        }
        ArtAndDescriptionCard(click = click, artList = Datasource().LoadArt())
        Button(
            modifier = modifier.padding(20.dp),
            onClick = {
                if (click < clickLimit) {
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

//to change view for scrollable list
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
fun DisplayAppNameAndIcon (modifier: Modifier = Modifier) {
    Row (modifier = modifier){
        Image(
            painter = painterResource(R.drawable.app_icon2),
            contentDescription = null,
            modifier = Modifier
                .height(35.dp)
                .width(35.dp)
                .clip(MaterialTheme.shapes.small),
        )
        Text(
            text = stringResource(R.string.app_name),
            modifier = Modifier.padding(
                top = dimensionResource(R.dimen.padding_medium),
                bottom = dimensionResource(R.dimen.padding_large)),
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge
        )
    }
}

@Composable
fun ArtAndDescriptionCard (
    modifier: Modifier = Modifier,
    artList: List<Art>,
    click: Int
) {
    Card (modifier = modifier) {
        Column (
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            ){
            Image(
                painter = painterResource(artList[click].art),
                contentDescription = stringResource(artList[click].contentDescription),
                modifier = Modifier
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Fit
            )
            Column (
                modifier = modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top){
                Text(
                    modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium)),
                    text = stringResource(artList[click].artDescription),
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = stringResource(artList[click].method),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    modifier = Modifier
                        .padding(
                            bottom = dimensionResource(R.dimen.padding_medium),
                            top = dimensionResource(R.dimen.padding_small
                    )),
                    text = stringResource(artList[click].date),
                    style = MaterialTheme.typography.bodySmall

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
fun MyArtSpacePreview() {
    MyArtSpaceAppTheme {
        ComposeArtApp(artList = Datasource().LoadArt())
    }
}

@Preview(showBackground = true)
@Composable
fun MyArtSpaceDarkPreview() {
    MyArtSpaceAppTheme (darkTheme = true){
        ComposeArtApp(artList = Datasource().LoadArt())
    }
}