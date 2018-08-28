package com.gunjan;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;

public class PhoneEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (text.length() < 12) {
			throw new IllegalArgumentException(
					"Phone Number Must be of length 12");
		}
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setCountryCode(text.substring(0, 2));
		phoneNumber.setPhNumber(text.substring(2, text.length()));
		setValue(phoneNumber);
	}
}

class PhoneEditorRegistrar implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry registry) {
		registry.registerCustomEditor(PhoneNumber.class, new PhoneEditor());
	}
}
