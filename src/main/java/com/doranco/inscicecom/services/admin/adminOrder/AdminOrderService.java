package com.doranco.inscicecom.services.admin.adminOrder;

import com.doranco.inscicecom.dto.AnalyticsResponse;
import com.doranco.inscicecom.dto.OrderDto;

import java.util.List;

public interface AdminOrderService {
    List<OrderDto> getAllPlacedOrders();

    OrderDto changeOrderStatus(Long orderId, String status);

    AnalyticsResponse calculateAnalytics();

    Long getTotalOrdersForMonths(int month, int year);

    Long getTotalEarningsForMonth(int month, int year);
}
