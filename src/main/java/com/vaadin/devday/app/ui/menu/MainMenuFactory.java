package com.vaadin.devday.app.ui.menu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.RouteConfiguration;
import com.vaadin.flow.spring.annotation.UIScope;

@Configuration
class MainMenuFactory {

	@Bean
	@UIScope
	protected MainMenu appMainMenu() {
		MainMenu appMenu = new MainMenuBean();

		RouteConfiguration.forApplicationScope().getAvailableRoutes().forEach(route -> {
			ShowInMenu menuDefinition = route.getNavigationTarget().getAnnotation(ShowInMenu.class);
			if (menuDefinition != null) {
				appMenu.addMenuItem(menuDefinition.name(), menuDefinition.icon(),
						() -> UI.getCurrent().navigate(route.getNavigationTarget()));
			}
		});

		return appMenu;
	}
}
