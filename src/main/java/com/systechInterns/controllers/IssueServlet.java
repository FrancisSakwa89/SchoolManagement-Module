package com.systechInterns.controllers;

import com.systechInterns.Beans.IssueI;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;

public class IssueServlet extends HttpServlet {
    @EJB
    IssueI issueI;
}
