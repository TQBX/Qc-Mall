package com.qingcheng.pojo.order;

import lombok.Data;

import javax.sql.rowset.serial.SerialBlob;
import java.io.Serializable;
import java.util.List;

/**
 *
 * 封装实体对象
 * @author Summerday
 */

@Data
public class Orders implements Serializable {

    /**
     * 订单对象
     */
    private Order order;
    /**
     * 订单明细对象
     */
    private List<OrderItem> orderItemList;

}
