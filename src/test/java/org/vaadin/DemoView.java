package org.vaadin;

import com.vaadin.flow.component.button.Button;
import org.vaadin.tinymce.TinyMce;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.router.Route;

@Route
public class DemoView extends Div {

    protected TinyMce tinyMce;

    public DemoView() {
        tinyMce = new TinyMce();
        tinyMce.setConfig("{"
                + "\"menubar\": false,"
                + "\"toolbar\": \"undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image\"}");

        tinyMce.setEditorContent("<p>Voi <strong>jorma</strong>!<p>");
        add(tinyMce);

        Button b = new Button("Set content dynamically", e -> {
            tinyMce.setEditorContent("New value");
        });
        add(b);

        Button b2 = new Button("Show content", e -> {
            Notification.show(tinyMce.getCurrentValue());
        });
        add(b2);

        tinyMce.addValueChangeListener(e -> {
            Notification.show("ValueChange event!");
            System.out.println(e.getValue());
        });

    }
}
