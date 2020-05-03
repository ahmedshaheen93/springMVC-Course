package com.shaheen.controller;

import com.shaheen.model.User;
import com.shaheen.service.UserService;
import com.shaheen.utils.ReportUtility;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UserService userService;
    @Autowired
    private ReportUtility reportUtility;

    @GetMapping("/users.htm")
    public String getUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/register.htm")
    public String register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/register.htm")
    public String register(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult);
            return "registration";
        }
        userService.save(user);
        return "redirect:/users/users.htm";
    }

    @GetMapping("/userReport.htm")
    public void userReport(HttpServletResponse response) {
        JasperPrint jasperPrint = userService.ReportAllUsers();
        System.out.println(jasperPrint);
        HtmlExporter htmlExporter = new HtmlExporter();
        htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        try {
            htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
            htmlExporter.exportReport();
        } catch (IOException | JRException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/printUserReport.htm")
    public ResponseEntity<byte[]> printUserReport(HttpServletResponse response) {
        JasperPrint jasperPrint = userService.ReportAllUsers();
        System.out.println(jasperPrint);
        return new ResponseEntity<>(reportUtility.generatePdfByteArray(jasperPrint),
                setHttpHeaders("userReport", "pdf", MediaType.APPLICATION_PDF), HttpStatus.OK);

    }

    @GetMapping("excelFile.htm")
    public ResponseEntity<byte[]> excelUserReport(HttpServletResponse response) {
        JasperPrint jasperPrint = userService.ReportAllUsers();
        System.out.println(jasperPrint);
        return new ResponseEntity<>(reportUtility.generateExcelByteArray(jasperPrint),
                setHttpHeaders("userReport", "xlsx", MediaType.valueOf("application/vnd.ms-excel")), HttpStatus.OK);
    }


    private HttpHeaders setHttpHeaders(String name, String fileType, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename=" + name + "." + fileType);
        headers.setContentType(mediaType);
        return headers;
    }
}
