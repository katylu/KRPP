/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.vehiculos;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.entities.Modelo;
import com.parqueo.krpp.entities.Vehiculo;
import com.parqueo.krpp.repository.ModeloRepository;
import com.parqueo.krpp.repository.VehiculoRepository;
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

    public Listar() {
        super();

        //agregamos el enlace a la pagina de creacion
        add(new BookmarkablePageLink<Crear>("Vehiculo.Crear" , Crear.class));

        //obtenemos los vehiculos de la bd
        List<Vehiculo> vehiculos = VehiculoRepository.getInstance().getAll();

        add(new ListView<Vehiculo>("vehiculos", vehiculos) {
            @Override
            protected void populateItem(ListItem<Vehiculo> item) {
                Vehiculo m = item.getModelObject();
                //columnas del listado
                item.add(new Label("idVehiculo", new PropertyModel(item.getModel(), "idVehiculo")));
                item.add(new Label("chapa", new PropertyModel(item.getModel(), "chapa")));
                item.add(new Label("color", new PropertyModel(item.getModel(), "color")));
                item.add(new Label("anho", new PropertyModel(item.getModel(), "anho")));
                item.add(new Label("modelo", new PropertyModel(item.getModel(), "modelo.nombreModelo")));
                item.add(new Label("marca", new PropertyModel(item.getModel(), "modelo.marca.nombreMarca")));
                item.add(new Label("empleado", new PropertyModel(item.getModel(), "empleado.nombreCompleto")));

                //link para editar
                PageParameters pageParameters = new PageParameters();
                pageParameters.add("vehiculo", m.getIdVehiculo());
                item.add(new BookmarkablePageLink<Void>("editLink",
                        Editar.class, pageParameters));

                //link para eliminar
                Link<Integer> deleteLink = new Link<Integer>("deleteLink",
                        new Model<Integer>(m.getIdVehiculo())) {
                    @Override
                    public void onClick() {

                        VehiculoRepository.getInstance().deleteById(getModelObject());

                    }
                };
                deleteLink.add(new AttributeModifier("onclick",
                        "return confirm('Esta seguro de eliminar el vehiculo "
                                + m.getChapa().replace("\"", "\\\"")+ "?');"));
                item.add(deleteLink);
            }

        });


    }
}
