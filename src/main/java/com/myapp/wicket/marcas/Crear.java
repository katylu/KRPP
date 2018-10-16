/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.marcas;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.api.MarcaApi;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.modelo.MarcasModel;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class Crear extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final static Logger logger = Logger.getLogger(com.myapp.wicket.LoginPage.class);
    public Crear(){

        final MarcasModel marcasModel = new MarcasModel();

        Form<Object> form = new Form<Object>("form");

        form.add(new TextField<String>("nombreMarca", new PropertyModel<String>(marcasModel, "nombreMarca")));


        form.add(new Button("submit") {
            private static final long serialVersionUID = -8676092495300239679L;

            @Override
            public void onSubmit() {
                //guardamos la marca
                Marca marca = new Marca(marcasModel.getNombreMarca());

                MarcaApi.getInstance().save(marca);
                setResponsePage(Listar.class);
            }
        });

        add(form);
    }

}
