package inc.moe.notesapp.home.view

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import inc.moe.notesapp.R
import inc.moe.notesapp.model.Notes

class AllNotesAdapter : ListAdapter<Notes, AllNotesAdapter.ViewHolder>(NotesDiffUtil()) {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view: View = inflater.inflate(R.layout.item_rv_notes, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote = getItem(position)
        holder.apply {
            noteTitle.text = currentNote.title
            noteBody.text = currentNote.noteText
            noteDate.text = currentNote.dateTime
            if(currentNote.color!=null)
                cardView.setCardBackgroundColor(Color.parseColor(currentNote.color))
            else
                cardView.setCardBackgroundColor(Color.parseColor(R.color.colorLightBlack.toString()))

        }

    }

    inner class ViewHolder(itemView:View) :RecyclerView.ViewHolder(itemView) {
         var noteTitle   : TextView
         var noteWebLink : TextView
         var noteBody    : TextView
         var noteDate    : TextView
         var cardView    : CardView
//         var noteImage : ImageView
        init {
            noteTitle = itemView.findViewById(R.id.tvTitleItem)
            noteBody = itemView.findViewById(R.id.tvDescItem)
            noteDate = itemView.findViewById(R.id.tvDateTimeItem)
            noteWebLink = itemView.findViewById(R.id.tvWebLinkItem)
            cardView = itemView.findViewById(R.id.cardView)
//            noteImage = itemView.findViewById(R.id.imgNoteItem)
        }
    }
    class NotesDiffUtil : DiffUtil.ItemCallback<Notes>(){
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem===newItem
        }

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem==newItem
        }

    }
}
