package com.atguigu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author suchaobin
 * @description 订单
 * @date 2020/12/18 23:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("seata_order.t_order")
public class Order {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    private Integer status = 0; //订单状态：0：创建中；1：已完结
}
