package com.rjdeleon.core.usecase

import com.rjdeleon.core.repository.NoteRepository

class GetNote(private val noteRepository: NoteRepository) {

    suspend operator fun invoke(id: Long) =
        noteRepository.getNote(id)
}