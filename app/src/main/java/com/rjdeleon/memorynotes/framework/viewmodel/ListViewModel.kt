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

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    private val repository = NoteRepository(RoomNoteDataSource(application))

    private val useCases = UseCases(
        AddNote(repository),
        GetAllNotes(repository),
        GetNote(repository),
        RemoveNote(repository)
    )

    val notesList = MutableLiveData<List<Note>>()

    fun getAllNotes() {
        coroutineScope.launch {
            notesList.postValue(useCases.getAllNotes())
        }
    }
}