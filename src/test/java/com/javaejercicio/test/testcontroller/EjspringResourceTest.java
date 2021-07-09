package com.javaejercicio.test.testcontroller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.javaejercicio.model.ModelData;
import com.javaejercicio.rest.RestData;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class EjspringResourceTest {

    private MockMvc mockMvc;

    @Mock
    private RestData restData;
    
    @InjectMocks
    private ModelData modelData;
    
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(modelData)
                .build();
    }
    
    @Test
    public void testHelloWorldJson() throws Exception {
        mockMvc.perform(get("/rest/data/obtenerDatos")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.*", Matchers.hasSize(2)));
    }
}