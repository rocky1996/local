package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
@Setter
@Getter
@ToString
public class ChildEntity {

    private String childId;

    private String childName;

    public ChildEntity(String childId, String childName) {
        this.childId = childId;
        this.childName = childName;
    }

    public ChildEntity() {

    }
}
