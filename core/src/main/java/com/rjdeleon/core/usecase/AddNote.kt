package com.rjdeleon.core.usecase

import com.rjdeleon.core.data.Note
import com.rjdeleon.core.repository.NoteRepository

class AddNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) =
        noteRepository.addNote(note)
}