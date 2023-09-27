package com.example.myartspaceapp.data

import com.example.myartspaceapp.R
import com.example.myartspaceapp.model.Art
class Datasource {
    fun LoadArt(): List<Art> {
        return listOf<Art>(
            Art(R.drawable.apple, R.string.apple, R.string.apple, R.string.apple_method, R.string.apple_date),
            Art(R.drawable.ceramics, R.string.ceramics, R.string.ceramics, R.string.ceramics_method, R.string.ceramics_date),
            Art(R.drawable.coffepot_box, R.string.coffeepot_and_box, R.string.coffeepot_and_box, R.string.coffeepot_and_box_method, R.string.coffeepot_and_box_date),
            Art(R.drawable.lake, R.string.lake, R.string.lake, R.string.lake_method, R.string.lake_date),
            Art(R.drawable.leaves, R.string.leaves, R.string.leaves, R.string.leaves_method, R.string.leaves_date),
            Art(R.drawable.starry_night, R.string.starry_night, R.string.starry_night, R.string.starry_night_method, R.string.starry_night_date),
            Art(R.drawable.tomato, R.string.tomato, R.string.tomato, R.string.tomato_method, R.string.tomato_date),
            Art(R.drawable.vegetables, R.string.vegetables, R.string.vegetables, R.string.vegetables_method, R.string.vegetables_date))
    }
}
