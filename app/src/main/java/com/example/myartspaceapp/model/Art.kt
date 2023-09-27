package com.example.myartspaceapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Art (
    @DrawableRes val art: Int,
    @StringRes val contentDescription: Int,
    @StringRes val artDescription: Int,
    @StringRes val method: Int,
    @StringRes val date: Int
)