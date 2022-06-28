package pojo;

/**
 * 一级支付http entity公共数据
 * @author:刘航
 * Created on 2017年11月3日 上午10:33:14
 */

public class PubInfo {


	private String version;

	private String transactionId;

	private String transactionDate;

	private String busiCode;

	private String originId;

	private String returnCode;

	private String returnMsg;

	private String verifyCode;

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getBusiCode() {
		return busiCode;
	}

	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}

	public String getOriginId() {
		return originId;
	}

	public void setOriginId(String originId) {
		this.originId = originId;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	@Override
	public String toString() {
		return "PubInfo{" +
				"version='" + version + '\'' +
				", transactionId='" + transactionId + '\'' +
				", transactionDate='" + transactionDate + '\'' +
				", busiCode='" + busiCode + '\'' +
				", originId='" + originId + '\'' +
				", returnCode='" + returnCode + '\'' +
				", returnMsg='" + returnMsg + '\'' +
				", verifyCode='" + verifyCode + '\'' +
				'}';
	}
}
