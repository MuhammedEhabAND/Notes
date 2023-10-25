package inc.moe.notesapp.database

import inc.moe.notesapp.model.Notes

interface INoteLocalSource {
    fun insertNote(note: Notes)
    fun deleteNote(note: Notes)
    fun getAllNotes():List<Notes>
}