package my.boot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponseSorting {

	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("responseComparator")
	private Comparator errorComparator;

	public void sortErrorResponse(List<ErrorResponse> errorResponseList) {
		Collections.sort(errorResponseList, errorComparator);
	}
	
}
