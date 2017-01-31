package com.yix.springmvc.object;

import java.beans.PropertyEditorSupport;

public class MyPropertyEditorSupport extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		String[] textArray = text.split(",");
		user.setName(textArray[0]);
		user.setAge(Integer.parseInt(textArray[1]));
		this.setValue(user);
	}
	
	public static void main(String[] args) {
		MyPropertyEditorSupport editor = new MyPropertyEditorSupport();
		editor.setAsText("Nemo,6");
		System.out.println(editor.getValue());
	}
}
