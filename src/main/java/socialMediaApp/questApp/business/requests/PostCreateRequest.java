package socialMediaApp.questApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostCreateRequest {
	
	private int id;
	private String text;
	private String title;
	private int userId;

}
