package travel.dto;

public class MarketCommentDTO {
	private int market_comment_num;
	private int market_num;
	private String market_comment_writer;
	private String market_comment_content;
	private String market_comment_w_date;
	public MarketCommentDTO(){}
	public MarketCommentDTO(int market_comment_num, int market_num,String market_comment_writer,
			String market_comment_content, String market_comment_w_date) {
		super();
		this.market_comment_num = market_comment_num;
		this.market_num = market_num;
		this.market_comment_writer = market_comment_writer;
		this.market_comment_content = market_comment_content;
		this.market_comment_w_date = market_comment_w_date;
	}
	public int getMarket_comment_num() {
		return market_comment_num;
	}
	public void setMarket_comment_num(int market_comment_num) {
		this.market_comment_num = market_comment_num;
	}
	public int getMarket_num() {
		return market_num;
	}
	public void setMarket_num(int market_num) {
		this.market_num = market_num;
	}	
	public String getMarket_comment_writer() {
		return market_comment_writer;
	}
	public void setMarket_comment_writer(String market_comment_writer) {
		this.market_comment_writer = market_comment_writer;
	}
	public String getMarket_comment_content() {
		return market_comment_content;
	}
	public void setMarket_comment_content(String market_comment_content) {
		this.market_comment_content = market_comment_content;
	}
	public String getMarket_comment_w_date() {
		return market_comment_w_date;
	}
	public void setMarket_comment_w_date(String market_comment_w_date) {
		this.market_comment_w_date = market_comment_w_date;
	}	
}
