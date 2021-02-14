package com.chazool.builderPattern.entity;

public class Room {
    private int roomNo;
    private String special;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getSpecial() {
        return special;
    }

    public void setSpecial(String special) {
        this.special = special;
    }


    @Override
    public String toString() {
        return "Room{" +
                "roomNo=" + roomNo +
                ", special='" + special + '\'' +
                '}';
    }
}
