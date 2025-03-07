package id.ac.ui.cs.advprog.eshop.service;

import enums.OrderStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.List;
import java.util.Map;

public interface OrderService {
    public Order createOrder(Order order);
    public Order updateStatus(String orderId, String status);
    public Order findById(String orderId);
    public List<Order> findAllByAuthor(String author);
}