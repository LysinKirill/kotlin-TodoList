package ru.todo.list.services

import ru.todo.list.entities.TodoItem

interface TodoItemService {
    fun findAll(): Iterable<TodoItem>
    fun createTask(desc: String, title: String): TodoItem
    fun deleteTask(id: Long)
}