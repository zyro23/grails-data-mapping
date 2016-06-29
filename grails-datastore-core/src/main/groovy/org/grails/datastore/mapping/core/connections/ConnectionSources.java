package org.grails.datastore.mapping.core.connections;

import org.springframework.core.env.PropertyResolver;

/**
 * Models multiple connection sources
 *
 * @author Graeme Rocher
 * @since 6.0
 *
 * @param <T> The underlying native type of the {@link ConnectionSource}, for example a SQL {@link javax.sql.DataSource}
 */
public interface ConnectionSources<T> extends Iterable<ConnectionSource<T>> {

    /**
     * @return The factory used to create new connections
     */
    ConnectionSourceFactory getFactory();

    /**
     * @return An iterable containing all {@link ConnectionSource} instances
     */
    Iterable<ConnectionSource<T>> getAllConnectionSources();

    /**
     * Obtain a {@link ConnectionSource} by name
     *
     * @param name The name of the source
     *
     * @return A {@link ConnectionSource} or null if it doesn't exist
     */
    ConnectionSource<T> getConnectionSource(String name);

    /**
     * Obtains the default {@link ConnectionSource}
     *
     * @return The default {@link ConnectionSource}
     */
    ConnectionSource<T> getDefaultConnectSource();

    /**
     * Adds a new {@link ConnectionSource}
     *
     * @param name The name of the connection source
     * @param configuration The configuration
     * @return The {@link ConnectionSource}
     *
     * @throws org.grails.datastore.mapping.core.exceptions.ConfigurationException if the configuration is invalid
     */
    ConnectionSource<T> addConnectionSource(String name, PropertyResolver configuration);
}
