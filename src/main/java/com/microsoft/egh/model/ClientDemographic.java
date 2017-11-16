package com.microsoft.egh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Clientdemographic")
public class ClientDemographic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "clientid")
    private Integer id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "originalregistrationdate")
    private Date originalRegistrationDate;
    @Column(name = "updateregistrationdate")
    private Date updateRegistrationDate;
    @Column(name = "lastintakedate")
    private Date lastIntakeDate;
    @Column(name = "registrationcomplete")
    private boolean registrationComplete;
    @Column(name = "phonenumber")
    private String phoneNumber;
    @Column(name = "emailaddress")
    private String emailAddress;
    private Date dob;
//    YearOfBirth varchar (255),
    private String gender;
//    PronounOfChoiceID int,
//    HispanicOrLatinoEthnicity bit,
//    RaceID int,
//    USCitizen bit,
//    ServedInArmedForces bit,
//    PhysicalDisability bit,
//    MentalDisability bit,
//    MonthlyIncome decimal (19,4),
//    IncomeSourceID int,
//    NCBFoodStamps bit,
//    NCBMedicaid bit,
//    NCBMedicare bit,
//    NCBHen bit,
//    Homeless bit,
//    SleepingWhereID int,
//    HowLongHomelessID int,
//    HowManyTimesHomelessID int,
//    LastHaveHome varchar (255),
//    VictimOfDV bit,
//    CurrentlyAtRisk bit,
//    EducationLevelID int,
//    GreaterThanDropOut varchar (255),
//    CurrentlyAttendingSchool bit,
//    CurrentID bit,
//    IDState varchar (255),
//    EmergencyContactName varchar (255),
//    EmergencyContactPhone varchar (16),
//    SleepingAgreementOnFile bit,
//    ShowerAgreementOnFile bit,
//    MailAgreementOnFile bit,
//    AnimalAgreementOnFile bit,
//    CEAAssessmentAtEGH date,
//    CEAAssessmentPerClient bit

    protected ClientDemographic() {
    }

    public ClientDemographic(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getOriginalRegistrationDate() {
        return originalRegistrationDate;
    }

    public void setOriginalRegistrationDate(Date originalRegistrationDate) {
        this.originalRegistrationDate = originalRegistrationDate;
    }

    public Date getUpdateRegistrationDate() {
        return updateRegistrationDate;
    }

    public void setUpdateRegistrationDate(Date updateRegistrationDate) {
        this.updateRegistrationDate = updateRegistrationDate;
    }

    public Date getLastIntakeDate() {
        return lastIntakeDate;
    }

    public void setLastIntakeDate(Date lastIntakeDate) {
        this.lastIntakeDate = lastIntakeDate;
    }

    public boolean isRegistrationComplete() {
        return registrationComplete;
    }

    public void setRegistrationComplete(boolean registrationComplete) {
        this.registrationComplete = registrationComplete;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return String.format("ClientDemographic[id=%d, firstName='%s', lastName='%s']", id,
                firstName, lastName);
    }
}
