package com.qingcheng.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.service.order.CategoryReportService;
import com.qingcheng.service.order.OrderService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 定时任务demo
 * @author Summerday
 */

@Component
public class OrderTask {

    @Reference
    private OrderService orderService;

    @Reference
    private CategoryReportService categoryReportService;

    @Scheduled(cron = "0 0/2 * * * ?")
    public void orderTimeOutLogic(){
        System.out.println("每隔两分钟执行一次任务:"+new Date());
        orderService.orderTimeoutLogic();
    }

    @Scheduled(cron = "0 0 1 * * ?")
    public void createCategoryReportData(){
        System.out.println("凌晨一点生成类目统计数据");
        categoryReportService.createData();
    }
}
