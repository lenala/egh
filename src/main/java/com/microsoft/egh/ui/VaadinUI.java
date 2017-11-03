///**
// * Copyright (c) Microsoft Corporation. All rights reserved.
// * Licensed under the MIT License. See License.txt in the project root for
// * license information.
// */
//package com.microsoft.egh.ui;
//
//import com.microsoft.egh.model.ClientFact;
//import com.microsoft.egh.model.ClientFactRepositoryDemo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.StringUtils;
//
//import com.vaadin.server.FontAwesome;
//import com.vaadin.server.VaadinRequest;
//import com.vaadin.shared.ui.ValueChangeMode;
//import com.vaadin.spring.annotation.SpringUI;
//import com.vaadin.ui.Button;
//import com.vaadin.ui.Grid;
//import com.vaadin.ui.HorizontalLayout;
//import com.vaadin.ui.TextField;
//import com.vaadin.ui.UI;
//import com.vaadin.ui.VerticalLayout;
//
//@SpringUI
//public class VaadinUI extends UI {
//
//    private final ClientFactRepositoryDemo repo;
//
//    private final ClientFactEditor editor;
//
//    final Grid<ClientFact> grid;
//
//    final TextField filter;
//
//    private final Button addNewBtn;
//
//    @Autowired
//    public VaadinUI(ClientFactRepositoryDemo repo, ClientFactEditor editor) {
//        this.repo = repo;
//        this.editor = editor;
//        this.grid = new Grid<>(ClientFact.class);
//        this.filter = new TextField();
//        this.addNewBtn = new Button("New client fact", FontAwesome.PLUS);
//    }
//
//    @Override
//    protected void init(VaadinRequest request) {
//        // build layout
//        HorizontalLayout actions = new HorizontalLayout(filter, addNewBtn);
//        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
//        setContent(mainLayout);
//
//        grid.setHeight(300, Unit.PIXELS);
//        grid.setColumns("id", "firstName", "lastName");
//
//        filter.setPlaceholder("Filter by last name");
//
//        // Hook logic to components
//
//        // Replace listing with filtered content when user changes filter
//        filter.setValueChangeMode(ValueChangeMode.LAZY);
//        filter.addValueChangeListener(e -> listClientFacts(e.getValue()));
//
//        // Connect selected ClientFact to editor or hide if none is selected
//        grid.asSingleSelect().addValueChangeListener(e -> {
//            editor.editCustomer(e.getValue());
//        });
//
//        // Instantiate and edit new ClientFact the new button is clicked
//        addNewBtn.addClickListener(e -> editor.editCustomer(new ClientFact("", "")));
//
//        // Listen changes made by the editor, refresh data from backend
//        editor.setChangeHandler(() -> {
//            editor.setVisible(false);
//            listClientFacts(filter.getValue());
//        });
//
//        // Initialize listing
//        listClientFacts(null);
//    }
//
//    // tag::listClientFacts[]
//    void listClientFacts(String filterText) {
//        if (StringUtils.isEmpty(filterText)) {
//            grid.setItems(repo.findAll());
//        }
//        else {
//            grid.setItems(repo.findByLastNameStartsWithIgnoreCase(filterText));
//        }
//    }
//    // end::listClientFacts[]
//
//}
