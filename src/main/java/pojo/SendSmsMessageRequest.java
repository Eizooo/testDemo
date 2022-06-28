package pojo;


import java.io.Serializable;


public class SendSmsMessageRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msisdn;//手机号码
	private String accepterMobile;//接收手机号码
	private String message;//发送的消息
	private String wapUrl;//推荐地址
	private String sender;//发送者
	private String serviceType;//场景类型ID
	private Boolean isSendByNews;//是否通过卓旺平台下发 默认为false
	private String smsSign;//短信签名，如果sender为空或者是以10658080开头，此字段不为空，短信签名则使用此字段值，否则使用默认短信签名
	public String getMsisdn() {
		return msisdn;
	}
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	public String getAccepterMobile() {
		return accepterMobile;
	}
	public void setAccepterMobile(String accepterMobile) {
		this.accepterMobile = accepterMobile;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getWapUrl() {
		return wapUrl;
	}
	public void setWapUrl(String wapUrl) {
		this.wapUrl = wapUrl;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Boolean getIsSendByNews() {
		return isSendByNews;
	}
	public void setIsSendByNews(Boolean isSendByNews) {
		this.isSendByNews = isSendByNews;
	}
	public String getSmsSign() {
		return smsSign;
	}
	public void setSmsSign(String smsSign) {
		this.smsSign = smsSign;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
