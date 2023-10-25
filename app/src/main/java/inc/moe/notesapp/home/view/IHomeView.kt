package inc.moe.notesapp.home.view

import inc.moe.notesapp.model.Notes

interface IHomeView {
    fun onGetAllNotesSuccess(notes :List<Notes>)
    fun onGetAllNotesFailureOrEmpty()
}