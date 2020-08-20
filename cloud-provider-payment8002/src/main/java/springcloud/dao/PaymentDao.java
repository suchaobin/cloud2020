package springcloud.dao;

import com.atguigu.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suchaobin
 * @description dao层
 * @date 2020/8/12 17:35
 **/
@Mapper
public interface PaymentDao {
    int addPayment(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
