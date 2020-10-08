package com.rjdeleon.memorynotes.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rjdeleon.core.data.Note
import com.rjdeleon.core.repository.NoteRepository
import com.rjdeleon.core.usecase.AddNote
import com.rjdeleon.core.usecase.GetAllNotes
import com.rjdeleon.core.usecase.GetNote
import com.rjdeleon.core.usecase.RemoveNote
import com.rjdeleon.memorynotes.framework.RoomNoteDataSource
import com.rjdeleon.memorynotes.framework.UseCases
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    val repository = NoteRepository(RoomNoteDataSource(application))

    val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val saved = MutableLiveData<Boolean>()

    fun saveNote(note: Note) {
        coroutineScope.launch {
            useCases.addNote(note)
            saved.postValue(true)
        }
    }
}