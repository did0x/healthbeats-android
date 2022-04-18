package co.saputra.healthbeats.arch.model

import android.graphics.drawable.Drawable

data class Plan(
    val name: String = "",
    val image: Drawable? = null,
    val location: String = "",
    val type: String = ""
)
