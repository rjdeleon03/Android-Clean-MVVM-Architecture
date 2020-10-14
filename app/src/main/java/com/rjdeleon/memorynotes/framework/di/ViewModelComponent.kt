package com.rjdeleon.memorynotes.framework.di

import com.rjdeleon.memorynotes.framework.viewmodel.ListViewModel
import com.rjdeleon.memorynotes.framework.viewmodel.NoteViewModel
import dagger.Component

@Component(modules = [
    ApplicationModule::class,
    RepositoryModule::class,
    UseCasesModule::class
])
interface ViewModelComponent {

    fun inject(noteViewModel: NoteViewModel)

    fun inject(listViewModel: ListViewModel)
}