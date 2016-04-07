package com.profiler.config.view_resolver;

import java.util.Locale;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


/**
 *
 * @author birladeanu
 */
public class JsonViewResolver implements ViewResolver {

    @Override
    public View resolveViewName(String string, Locale locale) throws Exception {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        view.setPrettyPrint(true);
        return view;
    }

}