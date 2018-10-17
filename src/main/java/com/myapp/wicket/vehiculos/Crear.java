/*
 * HomePage.java
 *
 * Created on 21 de septiembre de 2018, 21:43
 */

package com.myapp.wicket.vehiculos;

import com.myapp.wicket.TemplatePage;
import com.parqueo.krpp.entities.Empleado;
import com.parqueo.krpp.entities.Marca;
import com.parqueo.krpp.entities.Modelo;
import com.parqueo.krpp.entities.Vehiculo;
import com.parqueo.krpp.modelo.ModelosModel;
import com.parqueo.krpp.modelo.VehiculosModel;
import com.parqueo.krpp.repository.EmpleadoRepository;
import com.parqueo.krpp.repository.MarcaRepository;
import com.parqueo.krpp.repository.ModeloRepository;
import com.parqueo.krpp.repository.VehiculoRepository;
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

        final VehiculosModel vehiculosModel = new VehiculosModel();

        Form<Object> form = new Form<Object>("form");

        form.add(new TextField<String>("chapa", new PropertyModel<String>(vehiculosModel, "chapa")));
        form.add(new TextField<String>("color", new PropertyModel<String>(vehiculosModel, "color")));
        form.add(new TextField<String>("anho", new PropertyModel<String>(vehiculosModel, "anho")));

        DropDownChoice ddm = new DropDownChoice("modelos",
                new PropertyModel(vehiculosModel, "modelo"),
                new Model(getChoicesModelos()),
                new ChoiceRenderer("nombreModelo", "idModelo")
        );
        form.add(ddm);

        DropDownChoice dde = new DropDownChoice("empleados",
                new PropertyModel(vehiculosModel, "empleado"),
                new Model(getChoicesEmpleados()),
                new ChoiceRenderer("nombreCompleto", "idEmpleado")
        );
        form.add(dde);

        form.add(new Button("submit") {
            private static final long serialVersionUID = -8676092495300239679L;

            @Override
            public void onSubmit() {
                //guardamos el vehiculo
                Modelo modelo = ModeloRepository.getInstance().getById(vehiculosModel.getModelo().getIdModelo());
                Empleado empleado = EmpleadoRepository.getInstance().getById(vehiculosModel.getEmpleado().getIdEmpleado());

                Vehiculo vehiculo = new Vehiculo(vehiculosModel.getIdVehiculo(), vehiculosModel.getChapa(), vehiculosModel.getColor(),
                        vehiculosModel.getAnho(), modelo, empleado);

                VehiculoRepository.getInstance().save(vehiculo);
                setResponsePage(Listar.class);
            }
        });

        add(form);
    }

    private ArrayList getChoicesModelos() {
        List<Modelo> modelos = ModeloRepository.getInstance().getAll();
        ArrayList list = new ArrayList();
        for (Modelo m: modelos) {
            list.add(m.toModel());
        }
        return list;
    }

    private ArrayList getChoicesEmpleados() {
        List<Empleado> empleados = EmpleadoRepository.getInstance().getAll();
        ArrayList list = new ArrayList();
        for (Empleado m: empleados) {
            list.add(m.toModel());
        }
        return list;
    }

}
