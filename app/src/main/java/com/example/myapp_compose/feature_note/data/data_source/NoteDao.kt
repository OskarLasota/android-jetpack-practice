package com.example.myapp_compose.feature_note.data.data_source

import androidx.room.*
import com.example.myapp_compose.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM note_table")
    fun getNotes() : Flow<List<Note>>

    @Query("SELECT * FROM note_table WHERE id =:id")
    suspend fun getNoteById(id : Int) : Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

}