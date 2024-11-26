package com.example.todo.model;

import com.example.todo.Todo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoTest {

    @Test
    public void testTodoEntityCreation() {
        // 엔티티 생성
        Todo todo = new Todo();
        todo.setTitle("Learn TDD");
        todo.setDescription("Learn how to write tests first");
        todo.setCompleted(false);

        // 필드 값 테스트
        assertEquals("Learn TDD", todo.getTitle());
        assertEquals("Learn how to write tests first", todo.getDescription());
        assertFalse(todo.isCompleted());
    }
}
