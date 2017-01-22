package techcare.xmlparsing.com.xmlparsing;


/*
 * Data object that holds all of our information about a StackExchange Site.
 */
public class Data {

	private String title;
	private String link;
	private String description;
	private String imgUrl;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "StackSite [name=" + title+ ", link=" + link + ", about="
				+ description +"]";
	}
}
