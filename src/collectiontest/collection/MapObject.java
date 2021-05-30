package collectiontest.collection;

public class MapObject {
	private String key;
	private String CustomerId;

	public String getKey() {
		return key;
	}

	@Override
	public String toString() {
		return "MapObject [key=" + key + ", CustomerId=" + CustomerId + "]";
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	public MapObject(String key, String customerId) {
		super();
		this.key = key;
		CustomerId = customerId;
	}
}
