package com.smartcity.civicpulse.dto;

import com.smartcity.civicpulse.enums.PrioritySet;

public class Priority {
  private   PrioritySet priority;

    public PrioritySet getPriority() {
        return priority;
    }

    public void setPriority(PrioritySet priority) {
        this.priority = priority;
    }
}
