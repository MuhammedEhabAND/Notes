package inc.moe.notesapp.database

import androidx.room.*
import inc.moe.notesapp.model.Notes

@Dao
interface NotesDao {
    @get:Query("SELECT * FROM notes ORDER BY id DESC")
    val allNotes:List<Notes>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Notes)
    @Delete
    suspend fun deleteNotes(note: Notes)
}