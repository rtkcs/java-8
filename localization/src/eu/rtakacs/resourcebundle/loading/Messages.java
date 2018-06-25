package eu.rtakacs.resourcebundle.loading;

import java.util.ListResourceBundle;

public class Messages extends ListResourceBundle {

	@Override
	protected Object[][] getContents() {
		return new Object[][] {{"hello", "Hello from list     resource bundle Messages"}};
	}

}
