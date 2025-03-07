package id.ac.ui.cs.advprog.eshop.service;

import enums.PaymentStatus;
import id.ac.ui.cs.advprog.eshop.model.Order;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.model.Payment;
import id.ac.ui.cs.advprog.eshop.repository.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PaymentServiceTest {
    Order order;
    @InjectMocks
    PaymentServiceImpl paymentService;
    @Mock
    PaymentRepository paymentRepository;
    Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
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
    void testCreatePaymentAndCheckAll() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = paymentService.addPayment(order, "VOUCHER", paymentData);
        assertNotNull(payment);
        List<Payment> payments = paymentService.getAllPayments();
        assertEquals(1, payments.size());
    }

    @Test
    void testUpdateStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = paymentService.addPayment(order, "VOUCHER", paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
        Payment result = paymentService.setStatus(payment, PaymentStatus.REJECTED.getValue());
        assertEquals(PaymentStatus.REJECTED.getValue(), payment.getStatus());
    }
}