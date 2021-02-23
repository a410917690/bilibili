package org.lanqiao.vo;

import lombok.Data;
import org.lanqiao.entity.TOrders;
import java.io.Serializable;

/**
 * @author Sonnie Guo
 * @PackageName:org.lanqiao.vo
 * @ClassName:OrderVoToOrder
 * @Description:
 * @Date 2021/2/18 12:49
 */
@Data
public class TOrderToOrderVo implements Serializable {

     public static OrdersVo ToOrderVo(TOrders tOrders){
         OrdersVo ordersVo = new OrdersVo();
         ordersVo.setI_name(tOrders.getI_name());
         ordersVo.setMoney(tOrders.getMoney());
         ordersVo.setO_no(tOrders.getO_no());
         ordersVo.setRetUrl("http://localhost:8084/b_index.html");

         return ordersVo;
     }

}
