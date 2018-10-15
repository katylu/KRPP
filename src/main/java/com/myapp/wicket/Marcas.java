/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket;

import com.parqueo.krpp.api.MarcaApi;
import com.parqueo.krpp.entities.Marca;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Marcas extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final List<IModel<Marca>> listado = new ArrayList<IModel<Marca>>();

    public Marcas() {
        super();

        //obtenemos las marcas de la bd
        List<Marca> marcas = MarcaApi.getInstance().getAll();


        add(new ListView<Marca>("marcas", marcas) {
            @Override
            protected void populateItem(ListItem<Marca> item) {
                item.add(new Label("nombreMarca", new PropertyModel(item.getModel(), "nombreMarca")));
                item.add(new Label("idMarca", new PropertyModel(item.getModel(), "idMarca")));

            }

        });
    }
}
