package com.vaadin.devday.app.ui;

import org.springframework.context.annotation.Scope;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
@Tag("main-content")
@Scope(scopeName = "prototype")
class MainContentAreaBean extends Div implements MainContentArea {

	private Component currentContent;

	public MainContentAreaBean() {
		setSizeFull();
	}

	@Override
	public void setContent(Component content) {
		if (currentContent != null) {
			remove(currentContent);
		}

		if (content != null) {
			add(content);
		}
	}
}
