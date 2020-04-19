package s1142_5.appointment;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HelloModel {
	
	public HelloModel(String greeteing, String name) {
		super();
		this.greeteing = greeteing;
		this.setName(name);
	}
	private String greeteing;
	public String getGreeteing() {
		return greeteing;
	}
	public void setGreeteing(String greeteing) {
		this.greeteing = greeteing;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
	
	
}
