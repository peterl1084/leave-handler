package com.vaadin.devday.app.ui.menu;

import com.vaadin.devday.app.ui.IsComponent;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.server.Command;

public interface MainMenu extends IsComponent {

	void addMenuItem(String name, VaadinIcon icon, Command command);
}
