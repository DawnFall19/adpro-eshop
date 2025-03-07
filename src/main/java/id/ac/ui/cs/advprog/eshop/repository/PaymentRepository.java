package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {
    private Map<Payment, Order> paymentData = new HashMap<>();
    private List<Payment> payments = new ArrayList<>();
    public Payment addPayment(Payment payment) {
        return null;
    }
    public Payment setStatus(Payment payment, String status) {
        return null;
    }
    public Payment getPayment(Payment payment) {
        return null;
    }
    public List<Payment> getPayments() {
        return null;
    }
}