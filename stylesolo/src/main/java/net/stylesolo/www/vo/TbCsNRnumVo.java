package net.stylesolo.www.vo;

public class TbCsNRnumVo {
		private int rnum;
		private int cs_notice_num;
		
		public TbCsNRnumVo(){}

		public TbCsNRnumVo(int rnum, int cs_notice_num) {
			super();
			this.rnum = rnum;
			this.cs_notice_num = cs_notice_num;
		}

		public int getRnum() {
			return rnum;
		}

		public void setRnum(int rnum) {
			this.rnum = rnum;
		}

		public int getCs_notice_num() {
			return cs_notice_num;
		}

		public void setCs_notice_num(int cs_notice_num) {
			this.cs_notice_num = cs_notice_num;
		}
		
}
