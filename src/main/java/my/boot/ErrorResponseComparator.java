package my.boot;

import java.util.Comparator;

import org.springframework.stereotype.Component;

@Component
public class ErrorResponseComparator implements Comparator<ErrorResponse> {

	@Override
	public int compare(ErrorResponse arg0, ErrorResponse arg1) {
		return 1;
	}

}
