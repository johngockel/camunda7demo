package de.johngockel.camunda7demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("PrepareChickenDelegate")
@RequiredArgsConstructor
@Slf4j
public class PrepareChickenDelegate implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        log.info("[prepareChicken] {}", delegateExecution.getVariables());
    }
}
