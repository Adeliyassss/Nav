package com.example.nav.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.nav.data.local.db.TaskDao
import com.example.nav.model.Task

@Database(entities = [Task::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}