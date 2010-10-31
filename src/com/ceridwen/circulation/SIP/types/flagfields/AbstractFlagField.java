package com.ceridwen.circulation.SIP.types.flagfields;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class AbstractFlagField implements Serializable {

	private static final long serialVersionUID = -3439876098750195408L;
	String flags;
	
	@Deprecated
	public String getFlags() {
		return this.flags;
	}

	@Deprecated	
	public void setFlags(String flags) {
		this.flags = flags;
		this.checkLength();
	}	
	
	AbstractFlagField(String flags) {
		this.flags = flags;
		this.checkLength();
	}

	abstract protected int getLength();
	abstract protected char[] getValid();
	
	private boolean isValid(char ch) {
		for (char valid: this.getValid()) {
			if (ch == valid) {
				return true;
			}
		}
		return false;
	}
	
	private void checkLength() {
		StringBuffer result = new StringBuffer("");
		for (int i=0; i < this.getLength(); i++) {
			if (i < this.flags.length()) {
				char ch = this.flags.charAt(i);
				if (isValid(ch)) {
					result.append(ch);
				} else {
					result.append(this.getValid()[0]);
				}
			} else {
				result.append(this.getValid()[0]);				
			}
		}
		this.flags = result.toString();
	}
	
	public String toString() {
		this.checkLength();
		return flags;
	}
	
	public boolean isSet(int field) {
		this.checkLength();
		if (field < flags.length() && this.getValid().length > 0) {
			if (flags.charAt(field) == this.getValid()[this.getValid().length -1]) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public void set(int field) {
		this.checkLength();
		if (field < flags.length() && this.getValid().length > 0) {
			this.flags = this.flags.substring(0, field) + this.getValid()[this.getValid().length -1] + this.flags.substring(field+1);
		}		
	}

	public void unset(int field) {
		this.checkLength();
		if (field < flags.length() && this.getValid().length > 0) {
			this.flags = this.flags.substring(0, field) + this.getValid()[0] + this.flags.substring(field+1);
		}		
	}
	
	public void unsetAll() {
		this.flags = "";
		this.checkLength();
	}

	  private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
	    ois.defaultReadObject();
	  }

	  private void writeObject(ObjectOutputStream oos) throws IOException {
	    oos.defaultWriteObject();
	  }

}
