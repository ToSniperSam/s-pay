package org.example.domain.res;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.common.constants.Constants;
import org.example.common.constants.Constants;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PayOrderRes {
    private String userId;
    private String orderId;
    private String payUrl;
    private Constants.OrderStatusEnum orderStatusEnum;

}
