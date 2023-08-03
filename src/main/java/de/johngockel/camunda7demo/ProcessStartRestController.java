package de.johngockel.camunda7demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/process/start")
@AllArgsConstructor
@Slf4j
public class ProcessStartRestController {

    private final RuntimeService runtimeService;

    @PostMapping("/test")
    public void startTestProcess() {
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("testProcess");
        log.info("started instance for processDefinitionId='{}', processInstanceId='{}'",
                processInstance.getProcessDefinitionId(), processInstance.getProcessInstanceId());
    }
}
