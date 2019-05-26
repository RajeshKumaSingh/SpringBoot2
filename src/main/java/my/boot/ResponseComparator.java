package my.boot;

import java.util.Comparator;

import org.springframework.stereotype.Component;

@Component
public class ResponseComparator implements Comparator<ErrorResponse> {

	@Override
	public int compare(ErrorResponse o1, ErrorResponse o2) {
		// TODO Auto-generated method stub
		return -1;
	}

}
