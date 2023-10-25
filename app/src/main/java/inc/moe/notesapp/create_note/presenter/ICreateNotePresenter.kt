package inc.moe.notesapp.create_note.presenter

import inc.moe.notesapp.model.Notes

interface ICreateNotePresenter {
    fun createNewNote(note: Notes)
    fun onCreatedNoteSuccess()
}
