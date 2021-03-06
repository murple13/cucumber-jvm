package cucumber.examples.java.wicket.view;

import cucumber.examples.java.wicket.Application;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.util.value.ValueMap;

public class Rent extends WebPage {
    private Application application;

    public Rent() {
        RentCarForm rentCarForm = new RentCarForm("rentCarForm");
        add(rentCarForm);

        application = (Application) getApplication();
    }

    public void rent() {
        application.rentCar();
    }

    private class RentCarForm extends Form<ValueMap> {
        public RentCarForm(String id) {
            super(id, new CompoundPropertyModel<ValueMap>(new ValueMap()));
        }

        @Override
        public final void onSubmit() {
            rent();

            setResponsePage(Available.class);
        }
    }
}
