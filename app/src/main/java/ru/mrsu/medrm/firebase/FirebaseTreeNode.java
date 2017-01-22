package ru.mrsu.medrm.firebase;

import java.io.Serializable;


public enum FirebaseTreeNode implements Serializable {
    HOSPITALS("hospitals"), SERVICES("services"),
    SCHEDULE("schedule"), DOCTORS_SERVICE("doctors-service");

    private String nodeKey;

    FirebaseTreeNode(String nodeKey){
        this.nodeKey = nodeKey;
   }

    @Override
    public String toString() {
        return nodeKey;
    }
}
