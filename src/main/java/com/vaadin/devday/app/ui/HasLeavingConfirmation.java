package com.vaadin.devday.app.ui;

import java.util.Optional;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.function.SerializableConsumer;

public interface HasLeavingConfirmation {

	@FunctionalInterface
	public interface DecidedToLeave extends SerializableConsumer<Boolean> {

	}

	boolean isLeavingConfirmationRequired();

	default void handleLeaveAction(DecidedToLeave navigate) {
		Dialog dialog = new Dialog();
		Label question = new Label("Are you sure you want to leave?");

		Button go = new Button("Leave", e -> {
			navigate.accept(true);
			dialog.close();
		});
		go.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
		Button stay = new Button("Stay", e -> {
			navigate.accept(false);
			dialog.close();
		});

		HorizontalLayout buttons = new HorizontalLayout(go, stay);
		buttons.setJustifyContentMode(JustifyContentMode.CENTER);
		dialog.add(question, buttons);
		dialog.open();
	}

	static Optional<HasLeavingConfirmation> of(Object target) {
		if (target instanceof HasLeavingConfirmation) {
			return Optional.of(HasLeavingConfirmation.class.cast(target));
		}

		return Optional.empty();
	}

}
