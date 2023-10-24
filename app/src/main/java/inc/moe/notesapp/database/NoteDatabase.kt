package inc.moe.notesapp.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import inc.moe.notesapp.model.Notes

@Database(entities = [Notes::class], version = 1 , exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    companion object{
        var notesDatabase:NoteDatabase? = null
        @Synchronized
        fun getInstance(context: Context):NoteDatabase{
            if(notesDatabase!=null){
                notesDatabase = Room.databaseBuilder(
                    context,
                    NoteDatabase::class.java,
                    "notes.db"
                ).build()

            }
            return notesDatabase!!
        }
    }
    abstract fun noteDao():NotesDao
  }