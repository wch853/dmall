package com.dmall.beans;

/**
 * 客户实体类
 * 
 * @author wch
 *
 */
public class Client {
	private Integer clientId;
	private String username;
	private String password;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", username=" + username + ", password=" + password + "]";
	}

}
