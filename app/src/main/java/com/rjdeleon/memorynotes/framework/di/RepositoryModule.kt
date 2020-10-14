package com.rjdeleon.memorynotes.framework.di

import android.app.Application
import com.rjdeleon.core.repository.NoteRepository
import com.rjdeleon.memorynotes.framework.RoomNoteDataSource
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {

    @Provides
    fun provideRepository(app: Application) =
        NoteRepository(RoomNoteDataSource(app))
}