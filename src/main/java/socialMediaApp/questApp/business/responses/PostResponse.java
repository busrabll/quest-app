package socialMediaApp.questApp.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import socialMediaApp.questApp.entities.Post;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse {

	private int id;
	private int userId;
	private String userName;
	private String title;
	private String text;
	
	
	public PostResponse(Post entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
		this.userName = entity.getUser().getUserName();
		this.title = entity.getTitle();
		this.text = entity.getText();
	}

}
