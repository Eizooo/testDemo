package dto;


import java.io.Serializable;

/**
 * 一级支付http entity
 * @author:刘航
 * Created on 2017年11月3日 上午10:30:15
 */

public class AdvPayHttpRes implements Serializable {

	private static final long serialVersionUID = 7262956898455638916L;
	
	/**
	 * 公共数据
	 */
	private PubInfo pubInfo;
	/**
	 * 业务数据
	 */
	private Object busiData;


	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public PubInfo getPubInfo() {
		return pubInfo;
	}

	public void setPubInfo(PubInfo pubInfo) {
		this.pubInfo = pubInfo;
	}

	public Object getBusiData() {
		return busiData;
	}

	public void setBusiData(Object busiData) {
		this.busiData = busiData;
	}

	@Override
	public String toString() {
		return "AdvPayHttpRes{" +
				"pubInfo=" + pubInfo +
				", busiData=" + busiData +
				'}';
	}
}
