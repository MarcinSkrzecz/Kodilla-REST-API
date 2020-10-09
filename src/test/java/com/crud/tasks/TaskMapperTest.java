package com.crud.tasks;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void mapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "title","content");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals("title",task.getTitle());
        assertEquals("content",task.getContent());
    }

    @Test
    public void mapToTaskDto() {
        //Given
        Task task = new Task(1L, "title","content");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals("title",taskDto.getTitle());
        assertEquals("content",taskDto.getContent());
    }

    @Test
    public void testMapToTaskDroList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task(1L,"title_1","content_1");
        Task task2 = new Task(2L,"title_2","content_2");
        tasks.add(task1);
        tasks.add(task2);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertNotNull(taskDtoList);
        assertEquals(2, taskDtoList.size());
    }
}
