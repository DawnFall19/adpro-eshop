package id.ac.ui.cs.advprog.eshop.model;

import enums.PaymentStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class Payment {
    private String id;
    private String method;
    private String status;
    private Map<String, String> paymentData;

    public Payment(String id, String method, Map<String, String> paymentData) {
        this.id = id;
        this.method = method;
        this.paymentData = paymentData;
        if (method.equals("VOUCHER")) {
            if (isVoucherValid(paymentData)) {
                this.status = PaymentStatus.SUCCESS.getValue();
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }
        } else {
            if (isBankTransferValid(paymentData)) {
                this.status = PaymentStatus.SUCCESS.getValue();
            } else {
                this.status = PaymentStatus.REJECTED.getValue();
            }
        }
    }

    private boolean isVoucherValid(Map<String, String> paymentData) {
        String voucherString = paymentData.get("voucherCode");
        return voucherString != null && voucherString.length() == 16 && voucherString.startsWith("ESHOP") && countNumerical(voucherString) == 8;
    }

    private int countNumerical(String voucherString) {
        int cnt = 0;
        for (int i = 0; i < voucherString.length(); i++) {
            char ch = voucherString.charAt(i);
            if (ch >= '0' && ch <= '9') {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean isBankTransferValid(Map<String, String> paymentData) {
        String bankNameString = paymentData.get("bankName");
        String referenceCodeString = paymentData.get("referenceCode");
        return bankNameString != null && referenceCodeString != null && !bankNameString.isEmpty() && !referenceCodeString.isEmpty();
    }

    public void setStatus(String status) {
        if (PaymentStatus.contains(status)) {
            this.status = status;
        } else {
            throw new IllegalArgumentException();
        }
    }
}