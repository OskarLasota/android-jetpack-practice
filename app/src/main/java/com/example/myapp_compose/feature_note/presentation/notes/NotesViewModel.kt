package com.example.myapp_compose.feature_note.presentation.notes

import androidx.lifecycle.ViewModel
import com.example.myapp_compose.feature_note.domain.use_case.GetNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NotesViewModel @Inject constructor(
    private val notesUseCase: GetNotesUseCase
) : ViewModel() {

}