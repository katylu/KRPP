/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.marcas;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.api.MarcaApi;
import com.parqueo.krpp.entities.Marca;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class Editar extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final static Logger logger = Logger.getLogger(com.myapp.wicket.LoginPage.class);
    public Editar(final PageParameters params){
        final Long taskId = params.get("marca").toLong();


        final TextField<String> nombreMarcaField = new TextField<String>("nombreMarca", Model.<String>of(""));
        nombreMarcaField.setRequired(true);


        Form form = new Form("form") {
            @Override
            protected void onSubmit() {
                //System.out.print(getModelObject());
                //guardamos la marca
                Marca marca = new Marca(nombreMarcaField.getModelObject());

                MarcaApi.getInstance().save(marca);
                setResponsePage(Listar.class);
            }
        };

        form.add(nombreMarcaField);

        Button submit = new Button("submit");
        form.add(submit);

        add(form);
    }

}
