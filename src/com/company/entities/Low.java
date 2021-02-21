package com.company.entities;

public class Low extends Top{
    private int id;
    private String name;
    private String surname;
    private boolean gender;
    private String position;

    /**
     * Default constructor
     */
    public Low() {

    }

    /**
     * Overloaded constructor with default parameter values
     * @param name
     * @param surname
     * @param gender
     * @param position
     */
    public Low(String name, String surname, boolean gender, String position) {
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPosition(position);
    }

    /**
     * Overloaded constructor with 5 default parameter values
     * @param id
     * @param name
     * @param surname
     * @param gender
     * @param position
     */
    public Low(int id, String name, String surname, boolean gender, String position) {
        setId(id);
        setName(name);
        setSurname(surname);
        setGender(gender);
        setPosition(position);
    }

    /**
     * Method, which returns the low level employee's id
     * @return integer value
     */
    public int getId() {
        return id;
    }

    /**
     * Method, which changes the low level employee's id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Method, which returns the low level employee's name
     * @return String value
     */
    public String getName() {
        return name;
    }

    /**
     * Method, which changes the low level employee's name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method, which returns the low level employee's surname
     * @return String value
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Method, which changes the low level employee's surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Method, which returns the low level employee's gender
     * @return boolean value
     */
    public boolean getGender() {
        return gender;
    }

    /**
     * Method, which changes the low level employee's gender
     * @param gender
     */
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    /**
     * Method, which returns the low level employee's position
     * @return String value
     */
    public String getPosition() {
        return position;
    }

    /**
     * Method, which changes the low level employee's position
     * @param position
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Overridden method toString from cosmic superclass Top
     * @return String value
     */
    @Override
    public String toString() {
        return "Low level employees {" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + (gender ? "Male" : "Female") + '\'' +
                ",position=" + position + '}';
    }
}
