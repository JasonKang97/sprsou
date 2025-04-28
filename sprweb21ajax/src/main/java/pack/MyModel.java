package pack;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class MyModel {
	private String name;
	private String[] skills;
}
