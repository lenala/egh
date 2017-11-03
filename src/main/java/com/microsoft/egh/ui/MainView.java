package com.microsoft.egh.ui;

//import com.kiroule.vaadin.demo.ui.view.admin.product.ProductAdminView;
//import com.kiroule.vaadin.demo.ui.view.admin.user.UserAdminView;
//import com.kiroule.vaadin.demo.ui.view.dashboard.DashboardView;
//import com.kiroule.vaadin.demo.ui.view.storefront.StorefrontView;
import com.microsoft.egh.ui.navigation.NavigationManager;
//import com.microsoft.egh.ui.personalInfo.PersonalInfoViewImpl;
//import com.microsoft.egh.ui.personaldetails.PersonalDetailsView;
//import com.microsoft.egh.ui.personaldetails.PersonalDetailsViewImpl;
//import com.microsoft.egh.ui.signinsheet.SignInSheetView;
//import com.microsoft.egh.ui.signinsheet.SignInSheetViewImpl;
import com.microsoft.egh.ui.personalInfo.PersonalInfoView;
import com.microsoft.egh.ui.personaldetails.PersonalDetailsViewImpl;
import com.microsoft.egh.ui.signinsheet.SignInSheetViewImpl;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.navigator.ViewLeaveAction;
//import com.vaadin.spring.access.SecuredViewAccessControl;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@SpringViewDisplay
@UIScope
public class MainView extends HorizontalLayout implements ViewDisplay {

	private final Map<Class<? extends View>, Button> navigationButtons = new HashMap<>();
	private final NavigationManager navigationManager;
//	private final SecuredViewAccessControl viewAccessControl;

	//    protected Label activeViewName;
//    protected Button menuButton;
//    protected CssLayout menu;
    protected Button personalInfo = new Button("Personal Info");
    protected Button personalDetails = new Button("Personal Details");
    protected Button signInSheet = new Button("Sign In Sheet");
//    protected Button logout;
    protected VerticalLayout content = new VerticalLayout();


	@Autowired
	public MainView(NavigationManager navigationManager/*, SecuredViewAccessControl viewAccessControl*/) {
		this.navigationManager = navigationManager;
//		this.viewAccessControl = viewAccessControl;
	}

	@PostConstruct
	public void init() {
		setSizeFull();

		CssLayout navBar = new CssLayout();
		navBar.setHeight("100%");
		navBar.addStyleName("valo-menu");
		navBar.addStyleName("left-menu");

		Label logo = new Label("<strong>Elizabeth Gregory Home</strong>", ContentMode.HTML);
		logo.addStyleName("valo-menu-title");
		navBar.addComponent(logo);
		navBar.addComponent(personalInfo);
		navBar.addComponent(personalDetails);
		navBar.addComponent(signInSheet);

		addComponent(navBar);

		content.setSizeFull();

		addComponent(content);
		setExpandRatio(content, 1.0f);

		addButton(personalInfo, PersonalInfoView.class);
//		attachNavigation(dashboard, DashboardView.class);
//		attachNavigation(users, UserAdminView.class);
		addButton(personalDetails, PersonalDetailsViewImpl.class);
		addButton(signInSheet, SignInSheetViewImpl.class);

//		logout.addClickListener(e -> logout());
	}

	private void addButton(Button button, Class<? extends View> view) {
		button.addStyleNames("valo-menu-item", "borderless");
		attachNavigation(button, view);
	}

	/**
	 * Makes clicking the given button navigate to the given view if the user
	 * has access to the view.
	 * <p>
	 * If the user does not have access to the view, hides the button.
	 *
	 * @param navigationButton
	 *            the button to use for navigatio
	 * @param targetView
	 *            the view to navigate to when the user clicks the button
	 */
	private void attachNavigation(Button navigationButton, Class<? extends View> targetView) {
		boolean hasAccessToView = true;//viewAccessControl.isAccessGranted(targetView);
		navigationButton.setVisible(hasAccessToView);

		if (hasAccessToView) {
			navigationButtons.put(targetView, navigationButton);
			navigationButton.addClickListener(e -> navigationManager.navigateTo(targetView));
		}
	}

	@Override
	public void showView(View view) {
		content.removeAllComponents();
		content.addComponent(view.getViewComponent());

		navigationButtons.forEach((viewClass, button) -> button.setStyleName("selected", viewClass == view.getClass()));

		Button menuItem = navigationButtons.get(view.getClass());
		String viewName = "";
		if (menuItem != null) {
			viewName = menuItem.getCaption();
		}
//		activeViewName.setValue(viewName);
	}

	/**
	 * Logs the user out after ensuring the currently open view has no unsaved
	 * changes.
	 */
	public void logout() {
		ViewLeaveAction doLogout = () -> {
			UI ui = getUI();
			ui.getSession().getSession().invalidate();
			ui.getPage().reload();
		};

		navigationManager.runAfterLeaveConfirmation(doLogout);
	}

}
