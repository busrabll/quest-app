package socialMediaApp.questApp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
@Entity
public class User {
	
	@Id
	private int id;
	private String userName;
	private String password;

}
