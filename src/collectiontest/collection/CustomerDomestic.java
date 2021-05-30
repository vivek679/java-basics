package collectiontest.collection;

public class CustomerDomestic {
	@Override
	public String toString() {
		return "CustomerDomestic [isDomestic=" + isDomestic + ", customerId=" + customerId + "]";
	}
	public CustomerDomestic(Boolean isDomestic, Long customerId) {
		super();
		this.isDomestic = isDomestic;
		this.customerId = customerId;
	}
	public Boolean getIsDomestic() {
		return isDomestic;
	}
	public void setIsDomestic(Boolean isDomestic) {
		this.isDomestic = isDomestic;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	Boolean isDomestic;
	Long customerId;
}
