/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 */
package com.microsoft.egh.ui.signinsheet;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SpringView
public class SignInSheetViewImpl extends VerticalLayout implements View {
    protected TextField search;
    protected Button add;
    protected Grid list;
    protected TextField firstName;
    protected TextField lastName;
    protected TextField jobTitle;
    protected TextField phoneNumber;
    protected TextField email;
    protected TextField company;
    protected TextField url;
    protected TextArea notes;
    protected Button update;
    protected Button cancel;
    protected Button delete;
}
