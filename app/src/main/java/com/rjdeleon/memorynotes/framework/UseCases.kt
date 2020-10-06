package com.rjdeleon.memorynotes.framework

import com.rjdeleon.core.usecase.AddNote
import com.rjdeleon.core.usecase.GetAllNotes
import com.rjdeleon.core.usecase.GetNote
import com.rjdeleon.core.usecase.RemoveNote

data class UseCases(
    val addNote: AddNote,
    val getAllNotes: GetAllNotes,
    val getNote: GetNote,
    val removeNote: RemoveNote
)