package com.makeevrserg.todolist.application

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.makeevrserg.todolist.data.network.WebRepository
import com.makeevrserg.todolist.data.room.TodoRepository
import com.makeevrserg.todolist.data.room.dao.DatabaseBuilder
import com.makeevrserg.todolist.data.room.dao.TodoDatabase


class App : Application() {
    companion object {
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
        lateinit var todoDatabase: TodoDatabase
        lateinit var todoRepository: TodoRepository
        lateinit var webRepository: WebRepository
        lateinit var instance: Application
    }

    override fun onCreate() {
        super.onCreate()

        instance = this
        context = baseContext
        todoDatabase = DatabaseBuilder.build(context)
        todoRepository = TodoRepository(todoDatabase.dictionaryDao())
        webRepository = WebRepository()
    }

}