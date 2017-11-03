/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.egh.ui.personalInfo;

import com.microsoft.egh.model.ClientDemographic;
import com.microsoft.egh.model.ClientDemographicRepository;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView
public class PersonalInfoView extends VerticalLayout implements View {
    private TextField search = new TextField();
    private Button addNewBtn = new Button("New...", FontAwesome.PLUS);
    private Grid<ClientDemographic> grid = new Grid<>(ClientDemographic.class);

    @Autowired
    private ClientDemographicRepository repo;
    @Autowired
    private ClientDemographicEditor editor;

    @PostConstruct
    public void init() {
        HorizontalLayout actions = new HorizontalLayout(search, addNewBtn);
        addComponents(actions, editor, grid);
        setWidth(100, Unit.PERCENTAGE);
        setComponentAlignment(grid, Alignment.TOP_CENTER);
        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.edit(e.getValue());
        });

        grid.setColumns("id", "firstName", "lastName", "fullName", "originalRegistrationDate", "updateRegistrationDate", "lastIntakeDate", "registrationComplete",
                "phoneNumber", "emailAddress", "dob", "gender");
        grid.setSizeFull();
        search.setPlaceholder("Filter by last name");

        // Hook logic to components

        // Replace listing with filtered content when user changes filter
        search.setValueChangeMode(ValueChangeMode.LAZY);
        search.addValueChangeListener(e -> listClientFacts(e.getValue()));
        addNewBtn.addClickListener(e -> editor.edit(new ClientDemographic("", "")));

        // Listen changes made by the editor, refresh data from backend
        editor.setChangeHandler(() -> {
            editor.setVisible(false);
            listClientFacts(search.getValue());
        });

        // Initialize listing
        listClientFacts(null);
    }

    void listClientFacts(String filterText) {
        if (StringUtils.isEmpty(filterText)) {
            grid.setItems(repo.findAll());
        } else {
            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
        }
    }

}
