package com.dianwuyou.service;

import com.dianwuyou.model.User;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hebowei on 16/6/10.
 */
public interface UserService {
    int ERR_NO_SUCH_USER = -1;
    int ERR_WRONG_PASSWORD = -2;
    int ERR_SALT_UNDEFINED = -3;
    int ERR_TOKEN_UNSET = -4;
    int ERR_TOKEN_INVALID = -5;
    int ERR_COOKIE_INVALID = -6;
    int ERR_TOKEN_EXPIRED = -7;
    int SUCC_LOGIN = 0;
    int NOT_LOGIN = -10;

    User findById(int id);
    User findByEmail(String email);
    void saveUser(User user);
    void updateUser(User user);
    boolean isUniqueEmail(String email, Integer id);
    void setSaltPassword(User user);
    int verify(String email, String passwordInMD5);
    int verify(int uid, String token);
    int maintainLoginState(HttpServletRequest request, HttpServletResponse response) throws IOException;
    void loginStateParse(Model model, Integer uid);
    User findByInviteCode(String inviteCode);
    User getFromSession(HttpServletRequest request);
}
