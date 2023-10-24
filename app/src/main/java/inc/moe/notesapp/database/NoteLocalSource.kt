package inc.moe.notesapp.database

import android.content.Context
import android.provider.Settings.Global
import android.util.Log
import inc.moe.notesapp.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NoteLocalSource (context:Context) : INoteLocalSource {

    private val instance: NoteLocalSource? = null
    private lateinit var noteDatabase: NoteDatabase
    private lateinit var notesDao: NotesDao
    init {
        noteDatabase= NoteDatabase.getInstance(context)
        notesDao = noteDatabase.noteDao()
        }

    fun getInstance(context: Context):NoteLocalSource {
        return if (instance == null) NoteLocalSource(context) else instance
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

    override fun getAllNotes(notes: List<Notes>) {
        GlobalScope.launch {  }
    }
}