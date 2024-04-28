package ru.todo.list.controllers

import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller
import ru.todo.list.entities.TodoItem
import ru.todo.list.services.TodoItemService


@Controller
class TodoItemController(private val todoItemService: TodoItemService) {
    @QueryMapping
    fun findAll(): Iterable<TodoItem> = todoItemService.findAll()


    @MutationMapping
    fun createTask(@Argument description: String, @Argument title: String) =
        todoItemService.createTask(description, title)
}