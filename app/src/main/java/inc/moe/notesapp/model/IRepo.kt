package inc.moe.notesapp.model

interface IRepo {

    fun insertNote(note: Notes)
    fun deleteNote(note: Notes)
    fun getAllNotes(): List<Notes>
}
