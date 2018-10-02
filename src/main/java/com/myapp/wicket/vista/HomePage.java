/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.vista;           

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
public class HomePage extends TemplatePage{
    private static final long serialVersionUID = -7465108755276912649L;
    
    public HomePage(){
        super();        
        replace(new Label(CONTENT_ID, "Hello World!"));
        add(new Label("msg", new Model<String>(UserSession.getInstance().getuSerModel().getName())));
    }
}
