package com.microsoft.egh.ui.personalInfo;

import com.microsoft.egh.model.ClientDemographic;
import com.microsoft.egh.model.ClientDemographicRepository;
import com.microsoft.egh.model.ClientFact;
import com.microsoft.egh.model.ClientFactRepository;
import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.server.FontAwesome;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class ClientDemographicEditor extends VerticalLayout {

	private final ClientDemographicRepository repository;

	/**
	 * The currently edited clientDemographic
	 */
	private ClientDemographic clientDemographic;

	/* Fields to edit properties in ClientFact entity */
	private TextField firstName = new TextField("First name");
	private TextField lastName = new TextField("Last name");
	private TextField fullName = new TextField("Full name");
	private CheckBox registrationComplete = new CheckBox("Registration Complete");
	private TextField phoneNumber = new TextField("Phone number");
	private TextField emailAddress = new TextField("Email");
	private ComboBox<String> gender = new ComboBox<>("Gender");

	/* Action buttons */
	private Button save = new Button("Save", FontAwesome.SAVE);
	private Button cancel = new Button("Cancel");
	private Button delete = new Button("Delete", FontAwesome.TRASH_O);
	private CssLayout actions = new CssLayout(save, cancel, delete);

	Binder<ClientDemographic> binder = new Binder<>(ClientDemographic.class);

	@Autowired
	public ClientDemographicEditor(ClientDemographicRepository repository) {
		this.repository = repository;

		addComponents(firstName, lastName, fullName, registrationComplete, phoneNumber, emailAddress, gender, actions);

		gender.setItems("Female", "Male", "Transgender Male to Female", "Transgender Female to Male", "Gender Fluid");

		// bind using naming convention
		binder.bindInstanceFields(this);

		// Configure and style components
		setSpacing(true);
		actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

		// wire action buttons to save, delete and reset
		save.addClickListener(e -> repository.save(clientDemographic));
		delete.addClickListener(e -> repository.delete(clientDemographic));
		cancel.addClickListener(e -> edit(clientDemographic));
		setVisible(false);
	}

	public interface ChangeHandler {

		void onChange();
	}

	public final void edit(ClientDemographic c) {
		if (c == null) {
			setVisible(false);
			return;
		}
		final boolean persisted = c.getId() != null;
		if (persisted) {
			// Find fresh entity for editing
			clientDemographic = repository.findOne(c.getId());
		}
		else {
			clientDemographic = c;
		}
		cancel.setVisible(persisted);

		// Bind clientDemographic properties to similarly named fields
		// Could also use annotation or "manual binding" or programmatically
		// moving values from fields to entities before saving
		binder.setBean(clientDemographic);

		setVisible(true);

		// A hack to ensure the whole form is visible
		save.focus();
		// Select all text in firstName field automatically
		firstName.selectAll();
	}

	public void setChangeHandler(ChangeHandler h) {
		// ChangeHandler is notified when either save or delete
		// is clicked
		save.addClickListener(e -> h.onChange());
		delete.addClickListener(e -> h.onChange());
	}

}
