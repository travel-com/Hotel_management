package travel.com.bo;

public class Guest {
	private long id;
	private String name;
	private String email;
	private String mobile;
	private String idProof;
	private String roomNo;
	private java.util.Date arrivalDate;
	private java.util.Date departureDate;
	private String address;
    /**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the roomNo
	 */
	public String getRoomNo() {
		return roomNo;
	}
	/**
	 * @param roomNo the roomNo to set
	 */
	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	private java.util.Date ArrivalDate;
     private java.util.Date DepartureDate;
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the adhaar
	 */
	public String getIdProof() {
		return idProof;
	}
	/**
	 * @param adhaar the adhaar to set
	 */
	public void setIdProof(String idProof) {
		this.idProof = idProof;
	}
	/**
	 * @return the arrivalDate
	 */
	public java.util.Date getArrivalDate() {
		return ArrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(java.util.Date arrivalDate) {
		ArrivalDate = arrivalDate;
	}
	/**
	 * @return the departureDate
	 */
	public java.util.Date getDepartureDate() {
		return DepartureDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartureDate(java.util.Date departureDate) {
		DepartureDate = departureDate;
	}

}
