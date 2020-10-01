package com.crud.tasks;

import com.crud.tasks.controller.TaskController;
import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private TaskController taskController;
    @MockBean
    private TaskMapper taskMapper;
    @MockBean
    private DbService dbService;

    @Test
    public void testGetEmptyTasks() throws Exception {
        //Given
        List<TaskDto> taskDtoList = new ArrayList<>();
        when(taskController.getTasks()).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is(200)) // or isOk
                .andExpect(jsonPath("$",hasSize(0)));
    }

    @Test
    public void testGetTasks() throws Exception {
        List<TaskDto> taskDtoList = new ArrayList<>();
        taskDtoList.add(new TaskDto(1L,"Test title","Test content"));
        when(taskController.getTasks()).thenReturn(taskDtoList);

        //When & Then
        mockMvc.perform(get("/v1/task/getTasks").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                //TaskDto fields
                .andExpect(jsonPath("$",hasSize(1)))
                .andExpect(jsonPath("$[0].id",is(1)))
                .andExpect(jsonPath("$[0].title",is("Test title")))
                .andExpect(jsonPath("$[0].content",is("Test content")));

    }

//    @Test
//    public void testGetTask() throws Exception {
//        List<TaskDto> taskDtoList = new ArrayList<>();
//        TaskDto taskDto = new TaskDto(1L,"Test title","Test content");
//        taskDtoList.add(taskDto);
//
//        when(taskMapper.mapToTaskDtoList(anyList())).thenReturn(taskDtoList);
//        when(taskMapper.mapToTaskDto(any(Task.class))).thenReturn(taskDto);
//
//        Gson gson = new Gson();
//        String jsonContent = gson.toJson(taskDtoList);
//
//        //When & Then
//        mockMvc.perform(get("/v1/task/getTask")
//                .param("taskId", "1")
//                .contentType(MediaType.APPLICATION_JSON))
//                .characterEncoding("UTF-8")
//                .content(jsonContent)
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$",hasSize(1)))
//                .andExpect(jsonPath("$[0].id",is(1)))
//                .andExpect(jsonPath("$[0].title",is("Test title")))
//                .andExpect(jsonPath("$[0].content",is("Test content")));
//    }
//
//    @Test
//    public void testDeleteTask() throws Exception {
//
//    }
//
//    @Test
//    public void testUpdateTask() throws Exception {
//
//    }

//    @Test
//    public void testCreateTask() throws Exception {
//        //Given
//        TaskDto taskDto = new TaskDto((long) 1,"Test title","Test content");
//        Task task = new Task((long) 1,"Test title","Test content");
//
//        when(taskController.createTask(taskDto)).thenReturn(task);
//
//
//    }
}
