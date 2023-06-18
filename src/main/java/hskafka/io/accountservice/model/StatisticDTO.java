package hskafka.io.accountservice.model;

public class StatisticDTO {
	private String message;
	private String createdDate;
	
	public StatisticDTO(String message, String createdDate) {
		super();
		this.message = message;
		this.createdDate = createdDate;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
}
