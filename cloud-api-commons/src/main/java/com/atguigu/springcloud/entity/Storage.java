package com.atguigu.springcloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author suchaobin
 * @description 库存
 * @date 2020/12/18 23:56
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("seata_storage.t_storage")
public class Storage {
    @TableId(type = IdType.AUTO)
    private Long id;

    private Long productId;

    private Integer total;

    private Integer used;

    private Integer residue;
}
