package com.microsoft.egh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class ClientDemographic {
    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private String fullName;

    private Date originalRegistrationDate;
    private Date updateRegistrationDate;
    private Date lastIntakeDate;
    private boolean registrationComplete;
    private String phoneNumber;
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

    public Long getId() {
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
