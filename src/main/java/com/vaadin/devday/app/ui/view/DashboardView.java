package com.vaadin.devday.app.ui.view;

import com.vaadin.devday.AppLayout;
import com.vaadin.devday.app.ui.menu.ShowInMenu;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@ShowInMenu(name = "Dashboard", icon = VaadinIcon.ROCKET)
@Route(value = "", layout = AppLayout.class)
public class DashboardView extends VerticalLayout {

	public DashboardView() {
		setSizeFull();

		add(new Label("Dashboard"));
	}

}
