package com.myapp.wicket;

import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.panel.Panel;

public class NavigationPanel extends Panel {
    public NavigationPanel(String id) {
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
