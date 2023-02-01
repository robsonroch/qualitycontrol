package br.com.robson.qualitycontrol.resources.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.robson.qualitycontrol.Application;
import br.com.robson.qualitycontrol.config.TestConfig;
import br.com.robson.qualitycontrol.models.converters.EmployeeToResponse;
import br.com.robson.qualitycontrol.resources.requests.EmployeeRequest;
import br.com.robson.qualitycontrol.services.EmailService;
import br.com.robson.qualitycontrol.services.EmployeeService;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {Application.class, TestConfig.class})
@AutoConfigureMockMvc
class EmployeeResourceTest {
	
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
	private EmployeeService service;
	
    @MockBean
	private EmployeeToResponse builderResponse;
	
    @MockBean
	private EmailService mailService;
    
    @Test
    void send_valid_post() throws Exception {
    	
    	doNothing().when(mailService).sendOrderConfirmationEmail(any());
        
        mockMvc.perform(MockMvcRequestBuilders.post("/funcionarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(
                        		EmployeeRequest.builder()
                        		.id(123l)
                        		.cpf("075564247-31")
                        		.firstName("Robson")
                        		.lastName("Rocha")
                        		.email("robson@into.saude.gov.br")
                        		.build()
                        		)))
                .andExpect(status().isCreated());
    }

}
