package noval.surya.mandala.validation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import noval.surya.mandala.validation.constraint.CheckCase;
import noval.surya.mandala.validation.constraint.CheckOrderId;
import noval.surya.mandala.validation.enums.CaseMode;
import noval.surya.mandala.validation.group.CreditCardPaymentGroup;
import noval.surya.mandala.validation.group.Customer;
import noval.surya.mandala.validation.group.VirtualAccountPaymentGroup;
import noval.surya.mandala.validation.payload.EmailErrorPayload;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @CheckOrderId(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
    message = "{order.id.invalid}")
    private String orderId;

    @Range(groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
            min = 10_000L, max = 100_000_000, message = "{order.amount.range}")
    @NotNull(groups = {Default.class, CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}
            ,message = "amount cannot null")
    private Long amount;

    @LuhnCheck(groups = {CreditCardPaymentGroup.class},message = "invalid credit card number",
    payload = {EmailErrorPayload.class})
    @NotNull(groups = {CreditCardPaymentGroup.class}, message = "credit card cannot null")
    private String creditCard;

    @NotBlank(groups = {VirtualAccountPaymentGroup.class}
            ,message = "virtual account cannot blank")
    private String virtualAccount;

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public Payment() {
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Valid
    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class},
                message = "customer cannot null")
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
