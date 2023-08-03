package socialMediaApp.questApp.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikeCreateRequest {
	
	private int id;
	private int userId;
	private int postId;
}
