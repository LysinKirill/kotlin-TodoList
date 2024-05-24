package unit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import ru.todo.list.entities.TodoItem
import ru.todo.list.repositories.TodoItemRepository
import ru.todo.list.services.TodoItemServiceImpl

class TodoItemServiceImplTest {

    private var todoItemRepository = mock<TodoItemRepository>()

    private var todoItemServiceImpl = TodoItemServiceImpl(todoItemRepository)

    @Test
    fun createTask_TaskCreated() {
        // Arrange
        val taskDescription = "Sample description"
        val taskTitle = "Sample title"
        val item = TodoItem(title = taskTitle, description =  taskDescription,id = 1)
        val itemToSave = TodoItem(title = taskTitle, description =  taskDescription)

        `when`(todoItemRepository.save(itemToSave)).thenReturn(item)

        // Act
        val result = todoItemServiceImpl.createTask(taskDescription, taskTitle)

        // Assert
        assertEquals(result, item)
        verify(todoItemRepository, times(1)).save(any(TodoItem::class.java))
    }

    @Test
    fun findAll_ListOfItemsReturned() {
        // Arrange
        val expectedItems = listOf(
            TodoItem("Sample title 1", "Sample description 1"),
            TodoItem("Sample title 2", "Sample description 2")
        )
        `when`(todoItemRepository.findAll()).thenReturn(expectedItems)

        // Act
        val result = todoItemServiceImpl.findAll()

        // Assert
        assertEquals(result, expectedItems)
        verify(todoItemRepository, times(1)).findAll()
    }

    @Test
    fun deleteItem_ItemDeleted() {
        // Arrange
        val testItem = TodoItem(title = "TestItem", description =  "Description", id = 1)

        // Act
        todoItemServiceImpl.deleteTask(testItem.id)

        // Assert
        verify(todoItemRepository, times(1)).deleteById(testItem.id)
    }
}