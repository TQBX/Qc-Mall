package com.qingcheng.controller.order;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.pojo.order.CategoryReport;
import com.qingcheng.service.order.CategoryReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Summerday
 */

@RestController
@RequestMapping("/categoryReport")
public class CategoryReportController {

    @Reference
    private CategoryReportService categoryReportService;

    /**
     * 昨日商品类目统计
     *
     * @return
     */
    @GetMapping("/yesterday")
    public List<CategoryReport> yesterday() {
        //LocalDate localDate = LocalDate.now().minusDays(1);
        LocalDate localdate = LocalDate.parse("2019-04-15");
        return categoryReportService.categoryReport(localdate);
    }

    @GetMapping("/category1Count")
    public List<Map> category1Count(String date1, String date2) {
        return categoryReportService.category1Count(date1, date2);
    }

}
