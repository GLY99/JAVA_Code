package org.example.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 中奖记录表
 */
@Getter
@Setter
@ToString
public class Record {
    
    private Integer id;

    /**
     * 中奖人员
     */
    private Integer memberId;

    /**
     * 奖项id
     */
    private Integer awardId;

    /**
     * 创建时间
     */
    private Date createTime;
}