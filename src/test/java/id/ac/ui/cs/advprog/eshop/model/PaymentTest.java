package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {
    private Map<String, String> paymentData;

    @BeforeEach
    void setUp() {
        paymentData = new HashMap<>();
    }

    @Test
    void testCreateVoucherPaymentWithValidVoucher() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment = new Payment("8af6d025-5c22-4f70-a6c8-9d4be621f9f5", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment.getStatus());
    }

    @Test
    void testCreateVoucherPaymentWithInvalidVoucher() {
        Payment payment1 = new Payment("6fb769d7-6d76-433a-8f71-df8f5aa7715c", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment1.getStatus());
        paymentData.put("voucherCode", "ESHOP1234ABCD678");
        Payment payment2 = new Payment("8af6d025-5c22-4f70-a6c8-9d4be621f9f5", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment2.getStatus());
        paymentData.put("voucherCode", "ESHOP1234ABC567");
        Payment payment3 = new Payment("98ceeaa9-5b64-4a05-8a3e-8641bc0a1f63", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment3.getStatus());
        paymentData.put("voucherCode", "HALOO1234ABC5689");
        Payment payment4 = new Payment("3bce63b3-e502-4da5-b94c-03218764648d", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment4.getStatus());
    }

    @Test
    void testSetStatusToSuccess() {
        paymentData.put("voucherCode", "ESHOP1234ABC567");
        Payment payment1 = new Payment("6fb769d7-6d76-433a-8f71-df8f5aa7715c", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.REJECTED.getValue(), payment1.getStatus());
        payment1.setStatus("SUCCESS");
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment1.getStatus());
        paymentData.put("voucherCode", "ESHOP1234ABC5678");
        Payment payment2 = new Payment("8af6d025-5c22-4f70-a6c8-9d4be621f9f5", "VOUCHER", paymentData);
        assertEquals(PaymentStatus.SUCCESS.getValue(), payment2.getStatus());
        payment2.setStatus("FAILED");
        assertEquals(PaymentStatus.FAILED.getValue(), payment2.getStatus());
    }
}