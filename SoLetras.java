package com.esio.imposto;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class SoLetras extends PlainDocument{
	
	public void insertString(int arg0, String str, AttributeSet arg2) throws BadLocationException {
		
		super.insertString(arg0, str.replaceAll("[^a-z | ^A-Z]", ""), arg2);
	}
	public void replace(int arg0, String str, AttributeSet arg2) throws BadLocationException {
		
		super.insertString(arg0, str.replaceAll("[^a-z | ^A-Z]", ""), arg2);
	}
	

}
