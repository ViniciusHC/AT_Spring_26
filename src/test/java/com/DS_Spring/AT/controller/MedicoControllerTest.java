package com.DS_Spring.AT.controller;
import com.DS_Spring.AT.controllers.MedicoController;
import com.DS_Spring.AT.entities.Medico;
import com.DS_Spring.AT.services.MedicoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.ObjectMapper;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest(MedicoController.class)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class MedicoControllerTest {

    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;

    @MockitoBean
    private MedicoService medicoService;

    public MedicoControllerTest(MockMvc mockMvc, ObjectMapper objectMapper) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
    }

    @Test
    void devePegarMedicosComSucesso() throws Exception {

        List<Medico> medicosTest = new ArrayList<>();
        medicosTest.add(new Medico(1L, "Dr. Carlos Silva", "CRM-SP 123456", "Cardiologia"));
        medicosTest.add(new Medico(2L, "Dra. Ana Souza", "CRM-RJ 654321", "Dermatologia"));
        medicosTest.add(new Medico(3L, "Dr. Pedro Lima", "CRM-MG 987654", "Ortopedia"));

        when(this.medicoService.listarMedicos()).thenReturn(medicosTest);

        String jsonString = this.objectMapper.writeValueAsString(medicosTest);

        MockHttpServletResponse response = this.mockMvc.perform(get("/medico").contentType(MediaType.APPLICATION_JSON)
                .content(jsonString)).andDo(print()).andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());

    }



}
