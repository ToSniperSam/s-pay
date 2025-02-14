package org.example.dao;

import org.apache.ibatis.annotations.Mapper;
import org.example.domain.po.PayOrder;

import java.util.List;

@Mapper
public interface IOrderDao {

    void insert(PayOrder payOrder);

    void updateOrderPayInfo(PayOrder payOrder);
    PayOrder queryUnPaidOrder(PayOrder payOrder);

    void changeOrderPaySuccess(PayOrder order);

    List<String> queryNoPayNotifyOrder();

    List<String> queryTimeoutCloseOrderList();

    boolean changeOrderClose(String orderId);
}
