package com.example.myapp_compose.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.myapp_compose.feature_note.data.data_source.NoteDatabase
import com.example.myapp_compose.feature_note.data.repository.NoteRepositoryImpl
import com.example.myapp_compose.feature_note.domain.repository.NoteRepository
import com.example.myapp_compose.feature_note.domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): NoteDatabase {
        return Room.databaseBuilder(appContext, NoteDatabase::class.java, "database").build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases{
        return NoteUseCases(
            getNotesUseCase = GetNotesUseCase(repository),
            deleteNoteUseCase = DeleteNoteUseCase(repository),
            addNoteUseCase = AddNoteUseCase(repository),
            getNoteUseCase = GetNoteUseCase(repository)
        )
    }

}