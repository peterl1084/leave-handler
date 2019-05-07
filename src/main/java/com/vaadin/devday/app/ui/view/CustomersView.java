package com.vaadin.devday.app.ui.view;

import com.vaadin.devday.AppLayout;
import com.vaadin.devday.app.ui.HasLeavingConfirmation;
import com.vaadin.devday.app.ui.menu.ShowInMenu;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@ShowInMenu(name = "Customers", icon = VaadinIcon.USER)
@Route(value = "customers", layout = AppLayout.class)
public class CustomersView extends VerticalLayout implements HasLeavingConfirmation {

	public CustomersView() {
		setSizeFull();
		add(new Label("Customers"));
	}

	@Override
	public boolean isLeavingConfirmationRequired() {
		return true;
	}
}
