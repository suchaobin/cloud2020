package springcloud.service.impl;

import com.atguigu.springcloud.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springcloud.dao.PaymentDao;
import springcloud.service.PaymentService;

/**
 * @author suchaobin
 * @description 实现类
 * @date 2020/8/12 17:40
 **/
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    /**
     * 添加Payment
     *
     * @param payment payment对象
     * @return
     */
    @Override
    public int addPayment(Payment payment) {
        return paymentDao.addPayment(payment);
    }

    /**
     * 通过id获取Payment
     *
     * @param id id
     * @return
     */
    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
