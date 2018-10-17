/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.marcas;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.repository.MarcaRepository;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.util.JavascriptEventConfirmation;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import java.util.ArrayList;
import java.util.List;

public class Listar extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final List<IModel<Marca>> listado = new ArrayList<IModel<Marca>>();

    public Listar() {
        super();

        //agregamos el enlace a la pagina de creacion
        add(new BookmarkablePageLink<com.myapp.wicket.marcas.Crear>("Marca.Crear" ,com.myapp.wicket.marcas.Crear.class));

        //obtenemos las marcas de la bd
        List<Marca> marcas = MarcaRepository.getInstance().getAll();

        add(new ListView<Marca>("marcas", marcas) {
            @Override
            protected void populateItem(ListItem<Marca> item) {
                Marca m = item.getModelObject();
                //columnas del listado
                item.add(new Label("nombreMarca", new PropertyModel(item.getModel(), "nombreMarca")));
                item.add(new Label("idMarca", new PropertyModel(item.getModel(), "idMarca")));

                //link para editar
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("marca", m.getIdMarca());
                item.add(new BookmarkablePageLink<Void>("editLink",
                        com.myapp.wicket.marcas.Editar.class, pageParameters));

                //link para eliminar
                Link<Integer> deleteLink = new Link<Integer>("deleteLink",
                        new Model<Integer>(m.getIdMarca())) {
                    @Override
                    public void onClick() {
                        MarcaRepository.getInstance().deleteById(getModelObject());
                    }
                };
                deleteLink.add(new JavascriptEventConfirmation("onclick", "Esta seguro de eliminar la marca "+m.getNombreMarca()+"?"));

                item.add(deleteLink);
            }

        });


    }
}
