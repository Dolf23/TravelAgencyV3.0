package by.it_academy.TravelAgency.managers;

import by.it_academy.TravelAgency.constants.ConfigsConstants;

import java.util.ResourceBundle;

public enum ConfigurationManager implements Manager {
    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle(ConfigsConstants.CONFIG_SOURCE);

    @Override
    public String getProperty(String key) {
        return bundle.getString(key);
    }
}
