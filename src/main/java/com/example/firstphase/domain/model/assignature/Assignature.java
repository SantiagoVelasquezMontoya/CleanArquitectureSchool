package com.example.firstphase.domain.model.assignature;

public class Assignature {
    private final AssignatureId id;
    private final AssignatureName name;

    public Assignature(AssignatureId id, AssignatureName name) {
        this.id = id;
        this.name = name;
    }


    public AssignatureId getId() {
        return id;
    }

    public AssignatureName getName() {
        return name;
    }
}
