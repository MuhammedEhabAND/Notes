package inc.moe.notesapp.database

import androidx.room.*
import inc.moe.notesapp.model.Notes

@Dao
interface NotesDao {
    @Query("SELECT * FROM notes ORDER BY id DESC")
    suspend fun getAllNotes():List<Notes>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Notes)
    @Delete
    suspend fun deleteNotes(note: Notes)
}