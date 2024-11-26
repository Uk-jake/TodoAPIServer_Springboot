package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repository.TodoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class TodoServiceTest {

    // Mock 객체로 TodoRepository를 선언합니다. 실제 데이터베이스를 사용하지 않고 모의 객체를 이용해 테스트를 수행합니다.
    @Mock
    private TodoRepository todoRepository;

    // 테스트 대상인 TodoService 객체를 선언하고, 모의된 TodoRepository를 주입합니다.
    @InjectMocks
    private TodoService todoService;

    // 각 테스트 실행 전에 Mockito를 초기화하여 @Mock과 @InjectMocks가 제대로 동작하도록 합니다.
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // Todo 객체를 생성하는 기능을 테스트합니다.
    @Test
    public void testCreateTodo() {
        // given - 테스트에 사용할 Todo 객체를 생성하고 필요한 값을 설정합니다.
        Todo todo = new Todo();
        todo.setTitle("Learn TDD");
        todo.setDescription("Learn how to write tests first");

        // when - todoRepository의 save 메소드가 호출되었을 때, 그 결과로 todo 객체를 반환하도록 설정합니다.
        when(todoRepository.save(todo)).thenReturn(todo);

        // when - TodoService의 createTodo 메소드를 호출하여 실제 동작을 수행합니다.
        Todo createdTodo = todoService.createTodo(todo);

        // then - 결과를 검증합니다.
        assertNotNull(createdTodo); // 생성된 객체가 null이 아닌지 확인합니다.
        assertEquals("Learn TDD", createdTodo.getTitle()); // 생성된 객체의 제목이 예상한 값과 일치하는지 확인합니다.
        verify(todoRepository, times(1)).save(todo); // save 메소드가 정확히 한 번 호출되었는지 검증합니다.
    }

    // 특정 ID로 Todo 객체를 조회하는 기능을 테스트합니다.
    @Test
    public void testGetTodoById() {
        // given - 조회할 Todo 객체를 생성하고 필요한 값을 설정합니다.
        Long id = 1L;
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle("Test Get By ID");

        // when - todoRepository의 findById 메소드가 호출되었을 때, Optional.of(todo)를 반환하도록 설정합니다.
        when(todoRepository.findById(id)).thenReturn(Optional.of(todo));

        // when - TodoService의 getTodoById 메소드를 호출하여 실제 동작을 수행합니다.
        Optional<Todo> foundTodo = todoService.getTodoById(id);

        // then - 결과를 검증합니다.
        assertTrue(foundTodo.isPresent()); // 반환된 Optional 객체가 비어있지 않은지 확인합니다.
        assertEquals("Test Get By ID", foundTodo.get().getTitle()); // 조회된 Todo 객체의 제목이 예상한 값과 일치하는지 확인합니다.
        verify(todoRepository, times(1)).findById(id); // findById 메소드가 정확히 한 번 호출되었는지 검증합니다.
    }
}
