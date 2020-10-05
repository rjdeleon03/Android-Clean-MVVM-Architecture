package com.rjdeleon.core.usecase

import com.rjdeleon.core.repository.NoteRepository

class GetAllNotes(private val noteRepository: NoteRepository) {

    suspend operator fun invoke() =
        noteRepository.getAllNotes()
}