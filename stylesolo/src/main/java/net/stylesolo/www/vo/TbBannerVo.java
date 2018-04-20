package net.stylesolo.www.vo;

import java.util.Date;

public class TbBannerVo extends TbShopMenuVo{
	private int banner_num;
	private String banner_title;
	private String banner_img;
	private Date startDate;
	private Date endDate;
	
	public TbBannerVo() {
		super();
	}

	public TbBannerVo(int banner_num, String banner_title, String banner_img, Date startDate, Date endDate) {
		super();
		this.banner_num = banner_num;
		this.banner_title = banner_title;
		this.banner_img = banner_img;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getBanner_num() {
		return banner_num;
	}

	public String getBanner_title() {
		return banner_title;
	}

	public String getBanner_img() {
		return banner_img;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
}
