package com.chazool.office;

public class Door {

    private  int id;
    private int priorityId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    @Override
    public String toString() {
        return "Door{" +
                "id=" + id +
                ", priorityId=" + priorityId +
                '}';
    }
}
