package com.rjdeleon.core.usecase

import com.rjdeleon.core.data.Note
import com.rjdeleon.core.repository.NoteRepository

class RemoveNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(note: Note) =
        noteRepository.removeNote(note)
}