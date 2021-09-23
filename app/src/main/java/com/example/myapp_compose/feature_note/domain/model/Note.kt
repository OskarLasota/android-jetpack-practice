package com.example.myapp_compose.feature_note.domain.model

import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.lang.Exception

@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey val id : Int? = null,
    val title : String,
    val content : String,
    val timestamp : Long,
    val color : Int
){
    companion object {
        val noteColors = listOf(Red, Yellow)
    }
}

class InvalidNoteException(message : String) : Exception(message)