package com.rjdeleon.memorynotes.framework.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.rjdeleon.core.data.Note
import com.rjdeleon.memorynotes.framework.UseCases
import com.rjdeleon.memorynotes.framework.di.ApplicationModule
import com.rjdeleon.memorynotes.framework.di.DaggerViewModelComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class ListViewModel(application: Application): AndroidViewModel(application) {

    private val coroutineScope = CoroutineScope(Dispatchers.IO)

    @Inject
    lateinit var useCases: UseCases

    init {
        DaggerViewModelComponent.builder()
            .applicationModule(ApplicationModule(getApplication()))
            .build()
            .inject(this)
    }

    val notesList = MutableLiveData<List<Note>>()

    fun getAllNotes() {
        coroutineScope.launch {
            notesList.postValue(useCases.getAllNotes())
        }
    }
}