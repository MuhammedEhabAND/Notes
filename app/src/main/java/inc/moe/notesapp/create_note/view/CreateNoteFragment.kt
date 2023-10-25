package inc.moe.notesapp.create_note.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import inc.moe.notesapp.R
import inc.moe.notesapp.create_note.presenter.CreateNotePresenter
import inc.moe.notesapp.database.NoteDatabase
import inc.moe.notesapp.database.NoteLocalSource
import inc.moe.notesapp.model.Notes
import inc.moe.notesapp.model.Repo


class CreateNoteFragment : Fragment() , ICreateNoteView {
    private lateinit var backBtn:ImageView
    private lateinit var doneBtn:ImageView
    private lateinit var imageMore:ImageView
    private lateinit var noteTitle:EditText
    private lateinit var subNoteTitle:EditText
    private lateinit var noteBody:EditText
    private lateinit var createNotePresenter: CreateNotePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view =inflater.inflate(R.layout.fragment_create_note, container, false)
        // Inflate the layout for this fragment

        return view
    }

    private fun initUI(view: View) {
        backBtn = view.findViewById(R.id.imgBack)
        doneBtn = view.findViewById(R.id.imgDone)
        imageMore = view.findViewById(R.id.imgMore)
        backBtn.setOnClickListener {
            requireActivity().onBackPressed()
        }
        noteTitle = view.findViewById(R.id.etNoteTitle)
        subNoteTitle = view.findViewById(R.id.etNoteSubTitle)
        noteBody = view.findViewById(R.id.etNoteDesc)
        doneBtn.setOnClickListener {
            createNewNote()
        }
    }

    private fun createNewNote() {
        if(checkInput()){
           var note = Notes(
               title = noteTitle.text.toString(),
               subTitle = subNoteTitle.text.toString(),
               noteText = noteBody.text.toString()
           )
            createNotePresenter.createNewNote(note)

        }
    }

    private fun checkInput() :Boolean{
        if(noteTitle.text.isBlank()||subNoteTitle.text.isBlank()||noteBody.text.isBlank()){
            return false
        }
        return true
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)
        createNotePresenter = CreateNotePresenter(Repo.getInstance(NoteLocalSource.getInstance(requireContext())) , this)
    }

    override fun onCreatedNoteSuccess(successMessage: String) {
        val snackbar = Snackbar.make(requireView() , successMessage , Snackbar.LENGTH_SHORT)
        snackbar.show()
        val navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment)
        navController.navigateUp()

    }
}