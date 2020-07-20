package com.qingcheng.service.order;

import com.qingcheng.pojo.order.CategoryReport;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

/**
 * @author Summerday
 */
public interface CategoryReportService {

    List<CategoryReport> categoryReport( LocalDate date);

    void createData();

    List<Map> category1Count(String date1, String date2);
}
