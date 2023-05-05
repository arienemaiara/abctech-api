package br.com.fiap.abctechapi.service;

import br.com.fiap.abctechapi.entity.Assistance;
import br.com.fiap.abctechapi.repository.AssistanceRepository;
import br.com.fiap.abctechapi.service.impl.AssistanceServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@SpringBootTest
public class AssistanceServiceTest {

    @MockBean
    private AssistanceService assistanceService;
    @MockBean
    private AssistanceRepository assistanceRepository;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        assistanceService = new AssistanceServiceImp(assistanceRepository);
    }

    @Test
    public void testAssistanceList() {
        Mockito.when(assistanceRepository.findAll())
                .thenReturn(
                        List.of(new Assistance(1L, "test", "drescription"))
                );
        List<Assistance> list = assistanceService.getAssists();

        Assertions.assertNotNull(list);
        Assertions.assertEquals(list.size(), 1);
    }
}
