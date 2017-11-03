package com.microsoft.egh.ui;

import com.microsoft.egh.ui.navigation.NavigationManager;
import com.vaadin.annotations.Title;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.Button;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

//@Theme("apptheme")
@SpringUI
//@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
@Title("Elizabeth Gregory Home")
public class AppUI extends UI {
    final TextField filter;

    private final Button addNewBtn;
    private final SpringViewProvider viewProvider;

    private final NavigationManager navigationManager;

    private final MainView mainView;

//	@Autowired
//	public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
//		this.viewProvider = viewProvider;
//		this.navigationManager = navigationManager;
//		this.mainView = mainView;
//	}

    @Autowired
    public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
        this.filter = new TextField();
        this.addNewBtn = new Button("New client fact", FontAwesome.PLUS);
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
            LoggerFactory.getLogger(getClass()).error("Error during request", t);
        });

        setContent(mainView);

		navigationManager.navigateToDefaultView();
    }
}
