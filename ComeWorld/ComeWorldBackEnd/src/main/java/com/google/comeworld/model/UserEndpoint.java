package com.google.comeworld.model;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.logging.Logger;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(name = "userEndpoint", version = "v1", namespace = @ApiNamespace(ownerDomain = "model.comeworld.google.com", ownerName = "model.comeworld.google.com", packagePath=""))
public class UserEndpoint {

    // Make sure to add this endpoint to your web.xml file if this is a web application.

    private static final Logger LOG = Logger.getLogger(UserEndpoint.class.getName());

    /**
     * This method gets the <code>User</code> object associated with the specified <code>id</code>.
     * @param id The id of the object to be returned.
     * @return The <code>User</code> associated with <code>id</code>.
     */
    @ApiMethod(name = "getUser")
    public User getUser(@Named("id") Long id) {
        // Implement this function

        LOG.info("Calling getUser method");
        return null;
    }

    /**
     * This inserts a new <code>User</code> object.
     * @param user The object to be added.
     * @return The object to be added.
     */
    @ApiMethod(name = "insertUser")
    public User insertUser(User user) {
        // Implement this function

        LOG.info("Calling insertUser method");
        return user;
    }
}