package com.vaadin.devday.app.ui;

import java.util.List;
import java.util.Optional;

import com.vaadin.flow.component.HasElement;
import com.vaadin.flow.router.BeforeLeaveEvent;
import com.vaadin.flow.router.BeforeLeaveEvent.ContinueNavigationAction;
import com.vaadin.flow.router.BeforeLeaveListener;
import com.vaadin.flow.spring.annotation.SpringComponent;

@SpringComponent
public class NavigationConfirmationHandlerBean implements BeforeLeaveListener {

	@Override
	public void beforeLeave(BeforeLeaveEvent event) {
		getConfirmee(event).ifPresent(view -> {
			if (view.isLeavingConfirmationRequired()) {
				ContinueNavigationAction continueAction = event.postpone();
				view.handleLeaveAction(left -> {
					if (left) {
						continueAction.proceed();
					}
				});
			}
		});
	}

	private Optional<HasLeavingConfirmation> getConfirmee(BeforeLeaveEvent event) {
		List<HasElement> targetChain = event.getUI().getInternals().getActiveRouterTargetsChain();
		if (!targetChain.isEmpty()) {
			return HasLeavingConfirmation.of(targetChain.iterator().next());
		}

		return Optional.empty();
	}
}
