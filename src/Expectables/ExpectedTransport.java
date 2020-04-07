package Expectables;

import Errors.WrongTransportError;
import Input.Transport;

public class ExpectedTransport implements Expectable {
	@Override
	public void checkValueValidnes(String valueRaw) {
		try {
			Transport.valueOf(valueRaw);
		} catch (IllegalArgumentException exception) {
			throw new WrongTransportError();
		}
	}
}
