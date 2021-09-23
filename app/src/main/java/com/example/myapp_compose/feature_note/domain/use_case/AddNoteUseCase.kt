package com.example.myapp_compose.feature_note.domain.use_case

import com.example.myapp_compose.feature_note.domain.model.InvalidNoteException
import com.example.myapp_compose.feature_note.domain.model.Note
import com.example.myapp_compose.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note : Note){
        if(note.title.isBlank()){
            throw InvalidNoteException("Title of the note cannot be empty.")
        }
        repository.insertNote(note)
    }

}