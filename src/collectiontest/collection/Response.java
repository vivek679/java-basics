package collectiontest.collection;

import java.util.List;

public class Response {
	@Override
	public String toString() {
		return "Response [customers=" + customers + "]";
	}

	public List<CustomerDomestic> getCustomers() {
		return customers;
	}

	public void setCustomers(List<CustomerDomestic> customers) {
		this.customers = customers;
	}

	public Response(List<CustomerDomestic> customers) {
		super();
		this.customers = customers;
	}

	public Response() {
		// TODO Auto-generated constructor stub
	}

	private List<CustomerDomestic> customers;
}
