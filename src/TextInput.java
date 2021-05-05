
public class TextInput {
	private String value = "";
	
	public TextInput() {
		
	}
	
	public void addValue(char value) {
		this.value += value;
	}
	
	public String getValue() {
		return this.value;
	}
}
