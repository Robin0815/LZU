package org.hbrs.ooka.ws2020.uebung2.web;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class WebUI extends VerticalLayout {
    public WebUI(){
        TextField textField = new TextField("");
        textField.addThemeName("bordered");

        TextArea textArea = new TextArea();
        textArea.setValue("New RuntimeEnviroment started: \nPlease type command (init, delete, start, stop, state, allstate)\n" +
                "init: needs to be followed by component name and path to jar file\n" +
                "delete, start, stop just needs the name of the component\n" +
                "allstate needs no additional infos\n" +
                "an existing config in backup.txt can be loaded by loadconfig\n");
        textArea.addKeyPressListener() {


        add(textField, textArea, b);
    }
}
