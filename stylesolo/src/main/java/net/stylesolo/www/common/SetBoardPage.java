package net.stylesolo.www.common;

import java.util.HashMap;

public class SetBoardPage {
	private int pageNum;
	private int startRow;
	private int endRow;
	private int totalPageCount;
	private int startPageNum;
	private int endPageNum;
	private int rowBlockCount = CommonConstants.INITROWCOUNT;
	private int pageBlockCount = CommonConstants.INITPAGEBLOCKCOUNT;
	private int totalRowCount;
	
	public SetBoardPage(){}
	
	public SetBoardPage(int pageNum, int totalNumberOfPost) {
		this.pageNum = pageNum;
		this.startRow = ((pageNum - 1) * rowBlockCount) + 1;
		this.endRow = startRow + rowBlockCount - 1;
		this.totalPageCount = (int)Math.ceil(totalRowCount / (double)rowBlockCount);
		this.startPageNum = ((pageNum - 1) / pageBlockCount * pageBlockCount) + 1;
		this.endPageNum = startPageNum + pageBlockCount - 1;
		if(totalPageCount < endPageNum){
			this.endPageNum = totalPageCount;
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public int getStartRow() {
		return startRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public int getStartPageNum() {
		return startPageNum;
	}

	public int getEndPageNum() {
		return endPageNum;
	}

	public int getRowBlockCount() {
		return rowBlockCount;
	}

	public int getPageBlockCount() {
		return pageBlockCount;
	}

	public int getTotalRowCount() {
		return totalRowCount;
	}
	
	
}
