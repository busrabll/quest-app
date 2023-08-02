package socialMediaApp.questApp.entities;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="likes")
@Entity
public class Like {
	
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="post_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private User user;
}
