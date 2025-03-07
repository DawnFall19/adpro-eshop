package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PaymentRepository {
    private Map<Payment, Order> paymentData = new HashMap<>();
    private List<Payment> payments = new ArrayList<>();
    public Payment addPayment(Order order, String method, Map<String, String> paymentData) {
        String id = UUID.randomUUID().toString();
        Payment payment = new Payment(id, method, paymentData);
        this.paymentData.put(payment, order);
        this.payments.add(payment);
        return payment;
    }
    public Payment setStatus(Payment payment, String status) {
        for (Payment pay : payments) {
            if (pay.getId().equals(payment.getId())) {
                pay.setStatus(status);
                Order order = this.paymentData.get(payment);
                order.setStatus(status);
            }
        }
        return payment;
    }
    public Payment getPayment(String paymentId) {
        for (Payment payment : payments) {
            if (payment.getId().equals(paymentId)) {
                return payment;
            }
        }
        return null;
    }
    public List<Payment> getAllPayments() {
        return this.payments;
    }
}