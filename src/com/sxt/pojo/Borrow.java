package com.sxt.pojo;

public class Borrow {
	private int uid;
	private String uname;
	private int bid;
	private String bname;
	private String borrowtime;
	private String returntime;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBorrowtime() {
		return borrowtime;
	}
	public void setBorrowtime(String borrowtime) {
		this.borrowtime = borrowtime;
	}
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public Borrow(int uid, String uname, int bid, String bname,
			String borrowtime, String returntime) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.bid = bid;
		this.bname = bname;
		this.borrowtime = borrowtime;
		this.returntime = returntime;
	}
	public Borrow() {
		super();
	}
	@Override
	public String toString() {
		return "Borrow [uid=" + uid + ", uname=" + uname + ", bid=" + bid
				+ ", bname=" + bname + ", borrowtime=" + borrowtime
				+ ", returntime=" + returntime + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bid;
		result = prime * result + ((bname == null) ? 0 : bname.hashCode());
		result = prime * result
				+ ((borrowtime == null) ? 0 : borrowtime.hashCode());
		result = prime * result
				+ ((returntime == null) ? 0 : returntime.hashCode());
		result = prime * result + uid;
		result = prime * result + ((uname == null) ? 0 : uname.hashCode());
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
		Borrow other = (Borrow) obj;
		if (bid != other.bid)
			return false;
		if (bname == null) {
			if (other.bname != null)
				return false;
		} else if (!bname.equals(other.bname))
			return false;
		if (borrowtime == null) {
			if (other.borrowtime != null)
				return false;
		} else if (!borrowtime.equals(other.borrowtime))
			return false;
		if (returntime == null) {
			if (other.returntime != null)
				return false;
		} else if (!returntime.equals(other.returntime))
			return false;
		if (uid != other.uid)
			return false;
		if (uname == null) {
			if (other.uname != null)
				return false;
		} else if (!uname.equals(other.uname))
			return false;
		return true;
	}
	
}
