package com.example.backend;

import com.example.backend.controller.DepartmentController;
import com.example.backend.service.DepartmentService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    @Test
    void getAllDepartments_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/departments"))
               .andExpect(status().isOk());
    }

    @Test
    void getDepartmentById_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/departments/1"))
               .andExpect(status().isOk());
    }
}
