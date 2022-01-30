package com.example.rule_flow_log;

import java.util.Map;

import org.jbpm.workflow.core.Constraint;
import org.jbpm.workflow.core.impl.ConnectionRef;
import org.jbpm.workflow.core.node.Split;
import org.jbpm.workflow.instance.node.SplitInstance;
import org.kie.api.event.process.ProcessCompletedEvent;
import org.kie.api.event.process.ProcessEventListener;
import org.kie.api.event.process.ProcessNodeLeftEvent;
import org.kie.api.event.process.ProcessNodeTriggeredEvent;
import org.kie.api.event.process.ProcessStartedEvent;
import org.kie.api.event.process.ProcessVariableChangedEvent;

public class NodeListener implements java.io.Serializable, ProcessEventListener {

    static final long serialVersionUID = 1L;

    public NodeListener() {
    }

    public void afterNodeLeft(ProcessNodeLeftEvent event) {
        // intentionally left blank
    }

    public void afterNodeTriggered(ProcessNodeTriggeredEvent event) {
        // intentionally left blank
    }

    public void afterProcessCompleted(ProcessCompletedEvent event) {
        // intentionally left blank
    }

    public void afterProcessStarted(ProcessStartedEvent event) {
        // intentionally left blank
    }

    public void afterVariableChanged(ProcessVariableChangedEvent event) {
        // intentionally left blank
    }

    public void beforeNodeLeft(ProcessNodeLeftEvent event) {
        if (event.getNodeInstance() instanceof SplitInstance) {
            SplitInstance gateway = (SplitInstance) event.getNodeInstance();
            Split splitNode = (Split) gateway.getNode();
            Map<ConnectionRef, Constraint> map = splitNode.getConstraints();
            map.forEach((k, v) -> {
                if (v != null) {
                    System.out.println("ConnectionRef " + k.getConnectionId() + ", constraint " + v.getConstraint());
                } else {
                    System.out.println("ConnectionRef " + k.getConnectionId());
                }
                
            });

        }
    }

    public void beforeNodeTriggered(ProcessNodeTriggeredEvent event) {
        // intentionally left blank
    }

    public void beforeProcessCompleted(ProcessCompletedEvent event) {
        // intentionally left blank
    }

    public void beforeProcessStarted(ProcessStartedEvent event) {
        // intentionally left blank
    }

    public void beforeVariableChanged(ProcessVariableChangedEvent event) {
        // intentionally left blank
    }

}