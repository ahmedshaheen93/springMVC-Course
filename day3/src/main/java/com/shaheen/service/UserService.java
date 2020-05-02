package com.shaheen.service;

import com.shaheen.model.User;
import net.sf.jasperreports.engine.*;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);

    JasperPrint ReportAllUsers();
}
