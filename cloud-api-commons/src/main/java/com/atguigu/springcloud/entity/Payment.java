package com.atguigu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author suchaobin
 * @description 支付实体类
 * @date 2020/8/12 17:01
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {
    private static final long serialVersionUID = 631851465112445170L;
    private Long id;
    private String serial;
}
