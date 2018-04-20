package travel.dto;

public class MarketImageDTO {
	private int market_image_num;
	private int market_num;
	private String market_image_fileName;
	private String market_image_saveFileName;
	public MarketImageDTO(){}
	public MarketImageDTO(int market_image_num, int market_num, String market_image_fileName,
			String market_image_saveFileName) {
		super();
		this.market_image_num = market_image_num;
		this.market_num = market_num;
		this.market_image_fileName = market_image_fileName;
		this.market_image_saveFileName = market_image_saveFileName;
	}
	public int getMarket_image_num() {
		return market_image_num;
	}
	public void setMarket_image_num(int market_image_num) {
		this.market_image_num = market_image_num;
	}
	public int getMarket_num() {
		return market_num;
	}
	public void setMarket_num(int market_num) {
		this.market_num = market_num;
	}
	public String getMarket_image_fileName() {
		return market_image_fileName;
	}
	public void setMarket_image_fileName(String market_image_fileName) {
		this.market_image_fileName = market_image_fileName;
	}
	public String getMarket_image_saveFileName() {
		return market_image_saveFileName;
	}
	public void setMarket_image_saveFileName(String market_image_saveFileName) {
		this.market_image_saveFileName = market_image_saveFileName;
	}
}
