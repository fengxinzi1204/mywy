package com.mzd.mywy.service;

import com.mzd.mywy.exception.CongestionException;
import com.mzd.mywy.utils.MyStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class MsService {

    @Autowired
    private RedisLock redisLock;
    /**
     * 商品详情
     */
    private static HashMap<String, Integer> product = new HashMap<>(16);
    /**
     * 订单表
     */
    private static HashMap<String, String> orders = new HashMap<>(16);
    /**
     * 库存表
     */
    private static HashMap<String, Integer> stock = new HashMap<>(16);

    static {
        product.put("123", 10000);
        stock.put("123", 10000);
    }

    public String select_info(String productId) {
        return "限量抢购商品XXX共" + product.get(productId) + ",现在成功下单" + orders.size()
                + ",剩余库存" + stock.get(productId) + "件";
    }

    private boolean order(String productId) {
        if (stock.get(productId) == 0) {
            return false;
            //已近买完了
        } else {
            //还没有卖完
            try {
                //模拟操作数据库
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            orders.put(MyStringUtils.getuuid(), productId);
            stock.put(productId, stock.get(productId) - 1);
            return true;
        }
    }

    /**
     * 高并发有问题
     *
     * @param productId
     * @return
     */
    public String order1(String productId) {
        if (!order(productId)) {
            return "活动已经结束了";
        }
        return select_info(productId);
    }


    /**
     * 高并发没问题，但是效率低下
     *
     * @param productId
     * @return
     */
    public synchronized String order2(String productId) {
        if (!order(productId)) {
            return "活动已经结束了";
        }
        return select_info(productId);
    }

    /**
     * 高并发没问题，效率还行
     *
     * @param productId
     * @return
     */
    public String order3(String productId) throws CongestionException {
        //redis加锁
        String value = System.currentTimeMillis() + 10000 + "";
        if (!redisLock.lock3(productId, value)) {
            throw new CongestionException();
        }
        if (!order(productId)) {
            return "活动已经结束了";
        }
        //redis解锁
        redisLock.unlock(productId, value);
        return select_info(productId);
    }

}
