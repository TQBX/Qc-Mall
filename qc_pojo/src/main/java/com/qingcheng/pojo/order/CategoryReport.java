package com.qingcheng.pojo.order;

import lombok.Data;
import sun.awt.image.IntegerComponentRaster;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Summerday
 */
@Data
@Table(name="tb_category_report")
public class CategoryReport implements Serializable {

    @Id
    private Integer categoryId1;

    @Id
    private Integer categoryId2;

    @Id
    private Integer categoryId3;

    @Id
    private Date countDate;

    private Integer num;

    private Integer money;
}
