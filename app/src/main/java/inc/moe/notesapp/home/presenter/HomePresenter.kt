package inc.moe.notesapp.home.presenter

import inc.moe.notesapp.create_note.view.ICreateNoteView
import inc.moe.notesapp.home.view.IHomeView
import inc.moe.notesapp.model.IRepo
import inc.moe.notesapp.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePresenter (private val repo: IRepo, private val iHomeView: IHomeView)  : IHomePresenter {
    private lateinit var notes: List<Notes>
    override fun getAllNotes() {

        GlobalScope.launch(Dispatchers.IO) {
            val notes = repo.getAllNotes()
            if (notes.isNotEmpty()) {
                iHomeView.onGetAllNotesSuccess(notes)
            } else {
                iHomeView.onGetAllNotesFailureOrEmpty()
            }
        }
    }
}