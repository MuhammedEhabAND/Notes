package inc.moe.notesapp.model

import inc.moe.notesapp.database.NoteLocalSource

class Repo private constructor(private val noteLocalSource: NoteLocalSource) :IRepo {

    companion object {
        private var instance: Repo? = null

        fun getInstance( noteLocalSource: NoteLocalSource): Repo {
            if (instance == null) {
                instance = Repo(noteLocalSource)
            }
            return instance as Repo
        }
    }

    override fun insertNote(note: Notes) {
        noteLocalSource.insertNote(note)

    }

    override fun deleteNote(note: Notes) {
       noteLocalSource.deleteNote(note)
    }

    override fun getAllNotes(): List<Notes> {
       return noteLocalSource.getAllNotes()
     }
}