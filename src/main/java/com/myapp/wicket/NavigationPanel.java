package com.myapp.wicket;

import com.myapp.wicket.marcas.Listar;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
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

        add(new BookmarkablePageLink<com.myapp.wicket.marcas.Listar>("Marca.Listar" ,com.myapp.wicket.marcas.Listar.class));
        add(new BookmarkablePageLink<com.myapp.wicket.marcas.Crear>("Marca.Crear" ,com.myapp.wicket.marcas.Crear.class));

    }
}
