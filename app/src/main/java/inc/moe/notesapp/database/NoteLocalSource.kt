package inc.moe.notesapp.database

import android.content.Context
import inc.moe.notesapp.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteLocalSource private constructor(var context: Context) : INoteLocalSource {

    private var notesDao: NotesDao

    init {
        val noteDatabase = NoteDatabase.getInstance(context)
        notesDao = noteDatabase.noteDao()
    }

    companion object {
        private var instance: NoteLocalSource? = null

        fun getInstance(context: Context): NoteLocalSource {
            if (instance == null) {
                instance = NoteLocalSource(context)
            }
            return instance!!
        }
    }

    override fun insertNote(note: Notes) {
        GlobalScope.launch(Dispatchers.IO) {
            notesDao.insertNote(note)
        }
    }

    override fun deleteNote(note: Notes) {
        GlobalScope.launch(Dispatchers.IO) {
            notesDao.deleteNotes(note)
        }
    }

    override suspend fun getAllNotes():List<Notes> {
        val notes: List<Notes> = notesDao.getAllNotes()
        return notes

    }

}
