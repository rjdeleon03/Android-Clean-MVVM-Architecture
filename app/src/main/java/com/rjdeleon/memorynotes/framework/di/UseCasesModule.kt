package com.rjdeleon.memorynotes.framework.di

import com.rjdeleon.core.repository.NoteRepository
import com.rjdeleon.core.usecase.AddNote
import com.rjdeleon.core.usecase.GetAllNotes
import com.rjdeleon.core.usecase.GetNote
import com.rjdeleon.core.usecase.RemoveNote
import com.rjdeleon.memorynotes.framework.UseCases
import dagger.Module
import dagger.Provides

@Module
class UseCasesModule {

    @Provides
    fun getUseCases(repository: NoteRepository) =
        UseCases(
            AddNote(repository),
            GetAllNotes(repository),
            GetNote(repository),
            RemoveNote(repository)
        )
}