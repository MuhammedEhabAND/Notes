package inc.moe.notesapp.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import inc.moe.notesapp.R
import inc.moe.notesapp.database.NoteLocalSource
import inc.moe.notesapp.home.presenter.HomePresenter
import inc.moe.notesapp.model.Notes
import inc.moe.notesapp.model.Repo


class HomeFragment : Fragment() , IHomeView{
    private lateinit var createNoteBtn:FloatingActionButton
    private lateinit var homePresenter:HomePresenter
    private lateinit var allNotesRv:RecyclerView
    private lateinit var allNotesAdapter:AllNotesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI(view)

        homePresenter = HomePresenter(Repo.getInstance(NoteLocalSource.getInstance(requireContext())),this)
        homePresenter.getAllNotes()
    }

    private fun initUI(view: View) {
        createNoteBtn = view.findViewById(R.id.add_btn)
        createNoteBtn.setOnClickListener{
            navigateToCreateNote(view)
        }
        allNotesRv = view.findViewById(R.id.rv)
        allNotesRv.setHasFixedSize(true)
        allNotesRv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        allNotesAdapter =AllNotesAdapter()
        allNotesRv.adapter = allNotesAdapter
    }

    private fun navigateToCreateNote(view: View) {
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)
        navController.navigate(R.id.createNoteFragment)

    }

    override fun onGetAllNotesSuccess(notes: List<Notes>) {
        allNotesAdapter.submitList(notes)
    }

    override fun onGetAllNotesFailureOrEmpty() {
    }
}