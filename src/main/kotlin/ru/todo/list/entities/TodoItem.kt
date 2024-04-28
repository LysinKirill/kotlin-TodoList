package ru.todo.list.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class TodoItem(
    var description: String,
    var title: String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0
)