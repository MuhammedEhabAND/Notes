package inc.moe.notesapp.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteOpenHelper
import inc.moe.notesapp.model.Notes
@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NotesDao

    companion object {
        private var notesDatabase: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            if (notesDatabase == null) {
                notesDatabase = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "notes_db"
                ).build()
            }
            return notesDatabase!!
        }

    }

}