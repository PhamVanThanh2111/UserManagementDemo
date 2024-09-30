package models;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="users")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "User.findAllNative", query = "SELECT * FROM [users]", resultClass = User.class)
})
public class User {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    protected int id;
 
    @Column(name="firstName")
    @NotNull(message = "First name must be not null")
    @NotEmpty(message = "First name must be not empty")
    @Size(min = 8, max = 50, message = "First name must be between 8 and 50 characters")
    protected String firstName;
    
    @Column(name="lastName")
    @NotNull(message = "Last name must be not null")
    @NotEmpty(message = "Last name must be not empty")
    @Size(min = 8, max = 50, message = "Last name must be between 8 and 50 characters")
    protected String lastName;
 
    @Column(name="email")
    @NotEmpty(message = "Name must be not empty")
    @Email(message = "Email should be valid")
    protected String email;
 
    @Column(name="password")
    protected String password;
    
    @Column(name = "birthday")
    protected LocalDate birthday;
    
    @Column(name = "gender")
    protected String gender;
 
    public User() {
    	super();
    }

	public User(int id,
			@NotNull(message = "First name must be not null") @NotEmpty(message = "First name must be not empty") @Size(min = 8, max = 50, message = "First name must be between 8 and 50 characters") String firstName,
			@NotNull(message = "Last name must be not null") @NotEmpty(message = "Last name must be not empty") @Size(min = 8, max = 50, message = "Last name must be between 8 and 50 characters") String lastName,
			@NotEmpty(message = "Name must be not empty") @Email(message = "Email should be valid") String email,
			String password, LocalDate birthDay, String gender) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthday = birthDay;
		this.gender = gender;
	}

	public User(
			@NotNull(message = "First name must be not null") @NotEmpty(message = "First name must be not empty") @Size(min = 8, max = 50, message = "First name must be between 8 and 50 characters") String firstName,
			@NotNull(message = "Last name must be not null") @NotEmpty(message = "Last name must be not empty") @Size(min = 8, max = 50, message = "Last name must be between 8 and 50 characters") String lastName,
			@NotEmpty(message = "Name must be not empty") @Email(message = "Email should be valid") String email,
			String password, LocalDate birthDay, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.birthday = birthDay;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getBirthDay() {
		return birthday;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthday = birthDay;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
