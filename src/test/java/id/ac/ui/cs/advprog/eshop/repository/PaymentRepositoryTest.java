package id.ac.ui.cs.advprog.eshop.repository;

import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentRepositoryTest {
    PaymentRepository paymentRepository;

    Order order;

    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentRepository = new PaymentRepository();
        List<Product> products = new ArrayList<>();
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        products.add(product1);

        order = new Order("13652556-012a-4c07-b546-54eb1396d79b",
            products, 1708560000L, "Safira Sudrajat");

        paymentData = new HashMap<>();
    }

    @Test
    void testCreateAndFindByIdIfIdFound() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = paymentRepository.addPayment(order, "VOUCHER", paymentData);
        Payment result = paymentRepository.getPayment(payment.getId());
        assertNotNull(result);
        assertEquals(payment.getId(), result.getId());
        assertEquals(payment.getStatus(), result.getStatus());
    }

    @Test
    void testFindByIdIfIdNotFound() {
        paymentData.put("voucherCode", "ESHOP1234ABC567");
        Payment payment = paymentRepository.addPayment(order, "VOUCHER", paymentData);
        Payment result = paymentRepository.getPayment("zczc");
        assertNull(result);
    }

    @Test
    void testGetAllPayments() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        paymentRepository.addPayment(order, "VOUCHER", paymentData);
        paymentData.clear();
        paymentData.put("BankName", "BCU");
        paymentData.put("ReferenceCode", "BCU-TRX-1234");
        paymentRepository.addPayment(order, "BANK_TRANSFER", paymentData);
        List<Payment> payments = paymentRepository.getAllPayments();
        assertEquals(2, payments.size());
    }
}