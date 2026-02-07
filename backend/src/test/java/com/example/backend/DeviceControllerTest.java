package com.example.backend;

import com.example.backend.controller.DeviceController;
import com.example.backend.service.DeviceService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeviceController.class)
class DeviceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DeviceService deviceService;

    @Test
    void getAllDevices_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/devices"))
               .andExpect(status().isOk());
    }

    @Test
    void getDeviceById_shouldReturnOk() throws Exception {
        mockMvc.perform(get("/api/devices/1"))
               .andExpect(status().isOk());
    }
}
