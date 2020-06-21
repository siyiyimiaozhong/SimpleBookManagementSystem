package com.siyi.domain;

import java.io.Serializable;

public class BookType implements Serializable {
    private Long typeId;
    private String typeName;

    public BookType() {
    }

    public BookType(Long typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }
}
