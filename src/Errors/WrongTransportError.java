package Errors;

import Input.Transport;

import java.util.Arrays;

public class WrongTransportError extends InputError {
	public WrongTransportError() {
		super("Должно быть одно из значений Transport: " + Arrays.toString(Transport.values()));
	}
}
