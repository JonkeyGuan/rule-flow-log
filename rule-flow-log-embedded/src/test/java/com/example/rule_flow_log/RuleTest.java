package com.example.rule_flow_log;

import org.junit.Test;
import org.kie.api.KieBase;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RuleTest {

    static final Logger log = LoggerFactory.getLogger(RuleTest.class);

    @Test
    public void test() {
        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        KieBase kieBase = kContainer.getKieBase();
        KieSession session = kieBase.newKieSession();

        session.addEventListener(new NodeListener());

        Fact fact = new Fact("field1", "field2", "field3", "field4");
        session.insert(fact);

        Condition condition = new Condition("yes");
        session.insert(condition);

        session.startProcess("RuleFlow.Flow");

        session.fireAllRules();

    }
}
