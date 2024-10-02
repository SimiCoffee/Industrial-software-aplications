package dummy;

enum Gender {
	MALE, FEMALE, NONBINARY
}

public class Author {
	public String name;
	public String email;
	public Gender gender;

	public Author(String author, String email, Gender gender) {
		this.name = author;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String author) {
		this.name = author;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Author [name=" + name + ", email=" + email + ", gender=" + gender + "]";
	}

}
