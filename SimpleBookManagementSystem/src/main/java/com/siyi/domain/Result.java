package com.siyi.domain;

import java.io.Serializable;

public class Result implements Serializable {

	private boolean success;
	private Object data;

	public boolean getSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result{" +
				"success=" + success +
				", data=" + data +
				'}';
	}
}
