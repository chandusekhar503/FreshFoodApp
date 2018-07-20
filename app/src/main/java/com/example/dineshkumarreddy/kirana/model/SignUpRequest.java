package com.example.dineshkumarreddy.kirana.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by dineshkumarreddy on 21/06/18.
 */

public class SignUpRequest implements Serializable {
    private static final long serialVersionUID = 3167898476444088587L;

    @SerializedName("userFirstName")
    private String userFirstName;

    @SerializedName("userLastName")
    private String userLastName;

    @SerializedName("userPassword")
    private String userPassword;

    @SerializedName("userEmail")
    private String userEmail;

    @SerializedName("userMobileNumber")
    private String userMobileNumber;

    @SerializedName("userType")
    private String userType = "Customer";

    @SerializedName("userRoleId")
    private String userRoleId = "5b34ca87284e4529a1ba646c";

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
        this.userRoleId = userRoleId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("SignUpRequest{");
        sb.append("userFirstName='").append(userFirstName).append('\'');
        sb.append(", userLastName='").append(userLastName).append('\'');
        sb.append(", userPassword='").append(userPassword).append('\'');
        sb.append(", userEmail='").append(userEmail).append('\'');
        sb.append(", userMobileNumber='").append(userMobileNumber).append('\'');
        sb.append(", userType='").append(userType).append('\'');
        sb.append(", userRoleId='").append(userRoleId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
