package ru.todo.list.repositories
import org.springframework.data.repository.CrudRepository
import ru.todo.list.entities.TodoItem

interface TodoItemRepository : CrudRepository<TodoItem, Long>
