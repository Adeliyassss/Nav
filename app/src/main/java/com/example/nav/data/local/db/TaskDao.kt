package com.example.nav.data.local.db

import androidx.room.*
import com.example.nav.model.Task

@Dao
interface TaskDao {

    @Query("SELECT * FROM task")
    fun getAll(): List<Task>

    @Insert
    fun insert(task: Task)

    @Delete
    fun delete(task: Task)

    @Update
    fun update(task: Task)

}