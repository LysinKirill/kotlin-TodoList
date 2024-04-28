package ru.todo.list.services

import org.springframework.stereotype.Service
import ru.todo.list.entities.TodoItem
import ru.todo.list.repositories.TodoItemRepository

@Service
class TodoItemService(private val todoItemRepository: TodoItemRepository) {

    fun findAll(): Iterable<TodoItem> {
        return todoItemRepository.findAll()
    }

    fun createTask(desc: String, title: String): TodoItem {
        val todoItem = TodoItem(description = desc, title = title)
        return todoItemRepository.save(todoItem)
    }
}
