package ru.todo.list.services

import org.springframework.stereotype.Service
import ru.todo.list.entities.TodoItem
import ru.todo.list.repositories.TodoItemRepository

@Service
class TodoItemServiceImpl(private val todoItemRepository: TodoItemRepository) : TodoItemService {
    override fun findAll(): Iterable<TodoItem> {
        return todoItemRepository.findAll()
    }

    override fun createTask(desc: String, title: String): TodoItem {
        val todoItem = TodoItem(description = desc, title = title)
        return todoItemRepository.save(todoItem)
    }

    override fun deleteTask(id: Long) = todoItemRepository.deleteById(id)
}
