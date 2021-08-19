package com.mockitotutorial.happyhotel.booking;

import java.time.LocalDate;

public class BookingRequest {

	private final String userId;
	private final LocalDate dateFrom;
	private final LocalDate dateTo;
	private final int guestCount;
	private final boolean prepaid;
	private String roomId;
	
	public BookingRequest(String userId, LocalDate dateFrom, LocalDate dateTo, int guestCount, boolean prepaid) {
		super();
		this.userId = userId;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.guestCount = guestCount;
		this.prepaid = prepaid;
	}

	public String getUserId() {
		return userId;
	}

	public LocalDate getDateFrom() {
		return dateFrom;
	}

	public LocalDate getDateTo() {
		return dateTo;
	}

	public int getGuestCount() {
		return guestCount;
	}

	public boolean isPrepaid() {
		return prepaid;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((dateFrom == null) ? 0 : dateFrom.hashCode());
		result = prime * result + ((dateTo == null) ? 0 : dateTo.hashCode());
		result = prime * result + guestCount;
		result = prime * result + (prepaid ? 1231 : 1237);
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingRequest other = (BookingRequest) obj;
		if (dateFrom == null) {
			if (other.dateFrom != null)
				return false;
		} else if (!dateFrom.equals(other.dateFrom))
			return false;
		if (dateTo == null) {
			if (other.dateTo != null)
				return false;
		} else if (!dateTo.equals(other.dateTo))
			return false;
		if (guestCount != other.guestCount)
			return false;
		if (prepaid != other.prepaid)
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
}
