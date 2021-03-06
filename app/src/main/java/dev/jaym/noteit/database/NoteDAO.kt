package dev.jaym.noteit.database

import androidx.lifecycle.LiveData
import androidx.room.*
import dev.jaym.noteit.data.Note

//making DAO(Data Access Object) to access the data in entity(table) and perform queries or operation on database
@Dao
interface NoteDAO {

    //making abstract functions
    //suspend makes the function background function which does not put load on the app(can only be called from a background thread)
    @Insert(onConflict = OnConflictStrategy.IGNORE) //if same type of note is being added it will be ignored by help of onConflict
    suspend fun  insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Update
    suspend fun update(note: Note)

    @Query("Select * from notes_table order by id ASC") //getting all notes by order of their id
    fun getAllNotes(): LiveData<List<Note>> //LiveData is used to observe the changes made to data

    @Query("Select * from notes_table where noteTitle like :searchQuery or noteDes like :searchQuery")
    fun getSearchResults(searchQuery: String): LiveData<List<Note>>
}