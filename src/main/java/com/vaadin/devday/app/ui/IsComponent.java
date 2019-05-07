package com.vaadin.devday.app.ui;

import com.vaadin.flow.component.Component;

public interface IsComponent {

	default Component asComponent() {
		return Component.class.cast(this);
	}
}
