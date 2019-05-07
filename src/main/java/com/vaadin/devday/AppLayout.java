package com.vaadin.devday;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.devday.app.ui.MainContentArea;
import com.vaadin.devday.app.ui.menu.MainMenu;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.server.PWA;

@PWA(name = "Project Base for Vaadin Flow with Spring", shortName = "Project Base", enableInstallPrompt = false)
public class AppLayout extends HorizontalLayout implements RouterLayout {

	@Autowired
	private MainMenu mainMenu;

	@Autowired
	private MainContentArea contentArea;

	@PostConstruct
	protected void initialize() {
		setSizeFull();
		add(mainMenu.asComponent(), contentArea.asComponent());
		expand(contentArea.asComponent());
	}

	@Override
	public void showRouterLayoutContent(HasElement content) {
		contentArea.setContent((Component) content);
	}
}
