/*
 * WicketExamplePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */
 
package com.myapp.wicket;           

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;

public class TemplatePage extends WebPage {
    private static final long serialVersionUID = 5218374612129395403L;
    public static final String CONTENT_ID = "contentComponent";
    private Component headerPanel;
    private Component menuPanel;
    private Component footerPanel;
    public TemplatePage(){
        add(headerPanel = new HeaderPanel("headerPanel"));
        add(footerPanel = new FooterPanel("footerPanel"));
        add(new Label(CONTENT_ID, "Put your content here"));
    }
    
    public Component getHeaderPanel() {
        return headerPanel;
    }
    public Component getMenuPanel() {
        return menuPanel;
    }
    public Component getFooterPanel() {
        return footerPanel;
    }
}