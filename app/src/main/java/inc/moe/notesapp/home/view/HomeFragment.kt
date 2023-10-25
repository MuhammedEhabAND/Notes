package inc.moe.notesapp.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import inc.moe.notesapp.R


class HomeFragment : Fragment() {
    private lateinit var createNoteBtn:FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        initUI(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    private fun initUI(view: View) {
        createNoteBtn = view.findViewById(R.id.add_btn)
        createNoteBtn.setOnClickListener{
            navigateToCreateNote(view)
        }
    }

    private fun navigateToCreateNote(view: View) {
        val navController = findNavController(requireActivity(), R.id.nav_host_fragment)
        navController.navigate(R.id.createNoteFragment)

    }
}