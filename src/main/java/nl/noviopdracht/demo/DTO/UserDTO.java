package nl.noviopdracht.demo.DTO;

import javax.validation.constraints.NotBlank;


import java.sql.Date;

public class UserDTO {

    private Long id;

    @NotBlank(message = "You need to fill in a name")
    private String name;

    @NotBlank(message = "You need to fill in a email")
    private String email;

    @NotBlank(message = "You need to fill in a password")
    private String password;

    private String note;

    private Date birthday;

    private String cellnumber;

    private String profession;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", note='" + note + '\'' +
                ", birthday=" + birthday +
                ", profession='" + profession + '\'' +
                '}';
    }

    public UserDTO(Long id, String name, String email, String password, String note, Date birthday, String cellnumber, String profession) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.note = note;
        this.birthday = birthday;
        this.cellnumber = cellnumber;
        this.profession = profession;


    }


    public UserDTO(String name, String email, String password, String note, Date birthday, String cellnumber, String profession) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.note = note;
        this.birthday = birthday;
        this.cellnumber = cellnumber;
        this.profession = profession;
    }

    public UserDTO() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCellnumber() {
        return cellnumber;
    }

    public void setCellnumber(String cellnumber) {
        this.cellnumber = cellnumber;
    }
}