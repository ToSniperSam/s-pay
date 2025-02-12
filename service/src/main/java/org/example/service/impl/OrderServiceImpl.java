package org.example.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.common.constants.Constants;
import org.example.dao.IOrderDao;
import org.example.domain.po.PayOrder;
import org.example.domain.req.ShopCartReq;
import org.example.domain.res.PayOrderRes;
import org.example.domain.vo.ProductVO;
import org.example.service.IOrderService;
import org.example.service.rpc.ProductRPC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;


@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {


    @Resource
    private IOrderDao orderDao;

    @Resource
    private ProductRPC productRPC;


    @Override
    public PayOrderRes createOrder(ShopCartReq shopCartReq) throws Exception {
        PayOrder payOrderReq = new PayOrder();
        payOrderReq.setUserId(shopCartReq.getUserId());
        payOrderReq.setProductId(shopCartReq.getProductId());

        PayOrder unpaidOrder = orderDao.queryUnPaidOrder(payOrderReq);

        if(unpaidOrder != null && unpaidOrder.getStatus().equals(Constants.OrderStatusEnum.CREATE.getCode())){
            log.info("创建订单存在，已存在未支付订单, userId:{}, productId:{}, orderId:{}", shopCartReq.getUserId(), shopCartReq.getProductId(), unpaidOrder.getOrderId());
            return PayOrderRes.builder().orderId(unpaidOrder.getOrderId()).payUrl(unpaidOrder.getPayUrl()).build();
        }else if(unpaidOrder != null && Constants.OrderStatusEnum.CREATE.getCode().equals(unpaidOrder.getStatus())){

        }

        ProductVO productVO = productRPC.queryProductByProductId(shopCartReq.getProductId());
        String orderId = RandomStringUtils.randomNumeric(16);

        orderDao.insert(PayOrder.builder()                        .userId(shopCartReq.getUserId())
                .productId(shopCartReq.getProductId())
                .productName(productVO.getProductName())
                .orderId(orderId)
                .totalAmount(productVO.getPrice())
                .orderTime(new Date())
                .status(Constants.OrderStatusEnum.CREATE.getCode()).
                build());

        return PayOrderRes.builder().
                orderId(orderId).payUrl("http://www.baidu.com").build();
    }
}
