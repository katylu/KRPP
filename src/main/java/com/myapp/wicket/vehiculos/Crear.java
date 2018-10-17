/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.vehiculos;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.entities.Modelo;
import com.parqueo.krpp.modelo.ModelosModel;
import com.parqueo.krpp.repository.MarcaRepository;
import com.parqueo.krpp.repository.ModeloRepository;
import org.apache.log4j.Logger;
import org.apache.wicket.markup.html.form.*;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;

import java.util.ArrayList;
import java.util.List;

public class Crear extends TemplatePage {
    private static final long serialVersionUID = -7465108755276912649L;
    final static Logger logger = Logger.getLogger(com.myapp.wicket.LoginPage.class);
    public Crear(){

        final ModelosModel modelosModel = new ModelosModel();

        Form<Object> form = new Form<Object>("form");

        form.add(new TextField<String>("nombreModelo", new PropertyModel<String>(modelosModel, "nombreModelo")));

        DropDownChoice ddc = new DropDownChoice("marcas",
                new PropertyModel(modelosModel, "marca"),
                new Model(getChoices()),
                new ChoiceRenderer("nombreMarca", "idMarca")
        );
        form.add(ddc);

        form.add(new Button("submit") {
            private static final long serialVersionUID = -8676092495300239679L;

            @Override
            public void onSubmit() {
                //guardamos el modelo
                Marca marca = MarcaRepository.getInstance().getById(modelosModel.getMarca().getIdMarca());
                Modelo modelo = new Modelo(modelosModel.getIdModelo(), modelosModel.getNombreModelo(), marca);

                ModeloRepository.getInstance().save(modelo);
                setResponsePage(Listar.class);
            }
        });

        add(form);
    }

    private ArrayList getChoices() {
        List<Marca> marcas = MarcaRepository.getInstance().getAll();
        ArrayList list = new ArrayList();
        for (Marca m: marcas) {
            list.add(m.toModel());
        }
        return list;
    }

}
