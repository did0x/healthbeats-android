package co.saputra.healthbeats.arch.model

import android.graphics.drawable.Drawable

data class Task(
    val name: String = "",
    val title: String = "",
    val description: String = "",
    val image: Drawable? = null,
    val action: String = "",
    val rule: String = "",
    val currentAmount: Int = 0,
    val amount: Int = 0
)
