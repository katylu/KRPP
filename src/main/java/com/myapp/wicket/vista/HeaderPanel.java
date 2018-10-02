/*
 * HeaderPanel.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */
 
package com.myapp.wicket.vista;           


import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;
public class HeaderPanel extends Panel {
    private static final long serialVersionUID = 5218374612129395403L;
    public HeaderPanel(String id) {
        super(id);  
        add(new Link<String>("signOut"){
            
            private static final long serialVersionUID=7691766648121983700L;
            @Override
            public void onClick(){
                UserSession.getInstance().invalidate();
                setResponsePage(LoginPage.class);
            }
        });
    }
}
