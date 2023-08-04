package de.johngockel.camunda7demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.community.rest.client.api.ProcessDefinitionApi;
import org.camunda.community.rest.client.dto.ProcessInstanceWithVariablesDto;
import org.camunda.community.rest.client.dto.StartProcessInstanceDto;
import org.camunda.community.rest.client.invoker.ApiException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/process/start")
@AllArgsConstructor
@Slf4j
public class ProcessStartRestController {

    private final ProcessDefinitionApi processDefinitionApi;

    @PostMapping("/test")
    public void startTestProcess() throws ApiException {
        StartProcessInstanceDto startProcessInstanceDto = new StartProcessInstanceDto();
        ProcessInstanceWithVariablesDto processInstance = processDefinitionApi.startProcessInstanceByKey("testProcess", startProcessInstanceDto);
        log.info("started instance for processDefinitionId='{}', processInstanceId='{}'",
                processInstance.getDefinitionId(), processInstance.getId());
    }
}
