package com.acat.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: wujinfan
 * Date: 2019-11-19
 */
@Setter
@Getter
@ToString
public class ChildQueueEntity {

    /**
     * 队列id
     */
    private String queueId;

    /**
     * 时间段id
     */
    private String timeDuanId;

    /**
     * 队列名称
     */
    private String queueName;

    /**
     * 队列有多少人
     */
    private Integer childNum;

    /**
     * 队列有多少孩子
     */
    private List<ChildEntity> childsName;
}
