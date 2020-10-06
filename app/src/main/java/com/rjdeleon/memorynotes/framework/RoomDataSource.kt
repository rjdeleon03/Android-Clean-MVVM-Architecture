package com.rjdeleon.memorynotes.framework

import android.content.Context
import com.rjdeleon.core.data.Note
import com.rjdeleon.core.repository.NoteDataSource
import com.rjdeleon.memorynotes.framework.db.DatabaseService
import com.rjdeleon.memorynotes.framework.db.NoteEntity

class RoomDataSource(context: Context): NoteDataSource {

    val noteDao = DatabaseService.getInstance(context).noteDao()

    override suspend fun add(note: Note) =
        noteDao.addNoteEntity(NoteEntity.fromNote(note))

    override suspend fun get(id: Long): Note? =
        noteDao.getNoteEntity(id)?.toNote()

    override suspend fun getAll(): List<Note> =
        noteDao.getAllNoteEntities().map {
            it.toNote()
        }

    override suspend fun remove(note: Note) =
        noteDao.deleteNoteEntity(NoteEntity.fromNote(note))
}