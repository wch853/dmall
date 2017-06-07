package com.dmall.beans.purchase;

/**
 * 供应商实体类
 * 
 * @author wch
 *
 */
public class Provider {

	private Integer providerId;
	private String providerName;

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	@Override
	public String toString() {
		return "Provider [providerId=" + providerId + ", providerName=" + providerName + "]";
	}

}
