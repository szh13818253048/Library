package com.sxt.pojo;

public class Book {
	// Í¼Êé±àºÅ
	int bId;
	// Í¼ÊéÃû×Ö
	String bname;
	// Í¼Êé×´Ì¬
	String status;
	
	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bId;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Book other = (Book) obj;
		if (bId != other.bId)
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bId, String bname, String status) {
		super();
		this.bId = bId;
		this.bname = bname;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bname=" + bname + ", status=" + status
				+ "]";
	}

}
