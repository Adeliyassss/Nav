package com.example.nav.model

import androidx.room.Entity

@Entity
data class Task(
    val title: String? = null,
    val desc: String? = null,
): java.io.Serializable
