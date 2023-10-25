package inc.moe.notesapp.create_note.presenter

import inc.moe.notesapp.create_note.view.ICreateNoteView
import inc.moe.notesapp.database.NoteLocalSource
import inc.moe.notesapp.model.IRepo
import inc.moe.notesapp.model.Notes

class CreateNotePresenter (private val repo: IRepo, private val iCreateNoteView:ICreateNoteView) : ICreateNotePresenter {
    override fun createNewNote(note: Notes) {
        repo.insertNote(note)
        onCreatedNoteSuccess()
    }

    override fun onCreatedNoteSuccess() {
        iCreateNoteView.onCreatedNoteSuccess("Note added")
    }
}