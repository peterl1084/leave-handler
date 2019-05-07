package com.vaadin.devday.app.ui.menu;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.Command;

public class MainMenuBean extends VerticalLayout implements MainMenu {

	public MainMenuBean() {
		setWidth("300px");
	}

	@Override
	public void addMenuItem(String name, VaadinIcon icon, Command command) {
		Div menuItem = new Div();
		menuItem.setText(name);
		menuItem.add(new Icon(icon));
		menuItem.addClickListener(event -> command.execute());
		add(menuItem);

		setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
	}
}
