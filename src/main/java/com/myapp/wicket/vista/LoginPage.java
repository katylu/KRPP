/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.wicket.vista;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Niranjan Velagapudi
 *
 */
public class LoginPage extends WebPage {

    /**
     *
     */
   private static final long serialVersionUID = 5946349607750478191L;
  
    public LoginPage() {

        final USerModel userModel = new USerModel();

        Form<Object> form = new Form<Object>("form");

        form.add(new TextField<String>("username", new PropertyModel<String>(userModel, "name")));

        form.add(new PasswordTextField("pass", new PropertyModel<String>(userModel, "pass")));

        form.add(new Button("submit") {
            private static final long serialVersionUID = -8676092495300239679L;

            @Override
            public void onSubmit() {
                super.onSubmit();
        
              /* try{
                   
               
                
                /*if (userModel.getName().equalsIgnoreCase("admin") && userModel.getPass().equals("admin")) {

                    UserSession.getInstance().setuSerModel(userModel);
                    setResponsePage(HomePage.class);
                } else {
                    //System.out.println("Invalid username or password");
                    
                    error("Nombre de Usuario o Contraseña INCORRECTA");
                    
                
            }
                }catch(NullPointerException e){
                    error("Hola");
                }*/
              
              if("admin".equals(userModel.getName()) && userModel.getPass().equals("admin")){
                    UserSession.getInstance().setuSerModel(userModel);
                    setResponsePage(HomePage.class);
              }else{
                    error("Wrong username or password");
              }
            }
            
            
        });
        
        
        

        add(form);
        add(new FeedbackPanel("feedbackPanel"));
    }
}

/*import org.apache.wicket.MarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.panel.FeedbackPanel;

import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;

public class LoginPage {
    private static final long serialVersionUID = 1L;
    private Label sessionType;
    private String password;
    private String username;
    
    public LoginPage(final PageParameters parameters) {
        StatelessForm form = new StatelessForm("form"){
            @Override
            protected void onSubmit() {
                if("user".equals(username) && username.equals(password))
                    info("Username and password are correct!");
                else
                    error("Wrong username or password");
            }
        };
        
        form.add(new PasswordTextField("password"));
        form.add(new TextField("username"));        
        
        //add(form.setDefaultModel(new CompoundPropertyModel(this)));
        
        //add(sessionType = new Label("sessionType", Model.of("")));
        //add(new FeedbackPanel("feedbackPanel"));
    }
*/

