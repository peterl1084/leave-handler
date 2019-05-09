package com.vaadin.devday.type;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.DependencyDescriptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.ResolvableType;

import com.vaadin.flow.component.grid.Grid;

@Configuration
public class GridConfigurator {

	@Bean
	@Scope(scopeName = BeanDefinition.SCOPE_PROTOTYPE)
	protected <ITEM> Grid<ITEM> grid(DependencyDescriptor dd) {

		ResolvableType resolvableType = dd.getResolvableType();
		ResolvableType genericType = resolvableType.getGeneric();
		Class<?> itemType = genericType.resolve();

		return configureGrid(itemType);
	}

	private <ITEM> Grid<ITEM> configureGrid(Class<?> itemType) {
		Grid<ITEM> grid = new Grid<>();
		// find configuration by type (itemType)
		// build data provider by type (itemType)

		return grid;
	}
}
