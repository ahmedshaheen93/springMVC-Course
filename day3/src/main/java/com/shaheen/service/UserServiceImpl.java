package com.shaheen.service;

import com.shaheen.model.User;
import com.shaheen.repository.UserRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    @Override
    public JasperPrint ReportAllUsers() {
        List<User> users = findAll();
        InputStream usersReportFile = loadReportFile("users");
        JasperReport jasperReport = compileReport(usersReportFile);
        JRDataSource dataSource = new JRBeanCollectionDataSource(users);
        return fillReport(jasperReport, null, dataSource);
    }

    private JasperPrint fillReport(JasperReport jasperReport,
                                   HashMap<String, Object> parametersMap, JRDataSource dataSource) {
        try {
            return JasperFillManager.fillReport(jasperReport, parametersMap, dataSource);

        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

    private JasperReport compileReport(InputStream inputStream) {
        try {
            return JasperCompileManager.compileReport(inputStream);
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InputStream loadReportFile(String name) {
        return this.getClass().
                getResourceAsStream("/static/reports/" + name + ".jrxml");
    }

}
