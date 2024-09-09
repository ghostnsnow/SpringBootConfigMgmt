package com.chintanu01.service_a.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ServiceAController {

    @Value("${gitrepo.testprop}")
    private String testprop;

    @Value("${chintanu.secretpwd}")
    private String secretpwd;

    public String getTestprop() {
        return testprop;
    }

    public void setTestprop(String testprop) {
        this.testprop = testprop;
    }

    public String getSecretpwd() {
        return secretpwd;
    }

    public void setSecretpwd(String secretpwd) {
        this.secretpwd = secretpwd;
    }

    @GetMapping("/getgitrepo")
    public String getGitRepoProp() {

        System.out.println("Git Repo - " + getTestprop());

        return getTestprop();
    }

    @GetMapping("/getsecretpwd")
    public String getSecretPwd() {

        System.out.println("Secret Pwd - " + getSecretpwd());

        return getSecretpwd();
    }
}
