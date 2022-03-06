package com.koc.webapp.utils;

public sealed interface Result  {
	public final class Success<T> implements Result {
		private T payload;
		
		public Success() {
		}
		
		
		public Success(T payload) {
			super();
			this.payload = payload;
		}

		public void setPayload(T payload) {
			this.payload = payload;
		}
		
		public T getPayload() {
			return payload;
		}
		
	}
	
	public final class Error implements Result {
		private String message;
		
		public Error(String message) {
			super();
			this.message = message;
		}
		
		public String getMessage() {
			return this.message;
		}
	}
}
