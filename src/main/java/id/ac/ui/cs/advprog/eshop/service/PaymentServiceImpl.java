package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        Payment payment = paymentRepository.addPayment(order, method, paymentData);
        return payment;
    }
    @Override
    public Payment setStatus(Payment payment, String status) {
        return paymentRepository.setStatus(payment, status);
    }
    @Override
    public Payment getPayment(String paymentId) {
        return paymentRepository.getPayment(paymentId);
    }
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.getAllPayments();
    }
}