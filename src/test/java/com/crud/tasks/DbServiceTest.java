package com.crud.tasks;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class DbServiceTest {

    @InjectMocks
    private DbService dbService;
    @Mock
    private TaskRepository repository;

    @Test
    public void testAllTasks() throws Exception {
        //Given
        when(repository.findAll()).thenReturn(new ArrayList<>());

        //When & Then
        assertEquals(0, dbService.getAllTasks().size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void testFindTaskById() {
        //Given
        Task task = new Task(1L, "test title", "test content");

        when(dbService.getTask(any())).thenReturn(java.util.Optional.of(task));

        //When
        Task searchedTask = dbService.getTask(1L).get();

        //Then
        assertEquals("test title", searchedTask.getTitle());
        assertEquals("test content", searchedTask.getContent());
        assertEquals(java.util.Optional.of(1L), java.util.Optional.of(searchedTask.getId()));
        verify(repository, times(1)).findById(1L);
    }

    @Test
    public void testSaveTask() {
        //Given
        Task task = new Task(1L, "test title", "test content");
        //When
        dbService.saveTask(task);
        //Then
        verify(repository, times(1)).save(task);
    }

    @Test
    public void testDeleteTask() {
        //Given
        //When
        dbService.deleteTask(1L);
        //Then
        verify(repository,times(1)).deleteById(1L);
    }
}
