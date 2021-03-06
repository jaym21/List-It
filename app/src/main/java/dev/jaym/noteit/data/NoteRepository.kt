package dev.jaym.noteit.data

import androidx.lifecycle.LiveData
import dev.jaym.noteit.database.NoteDAO

//Repository is basically a simple class which is layer used to provide a cleaner API to viewmodel or UI to communicate with
// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class  NoteRepository(private val noteDAO: NoteDAO) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allNotes: LiveData<List<Note>> = noteDAO.getAllNotes() //this will get all notes from NoteDAO which will communicate with Database

    //to insert a note
    suspend fun insert(note: Note) {
        noteDAO.insert(note)
    }

    //to delete a note
    suspend fun delete(note: Note) {
        noteDAO.delete(note)
    }

    //to update a note
    suspend fun update(note: Note) {
        noteDAO.update(note)
    }

    //to search for a note
    fun searchNote(searchQuery: String): LiveData<List<Note>>{
        return noteDAO.getSearchResults(searchQuery)
    }
}