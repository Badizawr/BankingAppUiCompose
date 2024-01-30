package com.example.bankingappuicompose.data

import androidx.compose.ui.graphics.vector.ImageVector

data class Currency(
    val name: String,
    val buy: Float,
    val shell: Float,
    val icon: ImageVector
)
