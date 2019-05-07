package com.vaadin.devday;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.flow.router.BeforeLeaveListener;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class AppInitListener implements VaadinServiceInitListener {

	@Autowired
	private BeforeLeaveListener navigationConfirmation;

	@Override
	public void serviceInit(ServiceInitEvent event) {
		event.getSource().addUIInitListener(uiInit -> uiInit.getUI().addBeforeLeaveListener(navigationConfirmation));
	}
}
